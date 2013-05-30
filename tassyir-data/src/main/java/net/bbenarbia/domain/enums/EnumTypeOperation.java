package net.bbenarbia.domain.enums;

public enum EnumTypeOperation {
	VENTE(1), LOCATION(2), COLOCATION(3), ECHANGE(5), ACHAT(6), CHERCHE_LOCATION(7);

	private int index;

	private EnumTypeOperation(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeOperation fromIndex(int index) {
		for (EnumTypeOperation current : EnumTypeOperation.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
	
}
