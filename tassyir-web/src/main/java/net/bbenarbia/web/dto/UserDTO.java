package net.bbenarbia.web.dto;

import java.util.ArrayList;

import javax.validation.constraints.Pattern;

import net.bbenarbia.domain.User;
import net.bbenarbia.domain.base.Contact;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.domain.immobilier.Maison;
import net.bbenarbia.domain.immobilier.Studio;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

public class UserDTO {

	private String id;
	@NotEmpty(message = "Code must not be empty.")
	@NumberFormat(style = Style.NUMBER)
	private String code;
	@List({
	    @Length(min = 2, message = "The first name must be at least 2 characters"),
	    @Length(max = 50, message = "The first name must be less than 50 characters")
	})
	private String firstName;
	@List({
	    @Length(min = 2, message = "The lastName must be at least 5 characters"),
	    @Length(max = 50, message = "The lastName must be less than 50 characters")
	})
	private String lastName;
	@List({
	    @Length(min = 2, message = "The login must be at least 2 characters"),
	    @Length(max = 50, message = "The login must be less than 50 characters")
	})
	private String login;
	@List({
	    @Length(min = 2, message = "The password must be at least 2 characters"),
	    @Length(max = 50, message = "The password must be less than 50 characters")
	})
	private String password;
	private String passwordConfirmation;
	private Boolean locked;
	private Boolean isAdmin;
	@List({
	    @Length(min = 2, message = "The adresse must be at least 2 characters"),
	    @Length(max = 50, message = "The adresse must be less than 50 characters")
	})
	private String adresse;
	@NotEmpty(message = "code postal must not be empty.")
	private String codePostal;
	@List({
	    @Length(min = 2, message = "ville must be at least 2 characters"),
	    @Length(max = 50, message = "ville must be less than 50 characters")
	})
	private String ville;
	private Boolean alerteSurTelephone1;
	private Boolean alerteSurTelephone2;
	@NotEmpty(message = "mail must not be empty.")
	@Email
	private String adresseMail;
	private String siteWeb;
	@Pattern(regexp="(^$|[0-9]*)")
	private String telephonePerso;
	@Pattern(regexp="(^$|[0-9]*)")
	private String telephoneProf;
	@NotEmpty(message = "mobile must not be empty.")
	@Pattern(regexp="(^$|[0-9]*)")
	private String telephoneMobile;

	private UserCategoryDTO userCategory;

	private RoleFormDTOList roleFormList;
	
	private MultipartFile photoFile;
	
