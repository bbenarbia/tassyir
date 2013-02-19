package net.bbenarbia.dao;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.Utilisateur;
import net.bbenarbia.domain.dto.UtilisateurDTO;


/**
 * IUtilisateurDao
 * @author moad
 */
public interface IUtilisateurDao extends IGenericDao<Utilisateur>{

    /**
     * Load user by it's login.
     * @param groupeId
     * @param login
     * @return user
     */
	Utilisateur getUtilisateurByLogin(Integer groupeId, String login);

    /**
     * Get utilisateur groupeId by login name. This function will be used just one time per creation
     * of session to retrieve the user groupeId.
     * @param login
     *            - the user's login name
     * @return the groupeId of the user or null if the user doesn't exist
     */
    Integer getUtilisateurGroupeIdByLogin(String login);

    /**
     * @param code
     * @return
     */
    Utilisateur getUtilisateurParCode(Integer code);

    /**
     * @param groupeId
     * @param code
     * @return
     */
    Utilisateur getUtilisateurParGroupeIdAndCode(Integer groupeId, Integer code);

    /**
     * @param code
     * @param groupeId
     * @return
     */
    boolean existUserWithCode(Integer code, Integer groupeId);

    /**
     * @param groupeId
     * @param name
     * @return
     */
    List<Utilisateur> getUtilisateursByName(Integer groupeId, String name);

    /**
     * @param refUtilisateur
     * @return
     */
    Utilisateur getUtilisateurParRef(long refUtilisateur);

    /**
     * @param entity
     */
    void deleteWithSuppression(Utilisateur entity);

    /**
     * @param login
     * @return
     */
    List<Utilisateur> getUtilisateursByLogin(String login);

    /**
     * @param groupeId
     * @param nomUtilisateur
     * @return
     */
    Long getRefIdUtilisateurByNomUtilisateur(Integer groupeId, String nomUtilisateur);

    /**
     * @param filter
     * @return
     */
    List<String> getFilteredLoginsOfUsers(String filter);


    /**
     * Returns list of users of store
     * @param groupeId
     * @return list of users
     */
    List<Utilisateur> getUtilisateursByGroupeId(Integer groupeId);
    
    /**
     * gets the existent employees
     * @param groupeId
     * @return list of users
     */
    List<UtilisateurDTO> getExistentEmployeeList(int groupeId);
}
