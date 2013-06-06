package net.bbenarbia.web.dto;

import java.util.ArrayList;
import java.util.List;

public class FindBienDTO {

	private String refBien;
	private String departementBien;
	private String communeBien;
	private Boolean appartement;
	private Boolean maison;
	private Boolean immeuble;
	private Boolean terrain;
	private Boolean agricole;
	private Boolean carcasse;
	private Boolean commercial;
	private Boolean bungalow;
	private Boolean ferme;
	private Integer nbPiecesMin;
	private Integer typeOperationBien;
	private Integer nbPiecesMax;
	private Double surfaceMin;
	private Double surfaceMax;
	private Double loyerMin;
	private Double loyerMax;
	private Boolean ascenseur;
	private Boolean cuisineEquipee;
	private Boolean jardin;
	private Boolean interphone;
	private Boolean digicode;
	private Boolean gardien;
	private Boolean meuble;
	private Boolean adapteHandicape;
	private Boolean piscine;
	private Boolean caves;
	private Boolean parking;
	private Boolean terrassesBalcons;

	List<BienDTO> listBiens = new ArrayList<BienDTO>(0);

	public String getRefBien() {
		return refBien;
	}

	public void setRefBien(String refBien) {
		this.refBien = refBien;
	}

	public String getDepartementBien() {
		return departementBien;
	}

	public void setDepartementBien(String departementBien) {
		this.departementBien = departementBien;
	}

	public Integer getNbPiecesMin() {
		return nbPiecesMin;
	}

	public void setNbPiecesMin(Integer nbPiecesMin) {
		this.nbPiecesMin = nbPiecesMin;
	}

	public Integer getNbPiecesMax() {
		return nbPiecesMax;
	}

	public void setNbPiecesMax(Integer nbPiecesMax) {
		this.nbPiecesMax = nbPiecesMax;
	}

	public Double getSurfaceMin() {
		return surfaceMin;
	}

	public void setSurfaceMin(Double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}

	public Double getSurfaceMax() {
		return surfaceMax;
	}

	public void setSurfaceMax(Double surfaceMax) {
		this.surfaceMax = surfaceMax;
	}

	public Double getLoyerMin() {
		return loyerMin;
	}

	public void setLoyerMin(Double loyerMin) {
		this.loyerMin = loyerMin;
	}

	public Double getLoyerMax() {
		return loyerMax;
	}

	public void setLoyerMax(Double loyerMax) {
		this.loyerMax = loyerMax;
	}

	public List<BienDTO> getListBiens() {
		return listBiens;
	}

	public void setListBiens(List<BienDTO> listBiens) {
		this.listBiens = listBiens;
	}

	public Boolean getAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(Boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public Boolean getCuisineEquipee() {
		return cuisineEquipee;
	}

	public void setCuisineEquipee(Boolean cuisineEquipee) {
		this.cuisineEquipee = cuisineEquipee;
	}

	public Boolean getJardin() {
		return jardin;
	}

	public void setJardin(Boolean jardin) {
		this.jardin = jardin;
	}

	public Boolean getInterphone() {
		return interphone;
	}

	public void setInterphone(Boolean interphone) {
		this.interphone = interphone;
	}

	public Boolean getDigicode() {
		return digicode;
	}

	public void setDigicode(Boolean digicode) {
		this.digicode = digicode;
	}

	public Boolean getGardien() {
		return gardien;
	}

	public void setGardien(Boolean gardien) {
		this.gardien = gardien;
	}

	public Boolean getMeuble() {
		return meuble;
	}

	public void setMeuble(Boolean meuble) {
		this.meuble = meuble;
	}

	public Boolean getAdapteHandicape() {
		return adapteHandicape;
	}

	public void setAdapteHandicape(Boolean adapteHandicape) {
		this.adapteHandicape = adapteHandicape;
	}

	public Boolean getPiscine() {
		return piscine;
	}

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	public Boolean getCaves() {
		return caves;
	}

	public void setCaves(Boolean caves) {
		this.caves = caves;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean getTerrassesBalcons() {
		return terrassesBalcons;
	}

	public void setTerrassesBalcons(Boolean terrassesBalcons) {
		this.terrassesBalcons = terrassesBalcons;
	}

	public Integer getTypeOperationBien() {
		return typeOperationBien;
	}

	public void setTypeOperationBien(Integer typeOperationBien) {
		this.typeOperationBien = typeOperationBien;
	}

	public String getCommuneBien() {
		return communeBien;
	}

	public void setCommuneBien(String communeBien) {
		this.communeBien = communeBien;
	}

	public Boolean getAppartement() {
		return appartement;
	}

	public void setAppartement(Boolean appartement) {
		this.appartement = appartement;
	}

	public Boolean getMaison() {
		return maison;
	}

	public void setMaison(Boolean maison) {
		this.maison = maison;
	}

	public Boolean getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Boolean immeuble) {
		this.immeuble = immeuble;
	}

	public Boolean getTerrain() {
		return terrain;
	}

	public void setTerrain(Boolean terrain) {
		this.terrain = terrain;
	}

	public Boolean getAgricole() {
		return agricole;
	}

	public void setAgricole(Boolean agricole) {
		this.agricole = agricole;
	}

	public Boolean getCarcasse() {
		return carcasse;
	}

	public void setCarcasse(Boolean carcasse) {
		this.carcasse = carcasse;
	}

	public Boolean getCommercial() {
		return commercial;
	}

	public void setCommercial(Boolean commercial) {
		this.commercial = commercial;
	}

	public Boolean getBungalow() {
		return bungalow;
	}

	public void setBungalow(Boolean bungalow) {
		this.bungalow = bungalow;
	}

	public Boolean getFerme() {
		return ferme;
	}

	public void setFerme(Boolean ferme) {
		this.ferme = ferme;
	}

}
