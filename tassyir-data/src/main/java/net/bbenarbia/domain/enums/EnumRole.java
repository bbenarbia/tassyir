package net.bbenarbia.domain.enums;

public enum EnumRole {

	UTILISATEUR(1), GESTIONNAIRE(2), SAV(3), EXPLOITATION(666), ADMIN(777);

	private int index;

	private EnumRole(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumRole fromIndex(int index) {
		for (EnumRole current : EnumRole.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return this.name();
	}
}
