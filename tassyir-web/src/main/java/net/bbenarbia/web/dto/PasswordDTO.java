package net.bbenarbia.web.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;

public class PasswordDTO {

	@List({
	    @Length(min = 2, message = "The password must be at least 2 characters"),
	    @Length(max = 50, message = "The password must be less than 50 characters")
	})
	private String oldPassword;

	@List({
	    @Length(min = 2, message = "The password must be at least 2 characters"),
	    @Length(max = 50, message = "The password must be less than 50 characters")
	})
	private String password;
	@List({
	    @Length(min = 2, message = "The password must be at least 2 characters"),
	    @Length(max = 50, message = "The password must be less than 50 characters")
	})
	private String passwordConfirmation;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public PasswordDTO() {
		super();
	}

	public PasswordDTO(String password, String passwordConfirmation) {
		super();
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}
