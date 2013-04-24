package net.bbenarbia.domain.enums;

public enum EnumStatutProperty {

	DISPONIBLE(1), LOUE(2), ACHETE(3), DISPO_15_JOUR(4), DISPO_1_MOIS(5),DISPO_2_MOIS(6),DISPO_3_MOIS(7), EN_TRAVAUX(8), ANNULE(9);

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