package net.bbenarbia.web.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.User;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.domain.enums.EnumTypeContact;
import net.bbenarbia.service.IRoleService;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.web.dto.PasswordDTO;
import net.bbenarbia.web.dto.RoleFormDTO;
import net.bbenarbia.web.dto.RoleFormDTOList;
import net.bbenarbia.web.dto.UserDTO;
import net.bbenarbia.web.validator.PasswordValidator;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	private PasswordValidator validator;

	@Autowired
	private IRoleService roleService;

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

	@ModelAttribute("typeContactList")
	public List<String> populateContactTypeList() {

		List<String> listContactType = new LinkedList<String>();

		listContactType.add("Select the contact Type");		
		for (EnumTypeContact elt : EnumTypeContact.values()) {
			listContactType.add(elt.toString());
		}
		return listContactType;
	}

	@RequestMapping("/{userId}")
	public String showUserDetails(@PathVariable("userId") long userId, Model model) {
		User user = this.utilisateurService.get(userId);
		model.addAttribute("user",user);
		List<String> userRolesOfGroup = new LinkedList<String>();
		if(user != null && user.getUserCategory()!= null ){
			for (Role role : user.getUserCategory().getRoles()) {
				userRolesOfGroup.add(role.getName());
			}
		}
		model.addAttribute("groupRoles",userRolesOfGroup);
		return "users/userDetails";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(
			@ModelAttribute("user") @Valid UserDTO userDto,
			BindingResult result, SessionStatus status) {

		PasswordDTO passDTO = new PasswordDTO(userDto.getPassword(),
				userDto.getPasswordConfirmation());
		validator.validate(passDTO, result);
		List<UserCategory> userCategoryList = userCategoryService
				.getUserCategroryByName(userDto.getUserCategory().getName());

		User user = userDto.getUser();
		if (!userCategoryList.isEmpty()) {
			user.setUserCategory(userCategoryList.get(0));
		}
		this.utilisateurService.saveOrUpdate(user);
		
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
		
		if (result.hasErrors()) {
			return "users/createUserForm";
		} else {
			this.utilisateurService.merge(user);
			status.setComplete();
			return "redirect:/users/" + user.getId();
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		
		
		UserDTO  userDto = new UserDTO();
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
			BindingResult result,  @PathVariable("userId") Long userId, SessionStatus status) {
		try {

			if (result.hasErrors()) {
				return "users/createUserForm";
			}

			UserCategory group = userCategoryService.getUserCategroryByName(userDto.getUserCategory().getName()).get(0);
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
		validator.validate(userPassword, result);
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
}
