package net.bbenarbia.domain.enums;

public enum EnumTypeUniteMesure  {

	PRICE(1), SUPERFICIE(2), LONGUEUR(3); 

	private int index;

	private EnumTypeUniteMesure(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeUniteMesure fromIndex(int index) {
		for (EnumTypeUniteMesure current : EnumTypeUniteMesure.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}