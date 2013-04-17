package net.bbenarbia.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import net.bbenarbia.web.dto.PasswordDTO;
import net.bbenarbia.web.dto.RoleFormDTO;
import net.bbenarbia.web.dto.RoleFormDTOList;
import net.bbenarbia.web.dto.UploadItem;
import net.bbenarbia.web.dto.UserDTO;
import net.bbenarbia.web.validator.UserValidator;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
			Model model) {
		User user = this.utilisateurService.get(userId);
		model.addAttribute("user", user);
		List<String> userRolesOfGroup = new LinkedList<String>();
		if (user != null && user.getUserCategory() != null) {
			for (Role role : user.getUserCategory().getRoles()) {
				userRolesOfGroup.add(role.getName());
			}
		}
		model.addAttribute("groupRoles", userRolesOfGroup);
		return "users/userDetails";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(
			@ModelAttribute("user") @Valid UserDTO userDto,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "users/createUserForm";
		}
		userValidator.validate(userDto, result);
		if (result.hasErrors()) {
			return "users/createUserForm";
		}
		List<UserCategory> userCategoryList = userCategoryService
				.getUserCategroryByName(userDto.getUserCategory().getName());

		User user = userDto.getUser();
		if (!userCategoryList.isEmpty()) {
			user.setUserCategory(userCategoryList.get(0));
		}
		else {
			result.rejectValue("userCategory.name", "usergroup.notmatch");
			return "users/createUserForm";
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
						return "users/createUserForm";
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

		model.addAttribute("user", userDto);
		return "users/createUserForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUserList(Model model) {

		Collection<User> results = this.utilisateurService.getAll();
		model.addAttribute("selections", results);
		return "users/usersList";
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	public String initUpdateUserForm(@PathVariable("userId") Long userId,
			Model model) {
		User user = this.utilisateurService.get(userId);
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

		model.addAttribute("user", userDto);
		return "users/updateUserForm";
	}

	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String processUpdateUserForm(@Valid UserDTO userDto,
			BindingResult result, @PathVariable("userId") Long userId,
			SessionStatus status) {
		try {

			if (result.hasErrors()) {
				return "users/createUserForm";
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
		} catch (Exception e) {
			return "users/updateUserForm";
		}
	}

	@RequestMapping(value = "/{userId}/editpassword", method = RequestMethod.GET)
	public String updatePasswordForm(@PathVariable("userId") Long userId,
			Model model) {
		PasswordDTO userPassword = new PasswordDTO();
		model.addAttribute("userPassword", userPassword);
		return "users/updatePasswordUserForm";
	}

	@RequestMapping(value = "/{userId}/editpassword", method = RequestMethod.POST)
	public String processUpdatePasswordForm(
			@ModelAttribute("userPassword") PasswordDTO userPassword,
			BindingResult result, @PathVariable("userId") Long userId,

			SessionStatus status) {
		userValidator.validate(userPassword, result);
		if (result.hasErrors()) {
			return "users/updatePasswordUserForm";
		}
		boolean isValid = this.utilisateurService.updatePassword(userId,
				userPassword.getOldPassword(), userPassword.getPassword());
		status.setComplete();
		if (!isValid) {
			result.rejectValue("oldPassword", "oldPassword.wrongpassword");
			return "users/updatePasswordUserForm";
		} else {
			return "redirect:/users/" + userId;
		}
	}

	@RequestMapping(value = "/upload/{userId}/show", method = RequestMethod.GET)
	public String getUploadForm(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute(new UploadItem());
		model.addAttribute("bienId", userId);
		model.addAttribute("nbFiles", 1);
		return "upload/uploadForm";
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
						return "upload/uploadForm";
					}
				}
			}
			utilisateurService.merge(user);
		}
		return "redirect:/users/" + userId;
	}
}
