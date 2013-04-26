package net.bbenarbia.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.User;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.domain.enums.ParameterCode;
import net.bbenarbia.service.IParameterService;
import net.bbenarbia.service.IRoleService;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.utils.ImageService;
import net.bbenarbia.web.dto.NavigationDTO;
import net.bbenarbia.web.dto.PasswordDTO;
import net.bbenarbia.web.dto.RoleFormDTO;
import net.bbenarbia.web.dto.RoleFormDTOList;
import net.bbenarbia.web.dto.UploadItem;
import net.bbenarbia.web.dto.UserDTO;
import net.bbenarbia.web.validator.UserValidator;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author benaissa
 */

@Controller
@SessionAttributes("user")
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private IUserCategoryService userCategoryService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private IRoleService roleService;

	@Autowired
	IParameterService parameterService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ModelAttribute("userGroupList")
	public List<String> populateUserGroupList() {

		List<UserCategory> listGroups = userCategoryService.getAll();
		List<String> userGroupList = new LinkedList<String>();

		userGroupList.add("Select the category group");
		for (UserCategory userCategory : listGroups) {
			userGroupList.add(userCategory.getName());
		}
		return userGroupList;
	}

	@RequestMapping(value = "/photo/{idUser}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("idUser") Long idUser)
			throws IOException {
		User user = this.utilisateurService.get(idUser);
		InputStream inputStream = new FileInputStream(user.getPhoto());
		byte[] fileContent = IOUtils.toByteArray(inputStream);
		return fileContent;
	}

	@RequestMapping("/{userId}")
	public String showUserDetails(@PathVariable("userId") long userId,
			Model model) throws Exception {
		User user = this.utilisateurService.get(userId);
		if(user != null){
		model.addAttribute("user", user);
		List<String> userRolesOfGroup = new LinkedList<String>();
		if (user != null && user.getUserCategory() != null) {
			for (Role role : user.getUserCategory().getRoles()) {
				userRolesOfGroup.add(role.getName());
			}
		}
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/users.htm", "user.gotolistuser"));
		model.addAttribute("navigations", navigations);
		
		model.addAttribute("groupRoles", userRolesOfGroup);
		return "admin/users/userDetails";
		}
		else {
			throw new Exception("User id not found");
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(
			@ModelAttribute("user") @Valid UserDTO userDto,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "admin/users/createUserForm";
		}
		userValidator.validate(userDto, result);
		if (result.hasErrors()) {
			return "admin/users/createUserForm";
		}
		List<UserCategory> userCategoryList = userCategoryService
				.getUserCategroryByName(userDto.getUserCategory().getName());

		User user = userDto.getUser();
		if (!userCategoryList.isEmpty()) {
			user.setUserCategory(userCategoryList.get(0));
		}
		else {
			result.rejectValue("userCategory.name", "usergroup.notmatch");
			return "admin/users/createUserForm";
		}
		Set<Role> rolesList = new HashSet<Role>();
		if (null != userDto.getRoleFormList().getRoles()
				&& userDto.getRoleFormList().getRoles().size() > 0) {
			for (RoleFormDTO roleDto : userDto.getRoleFormList().getRoles()) {
				if (roleDto.isIncluded()) {
					Role role = roleService.getRolesByName(
							roleDto.getRole().getName()).get(0);
					rolesList.add(role);
				}
			}
		}
		user.setRolesInternal(rolesList);
		MultipartFile photo= userDto.getPhotoFile();
		
		if (null != photo ) {
			String TEMP_DIR = parameterService
					.getParameterName(ParameterCode.TEMP_DIRECTORY.toString())
					.get(0).getValue();
				if (photo.getSize() != 0) {
					try {
						File destFile = new File(new File(TEMP_DIR),
								photo.getOriginalFilename());
						photo.transferTo(destFile);
						BufferedImage bimg = ImageIO.read(destFile);
						BufferedImage bimgResized = ImageService
								.createResizedCopy(bimg, 300, 300, true);
						File destFile1 = new File(new File(TEMP_DIR), "small_"
								+ photo.getOriginalFilename());
						ImageIO.write(bimgResized, "jpeg", destFile1);
						user.setPhoto(TEMP_DIR
								+ photo.getOriginalFilename());
					} catch (IOException e) {
						result.rejectValue("photoFile", "photoFile.error");
						return "admin/users/createUserForm";
					}
				}
		}
			this.utilisateurService.save(user);
			status.setComplete();
			return "redirect:/users/" + user.getId();
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initFindForm(Model model) {

		UserDTO userDto = new UserDTO();
		RoleFormDTOList listFormDto = new RoleFormDTOList();

		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
		List<Role> allRolesList = roleService.getAll();

		for (Role role : allRolesList) {
			roleFormList.add(new RoleFormDTO(role, false));
		}
		listFormDto.setRoles(roleFormList);
		userDto.setRoleFormList(listFormDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/users.htm", "user.gotolistuser"));
		model.addAttribute("navigations", navigations);		
		model.addAttribute("user", userDto);
		return "admin/users/createUserForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserList(Model model) {

		Collection<User> results = this.utilisateurService.getAll();
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		model.addAttribute("selections", results);
		return "admin/users/usersList";
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	public String initUpdateUserForm(@PathVariable("userId") Long userId,
			Model model) throws Exception {
		User user = this.utilisateurService.get(userId);
		if(user != null){
		
		UserDTO userDto = new UserDTO(user);

		RoleFormDTOList listFormDto = new RoleFormDTOList();

		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
		List<Role> allRolesList = roleService.getAll();

		for (Role role : allRolesList) {
			if (user.getRoles() != null && user.getRoles().contains(role)) {
				roleFormList.add(new RoleFormDTO(role, true));
			} else {
				roleFormList.add(new RoleFormDTO(role, false));
			}
		}
		listFormDto.setRoles(roleFormList);
		userDto.setRoleFormList(listFormDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/users.htm", "user.gotolistuser"));
		navigations.add(new NavigationDTO("/users/"+userId+".htm", "user.action.details"));
		model.addAttribute("navigations", navigations);
		
		model.addAttribute("user", userDto);
		return "admin/users/updateUserForm";
		}
		else {
			throw new Exception("User id not found");
		}
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String processUpdateUserForm(@Valid UserDTO userDto,
			BindingResult result, @PathVariable("userId") Long userId,
			SessionStatus status) {
			if (result.hasErrors()) {				
				return "admin/users/updateUserForm";
			}

			UserCategory group = userCategoryService.getUserCategroryByName(
					userDto.getUserCategory().getName()).get(0);
			User user = this.utilisateurService.get(userId);
			user = userDto.updateUser(user);
			user.setUserCategory(group);

			Set<Role> rolesList = new HashSet<Role>();
			if (null != userDto.getRoleFormList().getRoles()
					&& userDto.getRoleFormList().getRoles().size() > 0) {
				for (RoleFormDTO roleDto : userDto.getRoleFormList().getRoles()) {
					if (roleDto.isIncluded()) {
						Role role = roleService.getRolesByName(
								roleDto.getRole().getName()).get(0);
						rolesList.add(role);
					}
				}
			}
			user.setRolesInternal(rolesList);

			utilisateurService.merge(user);
			status.setComplete();
			return "redirect:/users/" + user.getId();
	}

	@RequestMapping(value = "/{userId}/editpassword", method = RequestMethod.GET)
	public String updatePasswordForm(@PathVariable("userId") Long userId,
			Model model) throws Exception {
		User user = utilisateurService.get(userId);
		if(user != null){
		PasswordDTO userPassword = new PasswordDTO();
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/users.htm", "user.gotolistuser"));
		navigations.add(new NavigationDTO("/users/"+userId+".htm", "user.action.details"));
		model.addAttribute("navigations", navigations);
		model.addAttribute("userPassword", userPassword);
		return "admin/users/updatePasswordUserForm";
	}
		else {
			throw new Exception("User id not found");
		}
	}

	@RequestMapping(value = "/{userId}/editpassword", method = RequestMethod.POST)
	public String processUpdatePasswordForm(
			@ModelAttribute("userPassword") @Valid PasswordDTO userPassword,
			BindingResult result, @PathVariable("userId") Long userId,
			SessionStatus status) {
		userValidator.validate(userPassword, result);
		if (result.hasErrors()) {
			return "admin/users/updatePasswordUserForm";
		}
		boolean isValid = this.utilisateurService.updatePassword(userId,
				userPassword.getOldPassword(), userPassword.getPassword());
		status.setComplete();
		if (!isValid) {
			result.rejectValue("oldPassword", "oldPassword.wrongpassword");
			return "admin/users/updatePasswordUserForm";
		} else {
			return "redirect:/users/" + userId;
		}
	}

	@RequestMapping(value = "/upload/{userId}/show", method = RequestMethod.GET)
	public String getUploadForm(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute(new UploadItem());
		model.addAttribute("bienId", userId);
		model.addAttribute("nbFiles", 1);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/users.htm", "user.gotolistuser"));
		navigations.add(new NavigationDTO("/users/"+userId+".htm", "user.action.details"));
		return "admin/users/uploadPhotoForm";
	}
	
	@RequestMapping(value = "/{userId}/activate-user", method = RequestMethod.GET)
	public String activateUser(@PathVariable("userId") Long userId, Model model, SessionStatus status)throws  Exception{
		
		User user = utilisateurService.get(userId);
		if(user != null){
			user.setLocked(false);
			utilisateurService.merge(user);
			status.setComplete();
		}
		else {
			throw new Exception("User id not found");
		}
		return "redirect:/users/" + userId;
	}
	
	@RequestMapping(value = "/{userId}/lock-user", method = RequestMethod.GET)
	public String blockUser(@PathVariable("userId") Long userId, Model model,SessionStatus status)throws  Exception{
		
		User user = utilisateurService.get(userId);
		if(user != null){
			user.setLocked(true);
			utilisateurService.merge(user);
			status.setComplete();
		}
		else {
			throw new Exception("User id not found");
		}
		return "redirect:/users/" + userId;
	}
	

	@RequestMapping(value = "/upload/{userId}/save", method = RequestMethod.POST)
	public String uploadAndSavePhotos(
			@ModelAttribute("uploadForm") UploadItem uploadForm,
			@PathVariable("userId") long userId, Model map) {

		User user = this.utilisateurService.get(userId);

		List<MultipartFile> files = uploadForm.getFiles();

		if (null != files && files.size() > 0) {
			String TEMP_DIR = parameterService
					.getParameterName(ParameterCode.TEMP_DIRECTORY.toString())
					.get(0).getValue();

			for (MultipartFile multipartFile : files) {
				if (multipartFile.getSize() != 0) {
					try {
						File destFile = new File(new File(TEMP_DIR),
								multipartFile.getOriginalFilename());
						multipartFile.transferTo(destFile);
						BufferedImage bimg = ImageIO.read(destFile);
						BufferedImage bimgResized = ImageService
								.createResizedCopy(bimg, 300, 300, true);
						File destFile1 = new File(new File(TEMP_DIR), "small_"
								+ multipartFile.getOriginalFilename());
						ImageIO.write(bimgResized, "jpeg", destFile1);
						user.setPhoto(TEMP_DIR
								+ multipartFile.getOriginalFilename());
					} catch (IOException e) {
						return "admin/users/uploadPhotoForm";
					}
				}
			}
			utilisateurService.merge(user);
		}
		return "redirect:/users/" + userId;
	}
}
