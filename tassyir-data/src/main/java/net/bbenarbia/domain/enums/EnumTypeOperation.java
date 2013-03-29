package net.bbenarbia.domain.enums;

public enum EnumTypeOperation {
	A_VENDRE(1), A_LOUER(2), AUTRE(3);

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
