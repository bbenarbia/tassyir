package net.bbenarbia.dao.impl.immobilier;

import java.util.List;

import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.dao.immobilier.IBienDao;
import net.bbenarbia.domain.immobilier.BienImmobilier;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BienDao extends GenericDao<BienImmobilier> implements IBienDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> getEntityByType(String type) {
		String queryString = "FROM " + getEntityClass().getName()
				+ " WHERE typeBien = :type";

		Query query = getSession().createQuery(queryString);
		query.setParameter("type", type);

		return query.list();
	}
}
