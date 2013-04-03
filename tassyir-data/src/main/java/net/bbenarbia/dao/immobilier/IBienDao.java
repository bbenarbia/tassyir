package net.bbenarbia.dao.immobilier;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.immobilier.BienImmobilier;

public interface IBienDao extends IGenericDao<BienImmobilier>{

	 List<BienImmobilier> getEntityByType(String type) ;
	 
	 List<BienImmobilier> searchBiens(EnumTypeBien typeBien, String reference, Long departement, Double superficieMin , Double superficieMax , 
				Integer NbPiecesMin, Integer NbPiecesMax, Double loyerMin, Double loyerMax);
}
