package net.bbenarbia.dao.immobilier;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.immobilier.BienImmobilier;

public interface IBienDao extends IGenericDao<BienImmobilier>{

	 List<BienImmobilier> getEntityByType(String type) ;
}
