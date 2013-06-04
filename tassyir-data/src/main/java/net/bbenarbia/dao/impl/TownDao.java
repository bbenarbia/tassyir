package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.ITownDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Town;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class TownDao extends GenericDao<Town> implements ITownDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Town> getTownByReference(String reference) {
		String queryString = "FROM Town WHERE reference = :reference";

        Query query = getSession().createQuery(queryString);
        query.setParameter("reference", reference);

        return query.list();
	}
}
