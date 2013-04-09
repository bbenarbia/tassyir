package net.bbenarbia.web.dto;

import net.bbenarbia.domain.Contact;
import net.bbenarbia.domain.enums.EnumTypeContact;

import org.hibernate.validator.constraints.NotEmpty;

public class ContactDTO {

	private String id;
	@NotEmpty(message = "Type de contact must not be empty.")
	private String typeContact;
	@NotEmpty(message = "nomSocieteContact must not be empty.")
	private String nomSocieteContact = "";
	@NotEmpty(message = "nameContact must not be empty.")
	private String nameContact = "";
	@NotEmpty(message = "adresseContact1 must not be empty.")
	private String adresseContact1 = "";
	private Boolean alerteSurTelephone1 = false;
	private Boolean alerteSurTelephone2 = false;
	@NotEmpty(message = "codePostalContact must not be empty.")
	private String codePostalContact = "";
	@NotEmpty(message = "villeContact must not be empty.")
	private String villeContact = "";
	@NotEmpty(message = "adresseMailContact must not be empty.")
	private String adresseMailContact = "";
	private String siteWebContact = "";
	private String telephoneContact1 = "";
	private String telephoneContact2 = "";

	public ContactDTO() {
		super();
	}

	public Contact updateContact(Contact contact) {

		if (id != null) {
			contact.setId(Long.valueOf(id));
		}
		contact.setAdresseContact1(adresseContact1);
		contact.setAdresseMailContact(adresseMailContact);
		contact.setAlerteSurTelephone1(alerteSurTelephone1);
		contact.setAlerteSurTelephone2(alerteSurTelephone2);
		contact.setCodePostalContact(Integer.valueOf(codePostalContact));
		contact.setName(nameContact);
		contact.setNomSocieteContact(nomSocieteContact);
		contact.setSiteWebContact(siteWebContact);
		contact.setTelephoneContact1(telephoneContact1);
		contact.setTelephoneContact2(telephoneContact2);
		contact.setTypeContact(EnumTypeContact
				.getTypeContactFromName(typeContact));
		contact.setVilleContact(villeContact);

		return contact;
	}

	public Contact getContact() {

		Contact contact = new Contact();
		if (id != null) {
			contact.setId(Long.valueOf(id));
		}
		contact.setAdresseContact1(adresseContact1);
		contact.setAdresseMailContact(adresseMailContact);
		contact.setAlerteSurTelephone1(alerteSurTelephone1);
		contact.setAlerteSurTelephone2(alerteSurTelephone2);
		contact.setCodePostalContact(Integer.valueOf(codePostalContact));
		contact.setName(nameContact);
		contact.setNomSocieteContact(nomSocieteContact);
		contact.setSiteWebContact(siteWebContact);
		contact.setTelephoneContact1(telephoneContact1);
		contact.setTelephoneContact2(telephoneContact2);
		contact.setTypeContact(EnumTypeContact
				.getTypeContactFromName(typeContact));
		contact.setVilleContact(villeContact);

		return contact;
	}

	public ContactDTO(Long id, String typeContact, String nameContact,
			String nomSocieteContact, String adresseContact1,
			 Boolean alerteSurTelephone1,
			Boolean alerteSurTelephone2, Integer codePostalContact,
			String villeContact,
			String adresseMailContact, 
			String siteWebContact, String telephoneContact1,
			String telephoneContact2) {
		super();
		this.id = String.valueOf(id);
		this.typeContact = typeContact;
		this.nomSocieteContact = nomSocieteContact;
		this.nameContact = nameContact;
		this.adresseContact1 = adresseContact1;
		this.alerteSurTelephone1 = alerteSurTelephone1;
		this.alerteSurTelephone2 = alerteSurTelephone2;
		this.codePostalContact = String.valueOf(codePostalContact);
		this.villeContact = villeContact;
		this.adresseMailContact = adresseMailContact;
		this.siteWebContact = siteWebContact;
		this.telephoneContact1 = telephoneContact1;
		this.telephoneContact2 = telephoneContact2;
	}

	public ContactDTO(Contact contact) {
		super();
		if (contact.getId() != null) {
			this.id = String.valueOf(contact.getId());
		}
		if (contact.getTypeContact() != null) {
			this.typeContact = contact.getTypeContact().toString();
		}
		this.nameContact = contact.getName();
		this.nomSocieteContact = contact.getNomSocieteContact();
		this.adresseContact1 = contact.getAdresseContact1();
		this.alerteSurTelephone1 = contact.getAlerteSurTelephone1();
		this.alerteSurTelephone2 = contact.getAlerteSurTelephone2();
		this.codePostalContact = String.valueOf(contact.getCodePostalContact());
		this.villeContact = contact.getVilleContact();
		this.adresseMailContact = contact.getAdresseMailContact();
		this.siteWebContact = contact.getSiteWebContact();
		this.telephoneContact1 = contact.getTelephoneContact1();
		this.telephoneContact2 = contact.getTelephoneContact2();
	}

	public String getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public String getNomSocieteContact() {
		return nomSocieteContact;
	}

	public void setNomSocieteContact(String nomSocieteContact) {
		this.nomSocieteContact = nomSocieteContact;
	}

	public String getAdresseContact1() {
		return adresseContact1;
	}

	public void setAdresseContact1(String adresseContact1) {
		this.adresseContact1 = adresseContact1;
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

	public String getVilleContact() {
		return villeContact;
	}

	public void setVilleContact(String villeContact) {
		this.villeContact = villeContact;
	}

	public String getAdresseMailContact() {
		return adresseMailContact;
	}

	public void setAdresseMailContact(String adresseMailContact) {
		this.adresseMailContact = adresseMailContact;
	}

	public String getSiteWebContact() {
		return siteWebContact;
	}

	public void setSiteWebContact(String siteWebContact) {
		this.siteWebContact = siteWebContact;
	}

	public String getTelephoneContact1() {
		return telephoneContact1;
	}

	public void setTelephoneContact1(String telephoneContact1) {
		this.telephoneContact1 = telephoneContact1;
	}

	public String getTelephoneContact2() {
		return telephoneContact2;
	}

	public void setTelephoneContact2(String telephoneContact2) {
		this.telephoneContact2 = telephoneContact2;
	}

	public String getNameContact() {
		return nameContact;
	}

	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodePostalContact() {
		return codePostalContact;
	}

	public void setCodePostalContact(String codePostalContact) {
		this.codePostalContact = codePostalContact;
	}

}
