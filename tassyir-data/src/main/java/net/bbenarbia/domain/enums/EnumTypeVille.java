package net.bbenarbia.domain.enums;

public enum EnumTypeVille {

	COMMUNE(1), WILAYA(2), REGION(3);

	private int index;

	private EnumTypeVille(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeVille fromIndex(int index) {
		for (EnumTypeVille current : EnumTypeVille.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;

	}

}
