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
//@SessionAttributes(types = User.class)
public class UserController {

	
    @Autowired
	private IUtilisateurService utilisateurService;;


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public String initCreationForm(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "users/createOrUpdateUserForm";
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "users/createOrUpdateUserForm";
        } else {
            this.utilisateurService.save(user);
            status.setComplete();
            return "redirect:/users/" + user.getId();
        }
    }

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public String initFindForm(Model model) {
        model.addAttribute("user", new User());
        return "users/findUsers";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String processFindForm(User user, BindingResult result, Model model) {

        // allow parameterless GET request for /owners to return all records
        if (user.getLastName() == null) {
        	user.setLastName(""); // empty string signifies broadest possible search
        }

        Collection<User> results = this.utilisateurService.getUtilisateursByName(user.getLastName());
        if (results.size() < 1) {
            result.rejectValue("lastName", "notFound", "not found");
            return "users/findUsers";
        }
        if (results.size() > 1) {
            model.addAttribute("selections", results);
            return "users/usersList";
        } else {
            user = results.iterator().next();
            return "redirect:/users/" + user.getId();
        }
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.GET)
    public String initUpdateUserForm(@PathVariable("userId") int userId, Model model) {
        User user = this.utilisateurService.get(userId);
        model.addAttribute(user);
        return "users/createOrUpdateUserForm";
    }

    @RequestMapping(value = "/users/{userId}/edit", method = RequestMethod.PUT)
    public String processUpdateUserForm(@Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "users/createOrUpdateUserForm";
        } else {
            this.utilisateurService.save(user);
            status.setComplete();
            return "redirect:/users/{userId}";
        }
    }

    /**
     * Custom handler for displaying an owner.
     *
     * @param ownerId the ID of the owner to display
     * @return a ModelMap with the model attributes for the view
     */
    @RequestMapping("/users/{userId}")
    public ModelAndView showOwner(@PathVariable("userId") int userId) {
        ModelAndView mav = new ModelAndView("users/userDetails");
        mav.addObject(this.utilisateurService.get(userId));
        return mav;
    }

}
