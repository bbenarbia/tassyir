package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.IFonctionDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Fonction;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


/**
 * FonctionDao
 * @author Generator
 * @date 26/04/2010 15:38:53
 * @version 1.0
 */
@Repository
public class FonctionDao extends GenericDao<Fonction> implements IFonctionDao {

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IFonctionDao#getAllFonctionAssociable(int)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Fonction> getAllFonctionAssociable(int groupdID) {
        String queryString = " FROM Fonction ";
        queryString += " WHERE (groupeId = :groupeId or groupeid = 1) AND estassociableparraccourci = true ";
        queryString += " ORDER BY libelleFonction ASC";

        Query query = getSession().createQuery(queryString);
        query.setInteger("groupeId", groupdID);

        return query.list();
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IFonctionDao#getByLabel(java.lang.String)
     */
    @Override
    public Fonction getByLabel(String label) {
        String queryString = " FROM Fonction ";
        queryString += " WHERE groupeId = :groupeId and lower(libelleFonction) = lower(:label) ";

        Query query = getSession().createQuery(queryString);
        query.setParameter("label", label);
        query.setInteger("groupeId", 1);

        return (Fonction) query.uniqueResult();
    }
}