package net.bbenarbia.service.immobilier;

import java.util.List;
import java.util.Set;

import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.service.generic.IGenericService;

public interface IBienService extends IGenericService<BienImmobilier> {

	List<BienImmobilier> getEntityByType(String type);

	List<BienImmobilier> getAllAppartement();

	List<BienImmobilier> getAllStudio();

	List<BienImmobilier> getAllTerrain();

	List<BienImmobilier> getAllEntreport();

	List<BienImmobilier> getAllMaison();

	List<BienImmobilier> getAllCommerce();
	
	BienImmobilier getBienByRef(String refBien);

	List<BienImmobilier> searchBiens(EnumTypeBien typeBien, 
			String departement, Double superficieMin, Double superficieMax,
			Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin,
			Double loyerMax,  EnumTypeOperation typeOperation);

	List<BienImmobilier> searchBiens(Set<String> selectedTypes , 
			String departement, Double superficieMin, Double superficieMax,
			Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin,
			Double loyerMax, Boolean ascenseur, Boolean cuisineEquipee,
			Boolean jardin, Boolean interphone, Boolean digicode,
			Boolean gardien, Boolean meuble, Boolean adapteHandicape,
			Boolean piscine, Boolean caves, Boolean parking,
			Boolean terrassesBalcons, EnumTypeOperation typeOperation);

}
