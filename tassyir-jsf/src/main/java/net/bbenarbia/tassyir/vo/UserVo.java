package net.bbenarbia.tassyir.vo;

import net.bbenarbia.domain.User;

public class UserVo {

	private Long id;

	private String firstName;

	private String lastName;

	private String login;

	private String password;

	private Boolean connected;

	private Boolean locked;

	private Boolean isAdmin;

	private ContactVo contact;

	
	public UserVo() {
		super();
	}
	
	

	public UserVo(Long id, String firstName, String lastName, String login,
			String password, Boolean connected, Boolean locked,
			Boolean isAdmin, ContactVo contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.connected = connected;
		this.locked = locked;
		this.isAdmin = isAdmin;
		this.contact = contact;
	}

	public UserVo(User user) {
		super();
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.connected = user.getConnected();
		this.locked = user.getLocked();
		this.isAdmin = user.getIsAdmin();
		this.contact = new ContactVo(user.getContact());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ContactVo getContact() {
		return contact;
	}

	public void setContact(ContactVo contact) {
		this.contact = contact;
	}

}
