package net.bbenarbia.web.controller;

import java.util.Collection;

import javax.validation.Valid;

import net.bbenarbia.domain.Parameter;
import net.bbenarbia.service.IParameterService;

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
@SessionAttributes("parameter")
@RequestMapping("/parameters")
public class ParameterController {

	@Autowired
	private IParameterService parameterService;

//	@Autowired
//	private PasswordValidator validator;
	  


	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(@ModelAttribute("parameter") @Valid Parameter parameter, BindingResult result,
			SessionStatus status) {
		
		if (result.hasErrors()) {
			return "parameters/createParameterForm";
		} else {
			this.parameterService.saveOrUpdate(parameter);
			status.setComplete();
			return "redirect:/parameters/" + parameter.getId();
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("parameter", new Parameter());
		return "parameters/createParameterForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String processFindForm(Model model) {

		Collection<Parameter> results = this.parameterService.getAll();
		model.addAttribute("selections", results);
		return "parameters/parametersList";
	}
	
	
	@RequestMapping(value = "/{parameterId}", method = RequestMethod.POST)
	public String update(Parameter parameter, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("parameter", parameter);
			return "parameters/updateParameterForm";
		}
		uiModel.asMap().clear();
		parameterService.saveOrUpdate(parameter);
		return "redirect:/parameters/" + parameter.getId();
	}
	
	
	@RequestMapping(value = "/{parameterId}/edit", method = RequestMethod.GET)
	public String initUpdateParameterForm(@PathVariable("parameterId") Long parameterId,
			Model model) {
		Parameter parameter = this.parameterService.get(parameterId);
		model.addAttribute("parameter",parameter);
		return "parameters/updateParameterForm";
	}
	
	@RequestMapping(value = "/{parameterId}/edit", method = RequestMethod.POST)
	public String processUpdateParameterForm(@Valid Parameter parameter,  BindingResult result,
			SessionStatus status) {
		try {
			
			if (result.hasErrors()) {
				return "parameters/createParameterForm";
			} else {
					parameterService.saveOrUpdate(parameter);
				status.setComplete();
				return "redirect:/parameters/"+parameter.getId();
			}
		} catch (Exception e) {
			return "parameters/updateParameterForm";
		}
	}
	
	
//
//	public void setValidator(PasswordValidator validator) {
//		this.validator = validator;
//	}

}


