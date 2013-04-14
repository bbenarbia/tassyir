package net.bbenarbia.domain.enums;

public enum EnumEtatBien {

	A_RESTAURER(1), CORRECT(2), IMPECCABLE(3); 

	private int index;

	private EnumEtatBien(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public static EnumEtatBien fromIndex(int index) {
		for (EnumEtatBien current : EnumEtatBien.values()) {
			if (current.getIndex() == index) {
				return current;
			}
		}
		return null;
	}
	 public static EnumEtatBien getEnumEtatBienByName(String name){
	    	
		 	if(name.equalsIgnoreCase("A_RESTAURER")){
	    		return EnumEtatBien.A_RESTAURER;
	    	}
	    	else if(name.equalsIgnoreCase("CORRECT")){
	    		return EnumEtatBien.CORRECT;
	    	}else 
	    		return EnumEtatBien.IMPECCABLE;
	    	
	    }
}
