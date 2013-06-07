package net.bbenarbia.domain.enums;

public enum EnumTypeUser {
	PARTICULIER(1), PROFESSIONNEL(2);

	private int index;

	private EnumTypeUser(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeUser fromIndex(int index) {
		for (EnumTypeUser current : EnumTypeUser.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
