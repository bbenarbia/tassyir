package net.bbenarbia.domain.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	@Column(name = "adresse")
	private String adresse = "";

	@Column(name = "codePostal")
	private String codePostal;

	@Column(name = "ville")
	private String ville = "";

	@Column(name = "alerteSurTelephone1")
	private Boolean alerteSurTelephone1 = false;

	@Column(name = "alerteSurTelephone2")
	private Boolean alerteSurTelephone2 = false;

	@Column(name = "adresseMail")
	private String adresseMail = "";

	@Column(name = "siteWeb")
	private String siteWeb = "";

	@Column(name = "telephonePerso")
	private String telephonePerso = "";

	@Column(name = "telephoneProf")
	private String telephoneProf = "";

	@Column(name = "mobile")
	private String telephoneMobile = "";

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

}
