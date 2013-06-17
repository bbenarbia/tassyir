package net.bbenarbia.domain.enums;

public enum EnumTypeBien {
	APPARTEMENT(1),  MAISON(2),  TERRAIN(4), AGRICOLE(5), CARCASSE(6), COMMERCE(7), VACANCES(8), AUTRES(10); 

	
	private int index;

	private EnumTypeBien(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeBien fromIndex(int index) {
		for (EnumTypeBien current : EnumTypeBien.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
