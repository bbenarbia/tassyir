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

		boolean withAnd = false; 
		String and = " AND ";
		String where = " WHERE ";
		
		StringBuilder sb = new StringBuilder();
		sb.append("FROM " + getEntityClass().getName());
		
		if(withAnd){
			
		}
		
		if (typeBien != null) {
			sb.append(where);
			sb.append(" typeBien = :type ");
			withAnd = true;
		}
		
		if (departement != null) {
			if(withAnd){
				sb.append(and);
			}
			else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" departement.reference = :departement ");
		}
		if (reference != null) {
			if(withAnd){
				sb.append(and);
			}
			else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" reference = :reference ");
		}
		if (superficieMin != null) {
			if(withAnd){
				sb.append(and);
			}
			else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" superficie >= :superficieMin ");
		}
		if (superficieMax != null) {
			if(withAnd){
				sb.append(and);
			}
			else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" superficie <= :superficieMax ");
		}

		if (loyerMin != null) {
			if(withAnd){
				sb.append(and);
			}
			else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" loyerMensuel >= :loyerMin ");
		}

		if (loyerMax != null) {
			if(withAnd){
				sb.append(and);
			}
			else {
				sb.append(where);
			}
			withAnd = true;
			sb.append(" loyerMensuel <= :loyerMax ");
		}

		Query query = getSession().createQuery(sb.toString());
		if (typeBien != null) {
			query.setParameter("type", typeBien.toString());
		}
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
