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

    public User getUtilisateurCode(Integer code) {
        String queryString = "FROM User WHERE codeUtilisateur = :code";

        Query query = getSession().createQuery(queryString);
        query.setParameter("code", code);

        return (User) query.uniqueResult();
    }

    public boolean existUserWithCode(Integer code) {
        String queryString = "SELECT id FROM User WHERE codeUtilisateur = :code";

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
    public List<User> getUtilisateursByName(String name) {
        String queryString = "FROM User WHERE first_name = :name";

        Query query = getSession().createQuery(queryString);
        query.setParameter("name", name);

        return query.list();
    }

    @Override
    public User getUtilisateurParRef(long refUtilisateur) {
        String queryString = "FROM User WHERE refId.id = :ref";

        Query query = getSession().createQuery(queryString);
        query.setParameter("ref", refUtilisateur);

        return (User) query.uniqueResult();
    }


//    @Override
//    public void deleteWithSuppression(User utilisateur) {
//        utilisateur.setDateSuppression(new LocalDateTime());
//        saveOrUpdate(utilisateur);
//    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<String> getFilteredLoginsOfUsers(String filter) {
//        StringBuilder queryBuilder = new StringBuilder();
//        queryBuilder.append(" SELECT user.login ");
//        queryBuilder.append(" FROM Utilisateur user ");
//        queryBuilder.append(" LEFT JOIN user.roles role ");
//        queryBuilder.append(" WHERE role IN (:searchableRoles) AND user.login LIKE :expr ");
//
//        Query query = getSession().createQuery(queryBuilder.toString());
//        query.setParameterList("searchableRoles", new EnumRole[] {EnumRole.GESTIONNAIRE, EnumRole.UTILISATEUR});
//        query.setString("expr", filter + "%");
//
//        return (List<String>) query.list();
//    }

    

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<User> getUtilisateursByGroupeId(Integer groupeId) {
//        StringBuilder queryBuilder = new StringBuilder();
//        queryBuilder.append("FROM Utilisateur utilisateur");
//        queryBuilder.append("WHERE  dateSuppression = null");
//
//        Query query = getSession().createQuery(queryBuilder.toString());
//        query.setParameter("groupeId", groupeId);
//        return (List<User>) query.list();
//    }

}
