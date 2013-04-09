package net.bbenarbia.domain.enums;

public enum EnumTypeEauChaude {

	SANS(1), CUMUL_ELT(2), COLLECTIF(3), AUTRE(4);

	private int index;

	private EnumTypeEauChaude(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeEauChaude fromIndex(int index) {
		for (EnumTypeEauChaude current : EnumTypeEauChaude.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
	
}
