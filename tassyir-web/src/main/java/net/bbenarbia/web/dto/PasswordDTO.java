package net.bbenarbia.web.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class PasswordDTO {

	private String oldPassword;

	@NotEmpty(message = "password must not be empty.")
	private String password;
	@NotEmpty(message = "password must not be empty.")
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
