package net.bbenarbia.dao.impl;

import java.util.HashSet;
import java.util.Set;

import net.bbenarbia.dao.IUniteMesureDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumTypeUniteMesure;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UniteMesureDao extends GenericDao<UniteMesure> implements
		IUniteMesureDao {

	@SuppressWarnings("unchecked")
	@Override
	public Set<UniteMesure> getUniteByType(EnumTypeUniteMesure type) {
		String queryString = "FROM " + getEntityClass().getName()
				+ " WHERE typeUnite = :type";

		Query query = getSession().createQuery(queryString);
		query.setParameter("type", type);

		return new HashSet<UniteMesure>( query.list());
	}

}
