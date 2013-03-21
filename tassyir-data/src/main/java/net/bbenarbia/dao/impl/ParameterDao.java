package net.bbenarbia.dao.impl;

import net.bbenarbia.dao.IParameterDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Parameter;

import org.springframework.stereotype.Repository;

@Repository
public class ParameterDao extends GenericDao<Parameter> implements
		IParameterDao{


}
