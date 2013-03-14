package net.bbenarbia.controller;

import java.util.Collection;

import javax.validation.Valid;

import net.bbenarbia.domain.Contact;
import net.bbenarbia.service.IContactService;

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
@SessionAttributes("contact")
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private IContactService contactService;;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping("/{contactId}")
	public ModelAndView showContact(@PathVariable("contactId") long contactId) {
		ModelAndView mav = new ModelAndView("contacts/contactDetails");
		mav.addObject(this.contactService.get(contactId));
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Contact contact, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "contacts/createOrUpdateContactForm";
		} else {
			this.contactService.saveOrUpdate(contact);
			status.setComplete();
			return "redirect:/contacts/" + contact.getId();
		}
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("contact", new Contact());
		return "contacts/findContacts";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String processFindForm(Model model) {

		Collection<Contact> results = this.contactService.getAll();
		model.addAttribute("selections", results);
		return "contacts/contactsList";
	}
	
	@RequestMapping(value = "/{contactId}", method = RequestMethod.POST)
	public String update(Contact contact, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("contact", contact);
			return "contacts/createOrUpdateContactForm";
		}
		uiModel.asMap().clear();
		contactService.saveOrUpdate(contact);
		return "redirect:/contactss/" + contact.getId();
	}
	
	
	@RequestMapping(value = "/{contactId}/edit", method = RequestMethod.GET)
	public String initUpdateContactForm(@PathVariable("contactId") Long contactId,
			Model model) {
		Contact contact = this.contactService.get(contactId);
		model.addAttribute("contact",contact);
		return "contacts/createOrUpdateContactForm";
	}
	
	@RequestMapping(value = "/{contactId}/edit", method = RequestMethod.POST)
	public String processUpdateContactForm(@Valid Contact contact, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "contacts/createOrUpdateContactForm";
		} else {
			contactService.saveOrUpdate(contact);
			status.setComplete();
			return "redirect:/contacts/"+contact.getId();
		}
	}
}

