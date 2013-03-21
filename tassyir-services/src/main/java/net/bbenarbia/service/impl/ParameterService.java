package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.dao.IParameterDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Parameter;
import net.bbenarbia.service.IParameterService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("parameterService")
@Transactional
public class ParameterService extends GenericService<Parameter> implements
		IParameterService {

	@Autowired
	private IParameterDao parameterDao;

	@Override
	@Autowired
	@Qualifier("parameterDao")
	public void setGenericDao(IGenericDao<Parameter> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<Parameter> getParameterName(String name) {
		return parameterDao.getEntityByName(name);
	}

}
