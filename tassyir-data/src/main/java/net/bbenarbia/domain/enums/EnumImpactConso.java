package net.bbenarbia.domain.enums;

public enum EnumImpactConso {
	A(0, 5), B(6, 10), C(11, 20), D(21, 35), E(36, 55), F(56, 80), G(81,1000);

	private int min;
	private int max;

	private EnumImpactConso(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public static EnumImpactConso fromMinMax(int min, int max) {
		for (EnumImpactConso current : EnumImpactConso.values()) {
			if (current.getMin() == min && current.getMax() == max) {
				return current;
			}
		}
		return null;
	}

	public static EnumImpactConso fromMinMax(int val) {
		for (EnumImpactConso current : EnumImpactConso.values()) {
			if (current.getMin() <= val && current.getMax() >= val) {
				return current;
			}
		}
		return null;
	}
}