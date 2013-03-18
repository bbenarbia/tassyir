package net.bbenarbia.domain.enums;


import java.io.Serializable;

public enum EnumTypeContact implements Serializable {
    Magasin(1), Client(2), Employe(3), Fournisseur(4), Perso(5);

    private int index;

    private EnumTypeContact(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static EnumTypeContact fromIndex(int id) {
        for (EnumTypeContact value : EnumTypeContact.values()) {
            if (value.getIndex() == id) {
                return value;
            }
        }
        return null;
    }
    
    public static EnumTypeContact getTypeContactFromName(String name){
    	if(name.equalsIgnoreCase("MAGASIN")){
    		return Magasin;
    	}
    	else if(name.equalsIgnoreCase("CLIENT")){
    		return Client;
    	}
    	if(name.equalsIgnoreCase("Employe")){
    		return Employe;
    	}
    	if(name.equalsIgnoreCase("Fournisseur")){
    		return Fournisseur;
    	}
    	else return Perso;
    }
}