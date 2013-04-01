package net.bbenarbia.domain.enums;

public enum EnumTypeBien {
	APPARTEMENT(1), STUDIO(2), TERRAIN(3), MAISON(4), COMMERCE(5), ENTREPOT(6); 

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
