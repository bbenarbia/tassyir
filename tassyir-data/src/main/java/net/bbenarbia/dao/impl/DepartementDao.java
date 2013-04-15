package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.IDepartementDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Departement;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


@Repository
public class DepartementDao extends GenericDao<Departement> implements IDepartementDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Departement> getDepartementByReference(String reference) {
		String queryString = "FROM Departement WHERE reference = :reference";

        Query query = getSession().createQuery(queryString);
        query.setParameter("reference", reference);

        return query.list();
	}
}
