package net.bbenarbia.tassyir.beans.users;

import java.util.Collection;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import net.bbenarbia.domain.User;
import net.bbenarbia.service.IUtilisateurService;

@ManagedBean(name = "userManagedBean")
@SessionScoped
public class UserManagedBean {

	private Collection<User> userList;
	private String login;

	private String firstName;

	private String lastName;

	private Collection<User> listUserFounds;
	private String codeUser;
	private User foundUser;

	@ManagedProperty(name = "utilisateurService", value = "#{utilisateurService}")
	private IUtilisateurService utilisateurService;

	public String getDetailsUser() {

		FacesContext fc = FacesContext.getCurrentInstance();

		Map<String, String> params = fc.getExternalContext()
				.getRequestParameterMap();

		codeUser = params.get("codeUser");
		foundUser = utilisateurService.getUtilisateurByCode(Long
				.parseLong(codeUser));
		return "detailsUser";
	}

	public void reset() {
		this.setLogin("");
		this.setFirstName("");
		this.setLastName("");
	}

	public Collection<User> getUserList() {
		userList = utilisateurService.getAll();
		return userList;
	}

	public String search() {

		try {
			listUserFounds = utilisateurService
					.getUtilisateursByFirstName(firstName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Collection<User> getListUserFounds() {
		return listUserFounds;
	}

	public void setListUserFounds(Collection<User> listUserFounds) {
		this.listUserFounds = listUserFounds;
	}

	public IUtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getFoundUser() {
		return foundUser;
	}

	public void setFoundUser(User foundUser) {
		this.foundUser = foundUser;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

}