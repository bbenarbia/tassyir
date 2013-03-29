package net.bbenarbia.service.impl;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.dao.immobilier.IBienDao;
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
}
