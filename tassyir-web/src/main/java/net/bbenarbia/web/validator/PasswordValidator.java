package net.bbenarbia.web.validator;

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
		UserDTO regBean = (UserDTO) command;
		if (!regBean.getPassword().equals(regBean.getPasswordConfirmation()))
			errors.rejectValue("passwordConfirmation", "passwordConfirmation.notmatch");
	}

}
