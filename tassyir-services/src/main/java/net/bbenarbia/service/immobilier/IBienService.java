package net.bbenarbia.service.immobilier;

import java.util.List;

import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.service.generic.IGenericService;

public interface IBienService extends IGenericService<BienImmobilier> {

	List<BienImmobilier> getEntityByType(String type) ;
	
	List<BienImmobilier> getAllAppartement() ;
	List<BienImmobilier> getAllStudio() ;
	List<BienImmobilier> getAllTerrain() ;
	List<BienImmobilier> getAllEntreport() ;
	List<BienImmobilier> getAllMaison() ;
	List<BienImmobilier> getAllCommerce() ;
}
