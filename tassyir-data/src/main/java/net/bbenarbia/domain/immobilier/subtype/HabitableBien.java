package net.bbenarbia.domain.immobilier.subtype;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumTypeChauffage;
import net.bbenarbia.domain.enums.EnumTypeEauChaude;

@MappedSuperclass
public class HabitableBien extends BienImmobilier {

	@Column(name = "nbPieces")
	private int nbPieces;

	@Column(name = "nbChambres")
	private int nbChambres;

	@Column(name = "cuisineEquipee")
	private boolean cuisineEquipee;

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

	public int getNbChambres() {
		return nbChambres;
	}

	public void setNbChambres(int nbChambres) {
		this.nbChambres = nbChambres;
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

	public EnumConsEnergie getConsoEnergie() {
		return consoEnergie;
	}

	public void setConsoEnergie(EnumConsEnergie consoEnergie) {
		this.consoEnergie = consoEnergie;
	}

	public EnumTypeEauChaude getTypeEauChaude() {
		return typeEauChaude;
	}

	public void setTypeEauChaude(EnumTypeEauChaude typeEauChaude) {
		this.typeEauChaude = typeEauChaude;
	}

	public EnumImpactConso getImpactConso() {
		return impactConso;
	}

	public void setImpactConso(EnumImpactConso impactConso) {
		this.impactConso = impactConso;
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

	public boolean isMeuble() {
		return meuble;
	}

	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}

}
