package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bbenarbia.domain.base.BenEntity;
import net.bbenarbia.domain.base.IDeletableEntity;
import net.bbenarbia.domain.enums.EnumTypeContact;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "contact")
public class Contact extends BenEntity implements IDeletableEntity {

	private LocalDateTime dateSuppression;
	private EnumTypeContact typeContact;
	private String nomContact = "";
	private String nomSocieteContact = "";
	private String titreContact = "";
	private String adresseContact1 = "";
	private String adresseContact2 = "";
	private Boolean alerteSurTelephone1 = false;
	private Boolean alerteSurTelephone2 = false;
	private Integer codePostalContact = 0;
	private Boolean estContactPrincipal = false;
	private String villeContact = "";
	private String adresseMailContact = "";
	private String faxContact = "";
	private String siteWebContact = "";
	private String telephoneContact1 = "";
	private String telephoneContact2 = "";
	private Boolean estSupprimable = false;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(name = "datesuppression")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	public LocalDateTime getDateSuppression() {
		return dateSuppression;
	}

	public void setDateSuppression(LocalDateTime dateSuppression) {
		this.dateSuppression = dateSuppression;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public EnumTypeContact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(EnumTypeContact typeContact) {
		this.typeContact = typeContact;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
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

	public Boolean getEstSupprimable() {
		return estSupprimable;
	}

	public void setEstSupprimable(Boolean estSupprimable) {
		this.estSupprimable = estSupprimable;
	}

}
