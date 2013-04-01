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
public class Appartement extends BienImmobilier {

	@Column(name = "etage")
	private int etage;

	@Column(name = "nbPieces")
	private int nbPieces;

	@Column(name = "ascenseur")
	private boolean ascenseur;

	@Column(name = "cuisineEquipee")
	private boolean cuisineEquipee;

	@Column(name = "age")
	private int age;

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	public boolean isCuisineEquipee() {
		return cuisineEquipee;
	}

	public void setCuisineEquipee(boolean cuisineEquipee) {
		this.cuisineEquipee = cuisineEquipee;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}


}
