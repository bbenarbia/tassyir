package net.bbenarbia.tassyir.vo;

import net.bbenarbia.domain.Contact;

public class ContactVo {

	private String typeContact;

	private String nomSocieteContact;

	private String titreContact;

	private String adresseContact1;

	private String adresseContact2;

	private Boolean alerteSurTelephone1;

	private Boolean alerteSurTelephone2;

	private Integer codePostalContact;

	private Boolean estContactPrincipal;

	private String villeContact = "";

	private String adresseMailContact = "";

	private String faxContact = "";

	private String siteWebContact = "";

	private String telephoneContact1 = "";

	private String telephoneContact2 = "";

	public ContactVo() {
	}

	// public ContactVo(Contact contact){
	// this();
	// }

	public String getTypeContact() {
		return typeContact;
	}

	public ContactVo(String typeContact, String nomSocieteContact,
			String titreContact, String adresseContact1,
			String adresseContact2, Boolean alerteSurTelephone1,
			Boolean alerteSurTelephone2, Integer codePostalContact,
			Boolean estContactPrincipal, String villeContact,
			String adresseMailContact, String faxContact,
			String siteWebContact, String telephoneContact1,
			String telephoneContact2) {
		super();
		this.typeContact = typeContact;
		this.nomSocieteContact = nomSocieteContact;
		this.titreContact = titreContact;
		this.adresseContact1 = adresseContact1;
		this.adresseContact2 = adresseContact2;
		this.alerteSurTelephone1 = alerteSurTelephone1;
		this.alerteSurTelephone2 = alerteSurTelephone2;
		this.codePostalContact = codePostalContact;
		this.estContactPrincipal = estContactPrincipal;
		this.villeContact = villeContact;
		this.adresseMailContact = adresseMailContact;
		this.faxContact = faxContact;
		this.siteWebContact = siteWebContact;
		this.telephoneContact1 = telephoneContact1;
		this.telephoneContact2 = telephoneContact2;
	}

	public ContactVo(Contact contact) {
		super();
		this.typeContact = contact.getTypeContact().toString();
		this.nomSocieteContact = contact.getNomSocieteContact();
		this.titreContact = contact.getTitreContact();
		this.adresseContact1 = contact.getAdresseContact1();
		this.adresseContact2 = contact.getAdresseContact2();
		this.alerteSurTelephone1 = contact.getAlerteSurTelephone1();
		this.alerteSurTelephone2 = contact.getAlerteSurTelephone2();
		this.codePostalContact = contact.getCodePostalContact();
		this.estContactPrincipal = contact.getEstContactPrincipal();
		this.villeContact = contact.getVilleContact();
		this.adresseMailContact = contact.getAdresseMailContact();
		this.faxContact = contact.getFaxContact();
		this.siteWebContact = contact.getSiteWebContact();
		this.telephoneContact1 = contact.getTelephoneContact1();
		this.telephoneContact2 = contact.getTelephoneContact2();
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

	public String getTitreContact() {
		return titreContact;
	}

	public void setTitreContact(String titreContact) {
		this.titreContact = titreContact;
	}

	public String getAdresseContact1() {
		return adresseContact1;
	}

	public void setAdresseContact1(String adresseContact1) {
		this.adresseContact1 = adresseContact1;
	}

	public String getAdresseContact2() {
		return adresseContact2;
	}

	public void setAdresseContact2(String adresseContact2) {
		this.adresseContact2 = adresseContact2;
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

	public Integer getCodePostalContact() {
		return codePostalContact;
	}

	public void setCodePostalContact(Integer codePostalContact) {
		this.codePostalContact = codePostalContact;
	}

	public Boolean getEstContactPrincipal() {
		return estContactPrincipal;
	}

	public void setEstContactPrincipal(Boolean estContactPrincipal) {
		this.estContactPrincipal = estContactPrincipal;
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

	public String getFaxContact() {
		return faxContact;
	}

	public void setFaxContact(String faxContact) {
		this.faxContact = faxContact;
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

}