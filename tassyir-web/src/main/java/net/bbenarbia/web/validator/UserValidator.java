package net.bbenarbia.web.validator;

import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.web.dto.PasswordDTO;
import net.bbenarbia.web.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private IUtilisateurService utilisateurService;
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean supports(Class c) {
		return UserDTO.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		if(command.getClass().equals(UserDTO.class)){
		UserDTO userBean = (UserDTO) command;
		if (!userBean.getPassword().equals(userBean.getPasswordConfirmation())){
			errors.rejectValue("passwordConfirmation", "passwordConfirmation.notmatch");
		}
		
		if(utilisateurService.existeLogin(userBean.getLogin())){
			errors.rejectValue("login", "login.exists");
		}
		try {
			if(utilisateurService.userCodeExists(Long.valueOf(userBean.getCode()))){
				errors.rejectValue("code", "code.exists");
			}
		} catch (NumberFormatException e) {
			errors.rejectValue("code", "code.error");
		}
		
	}
		else if(command.getClass().equals(PasswordDTO.class)){
			PasswordDTO passwordBean = (PasswordDTO) command;
			if (!passwordBean.getPassword().equals(passwordBean.getPasswordConfirmation())){
				errors.rejectValue("passwordConfirmation", "passwordConfirmation.notmatch");
			}
		}
	}
		
}