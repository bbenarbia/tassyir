package net.bbenarbia.domain.immobilier;


public class Appartement extends ImmovableProperty{

	private int etage;
	private int nbPieces;
	private boolean ascensseur;
	private boolean cuisineEquipee;
	
	
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
	public boolean isAscensseur() {
		return ascensseur;
	}
	public void setAscensseur(boolean ascensseur) {
		this.ascensseur = ascensseur;
	}
	public boolean isCuisineEquipee() {
		return cuisineEquipee;
	}
	public void setCuisineEquipee(boolean cuisineEquipee) {
		this.cuisineEquipee = cuisineEquipee;
	}
	
	
	
}
