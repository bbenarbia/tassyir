package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.dao.ITownDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.enums.EnumTypeVille;
import net.bbenarbia.service.ITownService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("townService")
@Transactional
public class TownService extends GenericService<Town> implements
		ITownService {

	@Autowired
	private ITownDao townDao;

	@Override
	@Autowired
	@Qualifier("townDao")
	public void setGenericDao(IGenericDao<Town> genericDao) {
		this.genericDao = genericDao;
	}

	
	@Override
	public List<Town> getTownByReference(String reference) {
		
		return townDao.getTownByReference(reference);
	}


	@Override
	public List<Town> getTownByType(EnumTypeVille type) {
		return townDao.getTownByType(type);
	}


	@Override
	public List<Town> getCommunesByState(String state) {
		return townDao.getCommunesByState(state);
	}

}
