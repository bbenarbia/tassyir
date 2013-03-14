package net.bbenarbia.service.impl;

import net.bbenarbia.dao.IUserCategoryDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserCategoryService extends GenericService<UserCategory> implements
		IUserCategoryService {

	@Autowired
	private IUserCategoryDao userCategoryDao;

	@Override
	@Autowired
	@Qualifier("userCategoryDao")
	public void setGenericDao(IGenericDao<UserCategory> genericDao) {
		this.genericDao = genericDao;
	}
}
