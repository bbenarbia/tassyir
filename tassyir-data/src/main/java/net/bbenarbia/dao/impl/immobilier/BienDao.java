package net.bbenarbia.dao.impl.immobilier;

import java.util.List;

import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.dao.immobilier.IBienDao;
import net.bbenarbia.domain.enums.EnumTypeBien;
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

	@Override
	@SuppressWarnings("unchecked")
	public List<BienImmobilier> searchBiens(EnumTypeBien typeBien,
			String reference, Long departement, Double superficieMin,
			Double superficieMax, Integer NbPiecesMin, Integer NbPiecesMax,
			Double loyerMin, Double loyerMax) {

		StringBuilder sb = new StringBuilder();
		sb.append("FROM " + getEntityClass().getName());
		sb.append(" WHERE typeBien = :type ");
		if (departement != null) {
			sb.append(" AND departement.reference = :departement ");
		}
		if (reference != null) {
			sb.append(" AND reference = :reference ");
		}
		if (superficieMin != null) {
			sb.append(" AND superficie >= :superficieMin ");
		}
		if (superficieMax != null) {
			sb.append(" AND superficie <= :superficieMax ");
		}

		if (loyerMin != null) {
			sb.append(" AND loyerMensuel >= :loyerMin ");
		}

		if (loyerMax != null) {
			sb.append(" AND loyerMensuel <= :loyerMax ");
		}

		Query query = getSession().createQuery(sb.toString());
		query.setParameter("type", typeBien.toString());

		if (departement != null) {
			query.setParameter("departement", departement.toString());
		}
		if (reference != null) {
			query.setParameter("reference", reference);
		}
		if (superficieMin != null) {
			query.setParameter("superficieMin", superficieMin);
		}
		if (superficieMax != null) {
			query.setParameter("superficieMax", superficieMax);
		}

		if (loyerMin != null) {
			query.setParameter("loyerMin", loyerMin);
		}
		if (loyerMax != null) {
			query.setParameter("loyerMax", loyerMax);
		}
		return query.list();
	}

}
