package net.bbenarbia.web.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.bbenarbia.domain.User;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.service.IUtilisateurService;
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
	  


	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("userGroupList")
	public Map<String,String> populateuserGroupList() {
		
		List<UserCategory> listGroups = userCategoryService.getAll();
		Map<String,String> userGroupList = new LinkedHashMap<String,String>();
		
		for (UserCategory userCategory : listGroups) {
			userGroupList.put(userCategory.getId().toString(), userCategory.getName());
		}
		return userGroupList;
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
		if (result.hasErrors()) {
			return "users/createUserForm";
		}
		
		User user = userDto.getUser();
		List<UserCategory> userCategoryList = userCategoryService.getUserCategroryByName(userDto.getUserCategory().getName());
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
		return "redirect:/userss/" + user.getId();
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


