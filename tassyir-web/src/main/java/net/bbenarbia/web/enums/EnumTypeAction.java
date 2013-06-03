package net.bbenarbia.web.enums;


public enum EnumTypeAction {

	OFFRE_VENDRE(1), OFFRE_LOCATION(2), OFFRE_VACANCES(3), OFFRE_COLOCATION(4), ECHANGE(5), OFFRE_COMMERCE(6), AUTRES(7),
	DEMANDE_ACHAT(8),DEMANDE_LOCATION(9), DEMANDE_VACANCES(10), DEMANDE_COLOCATION(11), DEMANDE_COMMERCE(12);

	private int index;

	private EnumTypeAction(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeAction fromIndex(int index) {
		for (EnumTypeAction current : EnumTypeAction.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
