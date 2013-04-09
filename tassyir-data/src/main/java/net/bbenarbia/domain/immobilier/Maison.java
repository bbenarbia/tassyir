package net.bbenarbia.domain.immobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.bbenarbia.constants.Constants;
import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumTypeChauffage;
import net.bbenarbia.domain.enums.EnumTypeEauChaude;

@Entity
@Table(name = "biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(Constants.MAISON)
public class Maison extends BienImmobilier {

	@Column(name = "nbPieces")
	private int nbPieces;

	@Column(name = "cuisineEquipee")
	private boolean cuisineEquipee;

	@Column(name = "jardin")
	private boolean jardin;

	@Column(name = "age")
	private int age;

	@Column(name = "nbTerrasses")
	private int nbTerrasses;

	@Column(name = "nbBalcons")
	private int nbBalcons;

	@Column(name = "nbParkingInt")
	private int nbParkingInt;

	@Column(name = "nbParkingExt")
	private int nbParkingExt;

	@Column(name = "interphone")
	private boolean interphone;

	@Column(name = "digicode")
	private boolean digicode;

	@Column(name = "piscine")
	private boolean piscine;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumConsEnergie consoEnergie;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeEauChaude typeEauChaude;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumImpactConso impactConso;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNatureChauffage natureChauffage;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeChauffage typeChauffage;

	@Column(name = "meuble")
	private boolean meuble;

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

	public EnumConsEnergie getConsoEnergie() {
		return consoEnergie;
	}

	public void setConsoEnergie(EnumConsEnergie consoEnergie) {
		this.consoEnergie = consoEnergie;
	}

	public EnumImpactConso getImpactConso() {
		return impactConso;
	}

	public void setImpactConso(EnumImpactConso impactConso) {
		this.impactConso = impactConso;
	}

	public boolean isMeuble() {
		return meuble;
	}

	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}

	public EnumNatureChauffage getNatureChauffage() {
		return natureChauffage;
	}

	public void setNatureChauffage(EnumNatureChauffage natureChauffage) {
		this.natureChauffage = natureChauffage;
	}

	public EnumTypeChauffage getTypeChauffage() {
		return typeChauffage;
	}

	public void setTypeChauffage(EnumTypeChauffage typeChauffage) {
		this.typeChauffage = typeChauffage;
	}

	public int getNbTerrasses() {
		return nbTerrasses;
	}

	public void setNbTerrasses(int nbTerrasses) {
		this.nbTerrasses = nbTerrasses;
	}

	public int getNbBalcons() {
		return nbBalcons;
	}

	public void setNbBalcons(int nbBalcons) {
		this.nbBalcons = nbBalcons;
	}

	public int getNbParkingInt() {
		return nbParkingInt;
	}

	public void setNbParkingInt(int nbParkingInt) {
		this.nbParkingInt = nbParkingInt;
	}

	public int getNbParkingExt() {
		return nbParkingExt;
	}

	public void setNbParkingExt(int nbParkingExt) {
		this.nbParkingExt = nbParkingExt;
	}

	public boolean isInterphone() {
		return interphone;
	}

	public void setInterphone(boolean interphone) {
		this.interphone = interphone;
	}

	public boolean isDigicode() {
		return digicode;
	}

	public void setDigicode(boolean digicode) {
		this.digicode = digicode;
	}

	public boolean isPiscine() {
		return piscine;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

	public EnumTypeEauChaude getTypeEauChaude() {
		return typeEauChaude;
	}

	public void setTypeEauChaude(EnumTypeEauChaude typeEauChaude) {
		this.typeEauChaude = typeEauChaude;
	}

}
