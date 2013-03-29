package net.bbenarbia.domain.immobilier;

public class Maison extends ImmovableProperty{

	private int nbPieces;
	private boolean cuisineEquipee;
	private boolean jardin;
	
	
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
	
	
}
