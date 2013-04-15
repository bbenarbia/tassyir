package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.dao.IDepartementDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Departement;
import net.bbenarbia.service.IDepartementService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("departementService")
@Transactional
public class DepartementService extends GenericService<Departement> implements
		IDepartementService {

	@Autowired
	private IDepartementDao departementDao;

	@Override
	@Autowired
	@Qualifier("departementDao")
	public void setGenericDao(IGenericDao<Departement> genericDao) {
		this.genericDao = genericDao;
	}

	
	@Override
	public List<Departement> getDepartementByReference(String reference) {
		
		return departementDao.getDepartementByReference(reference);
	}

}