	private java.util.List<BienDTO> biens = new ArrayList<BienDTO>();

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
		this.adresse = user.getContact().getAdresse();
		this.codePostal = user.getContact().getCodePostal();
		this.ville = user.getContact().getVille();
		this.alerteSurTelephone1 = user.getContact().getAlerteSurTelephone1();
		this.alerteSurTelephone2 = user.getContact().getAlerteSurTelephone2();
		this.adresseMail = user.getContact().getAdresseMail();
		this.siteWeb = user.getContact().getSiteWeb();
		this.telephonePerso = user.getContact().getTelephonePerso();
		this.telephoneProf = user.getContact().getTelephoneProf();
		this.telephoneMobile = user.getContact().getTelephoneMobile();
		this.userCategory = new UserCategoryDTO(user.getUserCategory());
		if(user.getBiens() != null){
			for (BienImmobilier bien : user.getBiens()) {
				if(bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT)){
					this.biens.add(new BienDTO((Appartement)bien));
				}
				else if(bien.getTypeBien().equals(EnumTypeBien.STUDIO)){
					this.biens.add(new BienDTO((Studio)bien));
				}
				else if(bien.getTypeBien().equals(EnumTypeBien.MAISON)){
					this.biens.add(new BienDTO((Maison)bien));
				}
			}
		}
	}

	public User getUserWithoutPassword() {
		User user = new User();

		if (id != null) {
			user.setId(Long.valueOf(id));
		}
		user.setCode(Long.valueOf(code));

		Contact contact = new Contact();
		contact.setAdresse(this.adresse);
		contact.setAdresseMail(this.adresseMail);
		contact.setAlerteSurTelephone1(this.alerteSurTelephone1);
		contact.setAlerteSurTelephone2(this.alerteSurTelephone2);
		contact.setCodePostal(this.codePostal);
		contact.setSiteWeb(this.siteWeb);
		contact.setTelephoneMobile(this.telephoneMobile);
		contact.setTelephonePerso(this.telephonePerso);
		contact.setTelephoneProf(this.telephoneProf);
		contact.setVille(this.ville);
		contact.setAdresse(this.adresse);
		user.setContact(contact);
		user.setFirstName(this.firstName);
		user.setIsAdmin(this.isAdmin);
		user.setLastName(this.lastName.toUpperCase());
		user.setLocked(this.locked);
		user.setLogin(this.login);
		user.setUserCategory(this.userCategory.getUserCategory());
		return user;
	}

	public User getUser() {
		User user = getUserWithoutPassword();
		user.setPassword(password);
		return user;
	}

	public User updateUser(User user) {

		user.setCode(Long.valueOf(code));
		// user.setContact(contact.getContact());
		user.setFirstName(firstName);
		user.setIsAdmin(isAdmin);
		user.setLastName(lastName);
		user.setLocked(locked);
		user.setLogin(login);
		// if(password.equals(passwordConfirmation)){
		// user.setPassword(password);
		// }else throw new Exception("Password not confirmed");
		user.getContact().setAdresse(adresse);
		user.getContact().setCodePostal(codePostal);
		user.getContact().setVille(ville);
		user.getContact().setAlerteSurTelephone1(alerteSurTelephone1);
		user.getContact().setAlerteSurTelephone2(alerteSurTelephone2);
		user.getContact().setAdresseMail(adresseMail);
		user.getContact().setSiteWeb(siteWeb);
		user.getContact().setTelephonePerso(telephonePerso);
		user.getContact().setTelephoneProf(telephoneProf);
		user.getContact().setTelephoneMobile(telephoneMobile);

		user.setUserCategory(userCategory.updateUserCategory(user
				.getUserCategory()));
		return user;
	}

	public UserDTO(Long id, Long code, String firstName, String lastName,
			String login, String password, Boolean connected, Boolean locked,
			Boolean isAdmin, String userCategoryName,
			UserCategoryDTO userCategory, String adresse, String codePostal,
			String ville, Boolean alerteSurTelephone1,
			Boolean alerteSurTelephone2, String adresseMail, String siteWeb,
			String telephonePerso, String telephoneProf, String telephoneMobile) {
		super();
		this.id = String.valueOf(id);
		this.code = String.valueOf(code);
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.locked = locked;
		this.isAdmin = isAdmin;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.alerteSurTelephone1 = alerteSurTelephone1;
		this.alerteSurTelephone2 = alerteSurTelephone2;
		this.adresseMail = adresseMail;
		this.siteWeb = siteWeb;
		this.telephonePerso = telephonePerso;
		this.telephoneProf = telephoneProf;
		this.telephoneMobile = telephoneMobile;

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Boolean getAlerteSurTelephone1() {
		return alerteSurTelephone1;
	}

	public void setAlerteSurTelephone1(Boolean alerteSurTelephone1) {
		this.alerteSurTelephone1 = alerteSurTelephone1;
	}

	public Boolean getAlerteSurTelephone2() {
		return alerteSurTelephone2;
	}

	public void setAlerteSurTelephone2(Boolean alerteSurTelephone2) {
		this.alerteSurTelephone2 = alerteSurTelephone2;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getTelephonePerso() {
		return telephonePerso;
	}

	public void setTelephonePerso(String telephonePerso) {
		this.telephonePerso = telephonePerso;
	}

	public String getTelephoneProf() {
		return telephoneProf;
	}

	public void setTelephoneProf(String telephoneProf) {
		this.telephoneProf = telephoneProf;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public java.util.List<BienDTO> getBiens() {
		return biens;
	}

	public void setBiens(java.util.List<BienDTO> biens) {
		this.biens = biens;
	}

	
}
