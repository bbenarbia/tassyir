package net.bbenarbia.domain.enums;


	public enum EnumFonction {
	    FONCTION_1(1),
	    FONCTION_2(2),
	    FONCTION_3(3),
	    FONCTION_4(4),
	    FONCTION_5(5),
	    FONCTION_6(6),
	    FONCTION_7(7),
	    FONCTION_8(8),
	    AUCUNE(-1);

	    private int index;

	    private EnumFonction(int index) {
	        this.index = index;
	    }

	    public int getIndex() {
	        return index;
	    }

	    public static EnumFonction fromIndex(int value) {
	        for (EnumFonction myEnum : EnumFonction.values()) {
	            if (myEnum.index == value) {
	                return myEnum;
	            }
	        }
	        return AUCUNE;
	    }
	}

