package net.bbenarbia.dao.impl;

import net.bbenarbia.dao.IContactDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Contact;
import net.bbenarbia.domain.enums.EnumTypeContact;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


/**
 * ContactDao
 * @author Generator
 * @date 26/04/2010 15:38:53
 * @version 1.0
 */
@Repository
public class ContactDao extends GenericDao<Contact> implements IContactDao {

    public static final String TABLE_ALIAS = "contact";
    public static final String FIELD_CONTACT_NOM = TABLE_ALIAS + ".name";
    public static final String FIELD_CONTACT_EMAIL = TABLE_ALIAS + ".adresseMailContact";
    public static final String FIELD_CONTACT_VILLE = TABLE_ALIAS + ".villeContact";
    public static final String FIELD_GROUPE_ID = TABLE_ALIAS + ".groupeId";

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IContactDao#getByName(java.lang.String, boolean)
     */
    @Override
    public Contact getByName(Integer groupeId, String name, boolean ignoreCase) {
        Criteria criteria = getSession().createCriteria(getEntityClass(), TABLE_ALIAS);
        if (ignoreCase) {
            criteria.add(Restrictions.eq(FIELD_CONTACT_NOM, name).ignoreCase());
        } else {
            criteria.add(Restrictions.eq(FIELD_CONTACT_NOM, name));
        }
        criteria.setMaxResults(1);
        return (Contact) criteria.uniqueResult();
    }

    @Override
    public Contact getContact(Integer groupeId, EnumTypeContact typeContact) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(" SELECT contact ");
        queryBuilder.append(" FROM Contact contact ");
        queryBuilder.append(" WHERE contact.typeContact = :typeContact");
        queryBuilder.append(" AND contact.estContactPrincipal is true");

        Query query = getSession().createQuery(queryBuilder.toString());
        query.setParameter("typeContact", typeContact);
        query.setMaxResults(1);
        return (Contact) query.uniqueResult();
    }



}