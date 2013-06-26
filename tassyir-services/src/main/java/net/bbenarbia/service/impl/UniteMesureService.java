package net.bbenarbia.service.impl;

import java.util.Set;

import net.bbenarbia.dao.IUniteMesureDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumTypeUniteMesure;
import net.bbenarbia.service.IUniteMesureService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("uniteMesureService")
@Transactional
public class UniteMesureService extends GenericService<UniteMesure> implements
		IUniteMesureService {

	@Autowired
	private IUniteMesureDao uniteMesureDao;

	@Override
	@Autowired
	@Qualifier("uniteMesureDao")
	public void setGenericDao(IGenericDao<UniteMesure> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public Set<UniteMesure> getUniteByType(EnumTypeUniteMesure type) {
		return uniteMesureDao.getUniteByType(type);
	}

	

}
