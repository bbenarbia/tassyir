package net.bbenarbia.web.dto;


import javax.validation.Valid;

import net.bbenarbia.domain.User;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class UserDTO { 
	
	private String id;
	@NotEmpty(message="Code must not be empty.")
	@NumberFormat(style= Style.NUMBER)
	private String code;
	@NotEmpty(message="First name must not be empty.")
	private String firstName;
	@NotEmpty(message="Last name must not be empty.")
	private String lastName;
	@NotEmpty(message="login name must not be empty.")
	private String login;
	private String password;
	private String passwordConfirmation;
	private Boolean locked;
	private Boolean isAdmin;
	@Valid
	private ContactDTO contact;
	private UserCategoryDTO userCategory;

	private RoleFormDTOList roleFormList;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		super();
		this.id = String.valueOf(user.getId());
		this.code = String.valueOf(user.getCode());
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.passwordConfirmation = user.getPassword();
		this.locked = user.getLocked();
		this.isAdmin = user.getIsAdmin();
		this.contact = new ContactDTO(user.getContact());
		this.userCategory = new UserCategoryDTO(user.getUserCategory());
	}

	
	public User getUserWithoutPassword(){
		User user = new User();
		
		if(id!= null){
			user.setId(Long.valueOf(id));
		}
		user.setCode(Long.valueOf(code));
		user.setContact(contact.getContact());
		user.setFirstName(firstName);
		user.setIsAdmin(isAdmin);
		user.setLastName(lastName);
		user.setLocked(locked);
		user.setLogin(login);
		user.setUserCategory(userCategory.getUserCategory());
		return user;
	}
	
	
	public User getUser(){
		User user = getUserWithoutPassword();
		user.setPassword(password);
		return user;
	}
	
	
	public User updateUser(User user){
		
		user.setCode(Long.valueOf(code));
//		user.setContact(contact.getContact());
		user.setFirstName(firstName);
		user.setIsAdmin(isAdmin);
		user.setLastName(lastName);
		user.setLocked(locked);
		user.setLogin(login);
//		if(password.equals(passwordConfirmation)){
//			user.setPassword(password);
//		}else throw new Exception("Password not confirmed");
		user.setContact(contact.updateContact(user.getContact()));
		user.setUserCategory(userCategory.getUserCategory());
		return user;
	}
	
	
	public UserDTO(Long id, Long code, String firstName, String lastName, String login,
			String password, Boolean connected, Boolean locked,
			Boolean isAdmin, String userCategoryName, ContactDTO contact, UserCategoryDTO userCategory) {
		super();
		this.id = String.valueOf(id);
		this.code = String.valueOf(code);
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.locked = locked;
		this.isAdmin = isAdmin;
		this.contact = contact;
		this.userCategory = userCategory;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public ContactDTO getContact() {
		return contact;
	}

	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserCategoryDTO getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategoryDTO userCategory) {
		this.userCategory = userCategory;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public RoleFormDTOList getRoleFormList() {
		return roleFormList;
	}

	public void setRoleFormList(RoleFormDTOList roleFormList) {
		this.roleFormList = roleFormList;
	}

	
}
