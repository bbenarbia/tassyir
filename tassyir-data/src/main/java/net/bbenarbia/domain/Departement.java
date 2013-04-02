package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;

@Entity
@Table(name = "departements")
public class Departement extends NamedEntity {

	@Column(name = "ref")
	private String reference;

	@Column(name = "region")
	private String region;

	@Column(name = "prefecture")
	private String prefecture;

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

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

}
