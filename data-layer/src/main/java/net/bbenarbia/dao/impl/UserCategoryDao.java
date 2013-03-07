package net.bbenarbia.dao.impl;

import net.bbenarbia.dao.IUserCategoryDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.UserCategory;

import org.springframework.stereotype.Repository;

@Repository
public class UserCategoryDao extends GenericDao<UserCategory> implements
        IUserCategoryDao {

}
