package net.bbenarbia.domain.enums;

public enum EnumNatureChauffage {

	ELECTRIC(1), BOIS(2), GAZ(3), FIOUL(4), SOLAIRE(5), ECOLOGIC(6), AUTRE(7); 

	private int index;

	private EnumNatureChauffage(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumNatureChauffage fromIndex(int index) {
		for (EnumNatureChauffage current : EnumNatureChauffage.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
