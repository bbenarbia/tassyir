package net.bbenarbia.domain.enums;

public enum EnumEtatBien {

	A_RESTAURER(1), CORRECT(2), IMPECCABLE(3); 

	private int index;

	private EnumEtatBien(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumEtatBien fromIndex(int index) {
		for (EnumEtatBien current : EnumEtatBien.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
