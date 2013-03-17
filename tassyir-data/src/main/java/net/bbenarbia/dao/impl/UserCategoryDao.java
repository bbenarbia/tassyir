package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.IUserCategoryDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.UserCategory;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserCategoryDao extends GenericDao<UserCategory> implements
		IUserCategoryDao {

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<UserCategory> getUserCategoryByName(String name) {
//		String queryString = "FROM UserCategory WHERE name = :name";
//
//		Query query = getSession().createQuery(queryString);
//		query.setParameter("name", name);
//
//		return query.list();
//	}

}
