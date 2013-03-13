package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.IUserDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.User;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;


/**
 * UtilisateurDao.
 * @author Generator
 * @date 26/04/2010 15:38:55
 * @version 1.0
 */
@Repository
public class UtilisateurDao extends  GenericDao<User> implements IUserDao {

    /**
     * Override save method to increment the codeUtilisateur if it's not null
     */
    @Override
    public long save(User utilisateur) {
        return super.save(utilisateur);
    }

    /**
     * Load user by it's login.
     * @param login
     * @return user
     */
    public User getUtilisateurByLogin( String login) {
        String queryString = "FROM User WHERE  login = :login";
        Query query = getSession().createQuery(queryString);
        query.setParameter("login", login);

        return (User) query.uniqueResult();
    }

    public User getUtilisateurCode(Long code) {
        String queryString = "FROM User WHERE code = :code";

        Query query = getSession().createQuery(queryString);
        query.setParameter("code", code);

        return (User) query.uniqueResult();
    }

    public boolean existUserWithCode(Long code) {
        String queryString = "SELECT id FROM User WHERE code = :code";

        Query query = getSession().createQuery(queryString);
        query.setParameter("code", code);

        return query.uniqueResult() != null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUtilisateursByLogin(String login) {
        String queryString = "FROM User WHERE login = :login";

        Query query = getSession().createQuery(queryString);
        query.setParameter("login", login);

        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUtilisateursByFirstName(String firstName) {
        String queryString = "FROM User WHERE first_name = :name";

        Query query = getSession().createQuery(queryString);
        query.setParameter("name", firstName);

        return query.list();
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUtilisateursByLastName(String lastName) {
        String queryString = "FROM User WHERE last_name = :name";

        Query query = getSession().createQuery(queryString);
        query.setParameter("name", lastName);

        return query.list();
    }

    @Override
    public User getUtilisateurParRef(Long refUtilisateur) {
        String queryString = "FROM User WHERE refId.id = :ref";

        Query query = getSession().createQuery(queryString);
        query.setParameter("ref", refUtilisateur);

        return (User) query.uniqueResult();
    }


}
