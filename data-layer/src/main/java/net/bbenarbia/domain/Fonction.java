package net.bbenarbia.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.bbenarbia.domain.base.BenEntity;
import net.bbenarbia.domain.enums.EnumFonction;


@Entity
@Table(name = "fonction")
public class Fonction extends BenEntity {

	private EnumFonction typeFonction; 
	private String libelleFonction = "";
	private Boolean estAssociableParRaccourci = false;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Enumerated(EnumType.STRING)
	public EnumFonction getTypeFonction() {
		return typeFonction;
	}

	public void setTypeFonction(EnumFonction typeFonction) {
		this.typeFonction = typeFonction;
	}

	public String getLibelleFonction() {
		return libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	public Boolean getEstAssociableParRaccourci() {
		return estAssociableParRaccourci;
	}

	public void setEstAssociableParRaccourci(Boolean estAssociableParRaccourci) {
		this.estAssociableParRaccourci = estAssociableParRaccourci;
	}
}
