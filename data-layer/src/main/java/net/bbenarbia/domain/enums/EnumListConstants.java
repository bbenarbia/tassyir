package net.bbenarbia.domain.enums;

import org.hibernate.usertype.UserType;

/**
 * This class hosts the list of Enum class names to be used in entities. It also
 * contains the usertype name constant.
 * 
 * @author waleed
 */
public final class EnumListConstants {

	public static final String CATEGORIE_METIER_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumCategorieMetier";
	public static final String CLASSEMENT_PARUTION_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumClassement";
	public static final String CODE_JOUR_PARUTION_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumCodeJour";
	public static final String CODE_RETOUR_INTEGRATION_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumCodeRetourIntegration";
	public static final String DEPOT_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeDepot";
	public static final String ETAT_INVENTAIRE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumEtatInventaire";
	public static final String ETAT_SESSION_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumEtatSession";
	public static final String FONCTION_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumFonction";
	public static final String IDENTITY_SERVICE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeIdentiteService";
	public static final String MODE_REGLEMENT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumModesDeReglement";
	public static final String MODULE_SERVIE_WEB_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumNomModuleServiceWeb";
	public static final String MOTIF_LIGNE_DEMANDE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumMotifLigneDemande";
	public static final String MOYEN_CREATION_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeBonLivraison";
	public static final String NUMEROTATION_PARUTION_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeNumerotation";
	public static final String OPERATION_PRODUIT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeOperationProduit";
	public static final String PERIODICITE_ECHEANCE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumPeriodiciteEcheance";
	public static final String PERIODICITE_PRESSE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumPeriodicitePresse";
	public static final String PERIODICITY_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumPeriodiciteType";
	public static final String REFERENCE_TABAC_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumReferenceTabac";
	public static final String REMISE_MAJORATION_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumRemiseMajoration";
	public static final String SENS_MESSAGE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumSensMessage";
	public static final String SENS_MOUVEMENT_DE_FONDS_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumSensMouvementStock";
	public static final String SENS_MOUVEMENT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumSensMouvementStock";
	public static final String SENS_TRANSFERT_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumSensTransfert";
	public static final String SPECIFICITE_PARUTION_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumSpecificiteParution";
	public static final String STATUT_ENVOI_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumStatutEnvoi";
	public static final String STATUT_LIVRAISON_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumStatutLivraison";
	public static final String STATUT_MESSAGE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumStatutMessage";
	public static final String STATUT_TRANSFERT_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumStatutTransfert";
	public static final String STATUT_VENTE_EN_LIGNE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumStatutVenteEnLigne";
	public static final String POSITION_ZONE_TICKET_CLASSNAME = "com.strator.iris.common.enums.EnumPositionZoneTicket";
	public static final String ACTION_CORRECTION_ANOMALIE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumActionCorrectionAnomalie";
	public static final String CONFIGURATION_REMONTE_VENTE = "com.strator.iris.common.enums.EnumConfigurationRemonteVente";
	public static final String CONFIGURATION_REMONTE_VENTE_GESTION = "com.strator.iris.common.enums.EnumConfigurationRemonteVenteGestion";
	public static final String BATCH_NAME = "com.strator.iris.common.enums.EnumTransactionBatchName";
	public static final String TYPE_ENCAISSEMENT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeEncaissement";
	/**
	 * Hibernate {@link UserType} name to use for Strator Enums configuration.
	 */
	public static final String STRATOR_ENUM_TYPENAME = "StratorEnum";
	public static final String STRATOR_STRING_SET_TYPENAME = "STRING_SET";
	/**
	 * The parameter name to be used when declaring an Enum using hibernate
	 * mapping.
	 */
	public static final String STRATOR_ENUMCLASS_PARAMETER_NAME = "enumClass";
	public static final String TYPE_ACTION_TRANSACTION_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeActionTransaction";
	public static final String TYPE_ALERTE_STRATOR_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeAlerteStrator";
	public static final String TYPE_ANALYSE_DIVERSE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeAnalyseDiverse";
	public static final String TYPE_BORDEREAU_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeBordereau";
	public static final String TYPE_CATALOGUE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeCatalogue";
	public static final String TYPE_CLIENT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeClient";
	public static final String TYPE_CONTACT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeContact";
	public static final String TYPE_DATE_LIVRAISON_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeDateLivraison";
	public static final String TYPE_DEMANDE_DIFFUSEUR_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeDemandeDiffuseur";
	public static final String TYPE_ENREGISTREMENT_BLBI = "com.strator.iris.common.enums.presse.EnumTypeEnregistrementBLBI";
	public static final String TYPE_FACTURE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeFacture";
	public static final String TYPE_FOURNISSEUR_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeFournisseur";
	public static final String TYPE_HOMOLOGATION_PRESSE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeHomologation";
	public static final String TYPE_ICONE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeIcone";
	public static final String TYPE_INFO_SATELLITE_PRESSE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeInfoSatellitePresse";
	public static final String TYPE_INVENTAIRE_ENUM_CLASSNAME = "com.strator.iris.common.enums..EnumTypeInventaire";
	public static final String TYPE_MARGE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeMarge";
	public static final String TYPE_MESSAGE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeMessage";
	public static final String TYPE_MOUVEMENT = "com.strator.iris.common.enums.presse.EnumTypeMouvement";
	public static final String OPERATION_SPECIALE_PRIX_VENTE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumOperationSpecialePrixVente";
	public static final String TYPE_OPV_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumOperationDeVente";
	public static final String TYPE_PRODUIT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeProduit";
	public static final String TYPE_SESSION_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeSession";
	public static final String TYPE_TRANSFERT_PRESSE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeTransfertPresse";
	public static final String TYPE_TVA_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeTVA";
	public static final String FEATURE_FLAG_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeFeatureFlag";
	public static final String TYPE_ETAT_TACHE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeEtatTache";
	public static final String TYPE_TACHE_PRESSE_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeTachePresse";
	public static final String TYPE_TRAITEMENT_SEQUENTIEL_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeTraitementSequentiel";
	public static final String ETAT_TACHE_WORKFLOW_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumEtatTacheWorkflow";
	public static final String CATEGORIE_PRESSE = "com.strator.iris.common.enums.presse.EnumCategoriePresse";
	public static final String CATEGORIE_VENTE_PRESSE = "com.strator.iris.common.enums.presse.EnumCategorieVentePresse";
	public static final String TYPE_DEPOT_PRESSE = "com.strator.iris.common.enums.presse.EnumTypeDepot";
	public static final String OPTION_MAGASIN = "com.strator.iris.common.enums.EnumOptionMagasin";
	public static final String OPTION_MAGASIN_STATUS = "com.strator.iris.common.enums.EnumOptionMagasinStatus";
	public static final String TYPE_OPERATEUR_ETRANSACT = "com.strator.iris.common.enums.EnumTypeOperateur";
	public static final String STATUT_FACTURE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumStatutFacture";
	public static final String MOIS_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumMois";
	public static final String TYPE_OPERATION_RESERVATION_ENUM_CLASSNAME = "com.strator.iris.common.enums.presse.EnumTypeOperationReservation";
	public static final String LOCALITECLIENT_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumLocaliteClientStrator";
	public static final String LANGUAGE_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumLanguage";
	public static final String TYPE_MOUVEMENTDESTOCK_ENUM_CLASSNAME = "com.strator.iris.common.enums.EnumTypeMouvementDeStock";

	private EnumListConstants() {
	}

}