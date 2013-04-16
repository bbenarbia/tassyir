package net.bbenarbia.dao.immobilier;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.immobilier.BienImmobilier;

public interface IBienDao extends IGenericDao<BienImmobilier>{

	 List<BienImmobilier> getEntityByType(String type) ;
	 
	 List<BienImmobilier> searchBiens(EnumTypeBien typeBien,  String departement, Double superficieMin , Double superficieMax , 
				Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin, Double loyerMax);
	 
	 BienImmobilier getBienByRef(String refBien) ;
	 
	 List<BienImmobilier> searchBiens(EnumTypeBien typeBien, 
			 String departement, Double superficieMin, Double superficieMax,
				Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin,
				Double loyerMax, Boolean ascenseur, Boolean cuisineEquipee,
				Boolean jardin, Boolean interphone, Boolean digicode,
				Boolean gardien, Boolean meuble, Boolean adapteHandicape,
				Boolean piscine, Boolean caves, Boolean parking,
				Boolean terrassesBalcons);
}
