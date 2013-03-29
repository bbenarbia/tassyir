package net.bbenarbia.dao.impl.immobilier;

import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.dao.immobilier.IBienDao;
import net.bbenarbia.domain.immobilier.BienImmobilier;

import org.springframework.stereotype.Repository;

@Repository
public class BienDao extends GenericDao<BienImmobilier> implements IBienDao {
	
}
