package net.bbenarbia.controller;

import java.util.Collection;

import javax.validation.Valid;

import net.bbenarbia.domain.User;
import net.bbenarbia.service.IUtilisateurService;

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
	private IUtilisateurService utilisateurService;;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping("/{userId}")
	public ModelAndView showUser(@PathVariable("userId") long userId) {
		ModelAndView mav = new ModelAndView("users/userDetails");
		mav.addObject(this.utilisateurService.get(userId));
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(@ModelAttribute("user") @Valid User user, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "users/createOrUpdateUserForm";
		} else {
			this.utilisateurService.saveOrUpdate(user);
			status.setComplete();
			return "redirect:/users/" + user.getId();
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("user", new User());
		return "users/createOrUpdateUserForm";
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
			return "users/createOrUpdateUserForm";
		}
		uiModel.asMap().clear();
		utilisateurService.saveOrUpdate(user);
		return "redirect:/userss/" + user.getId();
	}
	
	
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
	public String initUpdateUserForm(@PathVariable("userId") Long userId,
			Model model) {
		User user = this.utilisateurService.get(userId);
		model.addAttribute("user",user);
		return "users/createOrUpdateUserForm";
	}
	
	@RequestMapping(value = "/{userId}/edit", method = RequestMethod.POST)
	public String processUpdateUserForm(@Valid User user, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "users/createOrUpdateUserForm";
		} else {
				utilisateurService.saveOrUpdate(user);
			status.setComplete();
			return "redirect:/users/"+user.getId();
		}
	}
}


