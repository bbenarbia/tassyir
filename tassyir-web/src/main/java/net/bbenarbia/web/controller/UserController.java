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
import org.springframework.web.servlet.ModelAndView;

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
	private IUserCategoryService userCategoryService;;

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
			userGroupList.add(userCategory.getName().toUpperCase());
		}
		return userGroupList;
	}
	
	@ModelAttribute("typeContactList")
	public List<String> populateContactTypeList() {
		
		List<String> listContactType = new LinkedList<String>();
		
		listContactType.add("Select the contact Type");
		listContactType.add(EnumTypeContact.Client.toString().toUpperCase());
		listContactType.add(EnumTypeContact.Employe.toString().toUpperCase());
		listContactType.add(EnumTypeContact.Fournisseur.toString().toUpperCase());
		listContactType.add(EnumTypeContact.Magasin.toString().toUpperCase());
		listContactType.add(EnumTypeContact.Perso.toString().toUpperCase());
		
		return listContactType;
	}
	
	
	@RequestMapping("/{userId}")
	public ModelAndView showUser(@PathVariable("userId") long userId) {
		ModelAndView mav = new ModelAndView("users/userDetails");
		mav.addObject(this.utilisateurService.get(userId));
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(@ModelAttribute("user") @Valid UserDTO userDto, BindingResult result,
			SessionStatus status) {
		
		validator.validate(userDto, result);
		List<UserCategory> userCategoryList = userCategoryService.getUserCategroryByName(userDto.getUserCategory().getName());
		
		if (result.hasErrors()) {
			return "users/createUserForm";
		}
		
		User user = userDto.getUser();
		if(!userCategoryList.isEmpty()){
			user.setUserCategory(userCategoryList.get(0));
		}
		if (result.hasErrors()) {
			return "users/createUserForm";
		} else {
			this.utilisateurService.saveOrUpdate(user);
			status.setComplete();
			return "redirect:/users/" + user.getId();
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("user", new UserDTO());
		return "users/createUserForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String processFindForm(Model model) {

		Collection<User> results = this.utilisateurService.getAll();
		model.addAttribute("selections", results);
		return "users/usersList";
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public String update(User user, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("user", user);
			return "users/updateUserForm";
		}
		uiModel.asMap().clear();
		utilisateurService.saveOrUpdate(user);
		return "redirect:/users/" + user.getId();
	}
	
	@RequestMapping(value = "/{userId}/roles", method = RequestMethod.GET)
	public String rolesUserForm(@PathVariable("userId") Long userId,
			Model model) {
		
		RoleFormDTOList listFormDto = new RoleFormDTOList();
		
		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
		User user = this.utilisateurService.get(userId);
		List<Role> allRolesList = roleService.getAll();
		
		for (Role role : allRolesList) {
			if(user.getRoles() != null && user.getRoles().contains(role)){
				roleFormList.add(new RoleFormDTO(role, true));
			}
			else {
				roleFormList.add(new RoleFormDTO(role, false));
			}
		}
		listFormDto.setRoles(roleFormList);
		model.addAttribute("userId", userId);
		model.addAttribute("roleFormList", listFormDto);
		return "users/rolesList";
	}
	
	
	
	@RequestMapping(value = "/{userId}/roles/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("roleFormList") RoleFormDTOList roleFormList, @PathVariable("userId") Long userId) {
     
		User user = this.utilisateurService.get(userId);
		Set<Role> rolesList = new HashSet<Role>();
		 if(null != roleFormList.getRoles() && roleFormList.getRoles().size() > 0) {
	            for (RoleFormDTO roleDto : roleFormList.getRoles()) {
	            	if(roleDto.isIncluded()){
	            		Role role = roleService.getRolesByName(roleDto.getRole().getName()).get(0);
	            		rolesList.add(role);
	            	}
	            }
	        }
		 user.setRolesInternal(rolesList);
		 utilisateurService.saveOrUpdate(user);
		 return "users/usersList";     
	}
	
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	public String initUpdateUserForm(@PathVariable("userId") Long userId,
			Model model) {
		User user = this.utilisateurService.get(userId);
		UserDTO userDto = new UserDTO(user);
		model.addAttribute("user",userDto);
		return "users/updateUserForm";
	}
	
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String processUpdateUserForm(@Valid UserDTO userDto,  BindingResult result,
			SessionStatus status) {
		try {
			
			if (result.hasErrors()) {
				return "users/createUserForm";
			}
			
			User user = this.utilisateurService.getUtilisateurByCode(Long.valueOf(userDto.getCode()));
			user = userDto.updateUser(user);
			if (result.hasErrors()) {
				return "users/updateUserForm";
			} else {
					utilisateurService.saveOrUpdate(user);
				status.setComplete();
				return "redirect:/users/"+user.getId();
			}
		} catch (Exception e) {
			return "users/updateUserForm";
		}
	}
	
	

	public void setValidator(PasswordValidator validator) {
		this.validator = validator;
	}

}


