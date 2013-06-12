package net.bbenarbia.dao.immobilier;

import java.util.List;
import java.util.Set;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;

public interface IBienDao extends IGenericDao<BienImmobilier>{

	 List<BienImmobilier> getEntityByType(String type) ;
	 
	 List<BienImmobilier> getLastBiens(int nb);
	 
	 List<BienImmobilier> searchBiens(EnumTypeBien typeBien,  String departement, Double superficieMin , Double superficieMax , 
				Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin, Double loyerMax, EnumTypeOperation typeOperation);
	 
	 BienImmobilier getBienByRef(String refBien) ;
	 
	 List<BienImmobilier> searchBiens(Set<String> selectedTypes, 
			 String departement, Double superficieMin, Double superficieMax,
				Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin,
				Double loyerMax, Boolean ascenseur, Boolean cuisineEquipee,
				Boolean jardin, Boolean interphone, Boolean digicode,
				Boolean gardien, Boolean meuble, Boolean adapteHandicape,
				Boolean piscine, Boolean caves, Boolean parking,
				Boolean terrassesBalcons,  EnumTypeOperation typeOperation);
	 
	 List<BienImmobilier> searchBiensByTown(Long townId);
}
