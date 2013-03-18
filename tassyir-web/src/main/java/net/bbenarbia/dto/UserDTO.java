package net.bbenarbia.dto;

import net.bbenarbia.domain.User;

public class UserDTO {

	private Long id;
	private Long code;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String passwordConfirmation;
	private Boolean connected;
	private Boolean locked;
	private Boolean isAdmin;
//	private String userCategoryName;
	private ContactDTO contact;
	private UserCategoryDTO userCategory;

	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.code = user.getCode();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.connected = user.getConnected();
		this.locked = user.getLocked();
		this.isAdmin = user.getIsAdmin();
		this.contact = new ContactDTO(user.getContact());
		this.userCategory = new UserCategoryDTO(user.getUserCategory());
	}

	
	public User getUser(){
		User user = new User();
		
		user.setId(id);
		user.setCode(code);
		user.setConnected(connected);
		user.setContact(contact.getContact());
		user.setFirstName(firstName);
		user.setIsAdmin(isAdmin);
		user.setLastName(lastName);
		user.setLocked(locked);
		user.setLogin(login);
		user.setPassword(password);
		user.setUserCategory(userCategory.getUserCategory());
		return user;
	}
	
	
	public User updateUser(User user)throws Exception{
		
		user.setCode(code);
		user.setConnected(connected);
		user.setContact(contact.getContact());
		user.setFirstName(firstName);
		user.setIsAdmin(isAdmin);
		user.setLastName(lastName);
		user.setLocked(locked);
		user.setLogin(login);
		if(password.equals(passwordConfirmation)){
			user.setPassword(password);
		}else throw new Exception("Password not confirmed");
		user.setContact(contact.getContact());
		return user;
	}
	
	
	public UserDTO(Long id, Long code, String firstName, String lastName, String login,
			String password, Boolean connected, Boolean locked,
			Boolean isAdmin, String userCategoryName, ContactDTO contact, UserCategoryDTO userCategory) {
		super();
		this.id = id;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.connected = connected;
		this.locked = locked;
		this.isAdmin = isAdmin;
		this.contact = contact;
		this.userCategory = userCategory;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
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

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
