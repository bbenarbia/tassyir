package net.bbenarbia.domain.immobilier;

public class Studio extends ImmovableProperty{
	private int etage;
	private boolean ascensseur;
	
	
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public boolean isAscensseur() {
		return ascensseur;
	}
	public void setAscensseur(boolean ascensseur) {
		this.ascensseur = ascensseur;
	}
	
}
