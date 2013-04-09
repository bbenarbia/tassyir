package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.enums.EnumTypeContact;

@Entity
@Table(name = "contact")
public class Contact extends NamedEntity {

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeContact typeContact;

	@Column(name = "nomSocieteContact")
	private String nomSocieteContact = "";

	@Column(name = "adresseContact1")
	private String adresseContact1 = "";

	@Column(name = "alerteSurTelephone1")
	private Boolean alerteSurTelephone1 = false;

	@Column(name = "alerteSurTelephone2")
	private Boolean alerteSurTelephone2 = false;

	@Column(name = "codePostalContact")
	private Integer codePostalContact = 0;

	@Column(name = "villeContact")
	private String villeContact = "";

	@Column(name = "adresseMailContact")
	private String adresseMailContact = "";

	@Column(name = "siteWebContact")
	private String siteWebContact = "";

	@Column(name = "telephoneContact1")
	private String telephoneContact1 = "";

	@Column(name = "telephoneContact2")
	private String telephoneContact2 = "";


	public EnumTypeContact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(EnumTypeContact typeContact) {
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

	public Integer getCodePostalContact() {
		return codePostalContact;
	}

	public void setCodePostalContact(Integer codePostalContact) {
		this.codePostalContact = codePostalContact;
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


}