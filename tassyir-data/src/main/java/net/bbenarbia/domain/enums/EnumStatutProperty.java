package net.bbenarbia.domain.enums;

public enum EnumStatutProperty {

	DISPONIBLE(1), LOUE(2), ACHETE(3);

	private int index;

	private EnumStatutProperty(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumStatutProperty fromIndex(int index) {
		for (EnumStatutProperty current : EnumStatutProperty.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}

		return null;
	}
}