package net.bbenarbia.domain.immobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.bbenarbia.constants.Constants;

/**
 * @author moad
 * 
 */
@Entity
@Table(name = "biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(Constants.APPARTEMENT)
public class Appartement extends HabitableBien {

	@Column(name = "etage")
	private String etage;

	@Column(name = "ascenseur")
	private boolean ascenseur;
	
	@Column(name = "gardien")
	private boolean gardien	;

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public boolean isAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public boolean isGardien() {
		return gardien;
	}

	public void setGardien(boolean gardien) {
		this.gardien = gardien;
	}
	
}
