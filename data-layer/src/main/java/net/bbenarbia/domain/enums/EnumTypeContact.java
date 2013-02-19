package net.bbenarbia.domain.enums;


import java.io.Serializable;

public enum EnumTypeContact implements Serializable {
    Magasin(1), Client(2), Employe(3), Fournisseur(4), Fabricant(5), Perso(6);

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
}