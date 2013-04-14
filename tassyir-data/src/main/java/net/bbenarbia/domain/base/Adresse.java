package net.bbenarbia.domain.base;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name = "adresse")
	private String adresse = "";

	@Column(name = "codePostal")
	private String codePostal;

	@Column(name = "ville")
	private String ville = "";

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

}
