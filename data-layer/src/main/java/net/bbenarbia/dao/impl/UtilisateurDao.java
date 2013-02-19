package net.bbenarbia.dao.impl;

import java.util.List;

import net.bbenarbia.dao.IUtilisateurDao;
import net.bbenarbia.dao.common.GenericDao;
import net.bbenarbia.domain.Utilisateur;
import net.bbenarbia.domain.dto.UtilisateurDTO;
import net.bbenarbia.domain.enums.EnumRole;

import org.hibernate.Query;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;


/**
 * UtilisateurDao.
 * @author Generator
 * @date 26/04/2010 15:38:55
 * @version 1.0
 */
@Repository
public class UtilisateurDao extends  GenericDao<Utilisateur> implements IUtilisateurDao {

    /**
     * Override save method to increment the codeUtilisateur if it's not null
     */
    @Override
    public long save(Utilisateur utilisateur) {
        if (utilisateur != null
                && (utilisateur.getCodeUtilisateur() == null || utilisateur.getCodeUtilisateur().equals(0))) {
            Integer maxCodeUtilisateur = getMaxCodeUtilisateurForGroupeId(utilisateur.getGroupeId());
            utilisateur.setCodeUtilisateur(maxCodeUtilisateur + 1);
        }

        return super.save(utilisateur);
    }

    private Integer getMaxCodeUtilisateurForGroupeId(Integer groupeId) {
        String queryString = "SELECT MAX(codeUtilisateur) FROM Utilisateur WHERE groupeId = :groupeId";

        Query query = getSession().createQuery(queryString);
        query.setInteger("groupeId", groupeId);

        Integer maxCodeUtilisateur = (Integer) query.uniqueResult();

        return maxCodeUtilisateur != null ? maxCodeUtilisateur : 0;
    }

    /**
     * Load user by it's login.
     * @param groupeId
     * @param login
     * @return user
     */
    public Utilisateur getUtilisateurByLogin(Integer groupeId, String login) {
        String queryString = "FROM Utilisateur WHERE groupeId = :groupeId AND login = :login";

        Query query = getSession().createQuery(queryString);
        query.setParameter("groupeId", groupeId);
        query.setParameter("login", login);

        return (Utilisateur) query.uniqueResult();
    }

    @Override
    public Long getRefIdUtilisateurByNomUtilisateur(Integer groupeId, String nomUtilisateur) {
        String queryString = "SELECT refId.id FROM Utilisateur WHERE nomUtilisateur = :nomUtilisateur AND groupeId = :groupeId";

        Query query = getSession().createQuery(queryString);
        query.setString("nomUtilisateur", nomUtilisateur);
        query.setInteger("groupeId", groupeId);

        return (Long) query.uniqueResult();
    }

    public Utilisateur getUtilisateurParCode(Integer code) {
        String queryString = "FROM Utilisateur WHERE codeUtilisateur = :code";

        Query query = getSession().createQuery(queryString);
        query.setParameter("code", code);

        return (Utilisateur) query.uniqueResult();
    }

    public Utilisateur getUtilisateurParGroupeIdAndCode(Integer groupeId, Integer code) {
        String queryString = "FROM Utilisateur WHERE codeUtilisateur = :code AND groupeId = :groupeId";

        Query query = getSession().createQuery(queryString);
        query.setParameter("code", code);
        query.setParameter("groupeId", groupeId);

        return (Utilisateur) query.uniqueResult();
    }

    public boolean existUserWithCode(Integer code, Integer groupeId) {
        String queryString = "SELECT id FROM Utilisateur WHERE codeUtilisateur = :code AND groupeId = :groupeId";

        Query query = getSession().createQuery(queryString);
        query.setParameter("code", code);
        query.setParameter("groupeId", groupeId);

        return query.uniqueResult() != null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Utilisateur> getUtilisateursByLogin(String login) {
        String queryString = "FROM Utilisateur WHERE login = :login";

        Query query = getSession().createQuery(queryString);
        query.setParameter("login", login);

        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Utilisateur> getUtilisateursByName(Integer groupeId, String name) {
        String queryString = "FROM Utilisateur WHERE groupeId = :groupeId AND nomUtilisateur = :name";

        Query query = getSession().createQuery(queryString);
        query.setParameter("name", name);
        query.setParameter("groupeId", groupeId);

        return query.list();
    }

    @Override
    public Utilisateur getUtilisateurParRef(long refUtilisateur) {
        String queryString = "FROM Utilisateur WHERE refId.id = :ref";

        Query query = getSession().createQuery(queryString);
        query.setParameter("ref", refUtilisateur);

        return (Utilisateur) query.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * @see com.strator.iris.common.dao.IUtilisateurDao#getUtilisateurGroupeIdByLogin
     * (java.lang.String)
     */
    @Override
    public Integer getUtilisateurGroupeIdByLogin(String login) {
        String queryString = "SELECT groupeId FROM Utilisateur WHERE login = :login";

        Query query = getSession().createQuery(queryString);
        query.setParameter("login", login);

        return (Integer) query.uniqueResult();
    }

    @Override
    public void deleteWithSuppression(Utilisateur utilisateur) {
        utilisateur.setDateSuppression(new LocalDateTime());
        saveOrUpdate(utilisateur);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getFilteredLoginsOfUsers(String filter) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(" SELECT user.login ");
        queryBuilder.append(" FROM Utilisateur user ");
        queryBuilder.append(" LEFT JOIN user.roles role ");
        queryBuilder.append(" WHERE role IN (:searchableRoles) AND user.login LIKE :expr ");

        Query query = getSession().createQuery(queryBuilder.toString());
        query.setParameterList("searchableRoles", new EnumRole[] {EnumRole.GESTIONNAIRE, EnumRole.UTILISATEUR});
        query.setString("expr", filter + "%");

        return (List<String>) query.list();
    }

    

    @SuppressWarnings("unchecked")
    @Override
    public List<Utilisateur> getUtilisateursByGroupeId(Integer groupeId) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("FROM Utilisateur utilisateur");
        queryBuilder.append("WHERE groupeid = :groupeId AND dateSuppression = null");

        Query query = getSession().createQuery(queryBuilder.toString());
        query.setParameter("groupeId", groupeId);
        return (List<Utilisateur>) query.list();
    }

    /**
     * Returns existent users (that were not deleted)
     * @param groupeId
     * @return list of users
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<UtilisateurDTO> getExistentEmployeeList(int groupeId) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(" SELECT NEW ").append(UtilisateurDTO.class.getName()).append(
                " (nomUtilisateur, codeUtilisateur) FROM Utilisateur ");
        queryBuilder.append(" WHERE groupeId = :groupeId AND dateSuppression = null ");
        queryBuilder.append(" ORDER BY nomUtilisateur ");

        Query query = getSession().createQuery(queryBuilder.toString());
        query.setParameter("groupeId", groupeId);

        return (List<UtilisateurDTO>) query.list();
    }
}
