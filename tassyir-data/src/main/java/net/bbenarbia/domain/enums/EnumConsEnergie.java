package net.bbenarbia.domain.enums;

public enum EnumConsEnergie {

	A(0, 50), B(51, 90), C(91, 150), D(151, 230), E(231, 330), F(331, 450), G(
			450, 99999);

	private int min;
	private int max;

	private EnumConsEnergie(int min, int max) {
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

	public static EnumConsEnergie fromMinMax(int min, int max) {
		for (EnumConsEnergie current : EnumConsEnergie.values()) {
			if (current.getMin() == min && current.getMax() == max) {
				return current;
			}
		}
		return null;
	}

	public static EnumConsEnergie fromMinMax(int val) {
		for (EnumConsEnergie current : EnumConsEnergie.values()) {
			if (current.getMin() <= val && current.getMax() >= val) {
				return current;
			}
		}
		return null;
	}
	
	 public static EnumConsEnergie getEnumConsEnergieName(String name){
	    	
		 	if(name.equalsIgnoreCase("A")){
	    		return EnumConsEnergie.A;
	    	}
	    	else if(name.equalsIgnoreCase("B")){
	    		return EnumConsEnergie.B;
	    	}else if(name.equalsIgnoreCase("C")){
	    		return EnumConsEnergie.C;
	    	}else if(name.equalsIgnoreCase("D")){
	    		return EnumConsEnergie.D;
	    	}else if(name.equalsIgnoreCase("E")){
	    		return EnumConsEnergie.E;
	    	}else if(name.equalsIgnoreCase("F")){
	    		return EnumConsEnergie.F;
	    	}else 
	    		return EnumConsEnergie.G;
	    	
	    }
	 
}
