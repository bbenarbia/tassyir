package net.bbenarbia.domain.enums;

public enum EnumDroit {
	  RETOUR_PRODUIT("enum_droit_retour_produit"),
	    MODIFIER_TRANSACTION_EN_COURS("enum_droit_modifier_transaction_en_cours"),
	    MODIFIER_TRANSACTION_SOLDEE("enum_droit_modifier_transaction_soldee"),
	    MODIFIER_PRIX_UNITAIRE_PRODUIT("enum_droit_modifier_prix_produit"),
	    MODIFIER_LIBELLE_PRODUIT("enum_droit_libelle_produit"),
	    MODIFIER_STOCK_PRODUIT("enum_droit_stock_produit"),
	    CLOTURER_SESSION("enum_droit_cloturer_session"),
	    EFFECTUER_MOUVEMENT_FONDS("enum_droit_effectuer_mouvement_fonds"),
	    OUVRIR_TIROIR_HORS_TRANSACTION("enum_droit_ouvrir_tiroir_hors_transaction"),
	    IMPRIMER_DETAIL_TIROIR("enum_droit_imprimer_detail_tiroir"),
	    X_DE_CAISSE("enum_droit_x_de_caisse");

	    private String labelKey;

	    private EnumDroit(String labelKey) {
	        this.labelKey = labelKey;
	    }
	    
	    public String getLabelKey() {
	        return labelKey;
	    }
}