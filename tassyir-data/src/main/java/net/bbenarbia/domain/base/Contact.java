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
	
	
}
