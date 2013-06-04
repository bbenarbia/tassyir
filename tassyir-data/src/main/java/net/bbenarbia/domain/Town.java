package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.enums.EnumTypeVille;

@Entity
@Table(name = "towns")
public class Town extends NamedEntity {

	@Column(name = "ref")
	private String reference;

	@Column(name = "codePostal")
	private String codePostal;
	
	@Column(name = "departement")
	private String departement;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeVille typeVille;

	@Column(name = "region")
	private String region;


	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public EnumTypeVille getTypeVille() {
		return typeVille;
	}

	public void setTypeVille(EnumTypeVille typeVille) {
		this.typeVille = typeVille;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
}
