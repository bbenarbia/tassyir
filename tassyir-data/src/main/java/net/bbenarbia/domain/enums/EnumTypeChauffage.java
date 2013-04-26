package net.bbenarbia.domain.enums;

public enum EnumTypeChauffage {
	SEMI_COLLECTIF(1), COLLECTIF(2), INDIVIDUEL_COLLECTIF(3),FUEL(4), INDIVIDUEL_GAZ(5),INDIVIDUEL(6), SOL(7), GEO_TERMIQUE(8) ; 

	private int index;

	private EnumTypeChauffage(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeChauffage fromIndex(int index) {
		for (EnumTypeChauffage current : EnumTypeChauffage.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
