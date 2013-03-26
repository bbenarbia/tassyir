package net.bbenarbia.web.validator;

import net.bbenarbia.web.dto.PasswordDTO;
import net.bbenarbia.web.dto.UserDTO;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class c) {
		return UserDTO.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		PasswordDTO regBean = (PasswordDTO) command;
		if (!regBean.getPassword().equals(regBean.getPasswordConfirmation())){
			errors.rejectValue("passwordConfirmation", "passwordConfirmation.notmatch");
		}
//		if(regBean.getUserCategory().getName().contains("Select the ") ){
//			errors.rejectValue("userCategory", "user category error");
//		}
//		if(regBean.getContact().getTypeContact().contains("Select the ") ){
//			errors.rejectValue("typeContact", "typeContact error");
//		}
	}
}
