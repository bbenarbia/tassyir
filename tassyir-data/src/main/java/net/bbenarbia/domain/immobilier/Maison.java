package net.bbenarbia.domain.immobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.bbenarbia.constants.Constants;

@Entity
@Table(name = "biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(Constants.MAISON)
public class Maison extends BienImmobilier{
	
	@Column(name = "nbPieces")
	private int nbPieces;
	
	@Column(name = "cuisineEquipee")
	private boolean cuisineEquipee;
	
	@Column(name = "jardin")
	private boolean jardin;
	
	@Column(name = "age")
	private int age;
	
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
	public boolean isJardin() {
		return jardin;
	}
	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
