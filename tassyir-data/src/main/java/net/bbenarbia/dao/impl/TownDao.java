package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.ITownDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.enums.EnumTypeVille;

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
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Town> getTownByType(EnumTypeVille type) {
	String queryString = "FROM " + getEntityClass().getName()
			+ " WHERE typeVille = :type";

	Query query = getSession().createQuery(queryString);
	query.setParameter("type", type);

	return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Town> getCommunesByState(String state) {
	String queryString = "FROM " + getEntityClass().getName()
			+ " WHERE typeVille = :type AND departement = :departement";

	Query query = getSession().createQuery(queryString);
	query.setParameter("departement", state);
	query.setParameter("type", EnumTypeVille.COMMUNE);
	
	return query.list();
	}
}
