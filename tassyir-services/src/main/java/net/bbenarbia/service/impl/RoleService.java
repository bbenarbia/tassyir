package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.dao.IRoleDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Role;
import net.bbenarbia.service.IRoleService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
@Transactional
public class RoleService extends GenericService<Role> implements
		IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	@Autowired
	@Qualifier("roleDao")
	public void setGenericDao(IGenericDao<Role> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List<Role> getParameterName(String name) {
		return roleDao.getEntityByName(name);
	}

}