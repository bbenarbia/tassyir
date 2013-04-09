package net.bbenarbia.domain.enums;

public enum EnumTypeChauffage {
	INDIVIDUEL(1), COLLEECTIF(2); 

	private int index;

	private EnumTypeChauffage(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumTypeChauffage fromIndex(int index) {
		for (EnumTypeChauffage current : EnumTypeChauffage.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
}
