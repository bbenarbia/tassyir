package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.constants.Constants;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.dao.immobilier.IBienDao;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.service.generic.GenericService;
import net.bbenarbia.service.immobilier.IBienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bienService")
@Transactional
public class BienService extends GenericService<BienImmobilier> implements
		IBienService {

	@Autowired
	private IBienDao bienDao;

    @Override
    @Autowired
    @Qualifier("bienDao")
    public void setGenericDao(IGenericDao<BienImmobilier> genericDao) {
        this.genericDao = bienDao;
    }

	@Override
	public List<BienImmobilier> getEntityByType(String type) {
		return bienDao.getEntityByType(type);
	}

	@Override
	public List<BienImmobilier> getAllAppartement() {
		return getEntityByType(Constants.APPARTEMENT);
	}

	@Override
	public List<BienImmobilier> getAllStudio() {
		return getEntityByType(Constants.STUDIO);
	}

	@Override
	public List<BienImmobilier> getAllTerrain() {
		return getEntityByType(Constants.TERRAIN);
	}

	@Override
	public List<BienImmobilier> getAllEntreport() {
		return getEntityByType(Constants.ENTREPOT);
	}

	@Override
	public List<BienImmobilier> getAllMaison() {
		return getEntityByType(Constants.MAISON);
	}

	@Override
	public List<BienImmobilier> getAllCommerce() {
		return getEntityByType(Constants.COMMERCE);
	}

	@Override
	public List<BienImmobilier> searchBiens(EnumTypeBien typeBien, String departement,
			Double superficieMin, Double superficieMax, Integer NbPiecesMin,
			Integer NbPiecesMax, Double loyerMin, Double loyerMax) {
		
		
		return bienDao.searchBiens(typeBien, departement,
			 superficieMin,  superficieMax,  NbPiecesMin,
			 NbPiecesMax,  loyerMin,  loyerMax);
	}
	
	@Override
	public BienImmobilier getBienByRef(String refBien) {
		return bienDao.getBienByRef(refBien);
	}
	
	@Override
	public List<BienImmobilier> searchBiens(EnumTypeBien typeBien,
			String departement, Double superficieMin,
			Double superficieMax, Integer NbPiecesMin, Integer NbPiecesMax,
			Double loyerMin, Double loyerMax, Boolean ascenseur,
			Boolean cuisineEquipee, Boolean jardin, Boolean interphone,
			Boolean digicode, Boolean gardien, Boolean meuble,
			Boolean adapteHandicape, Boolean piscine, Boolean caves,
			Boolean parking, Boolean terrassesBalcons) {
	
		return bienDao.searchBiens(typeBien, departement,
				 superficieMin,  superficieMax,  NbPiecesMin,
				 NbPiecesMax,  loyerMin,  loyerMax,  ascenseur,
					 cuisineEquipee,  jardin,  interphone,
					 digicode,  gardien,  meuble,
					 adapteHandicape,  piscine,  caves,
					 parking,  terrassesBalcons);
		
	}

}
