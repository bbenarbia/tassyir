package net.bbenarbia.dao;

import java.util.List;

import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.User;


/**
 * IUtilisateurDao
 * @author moad
 */
public interface IUserDao extends IGenericDao<User>{

    /**
     * Load user by it's login.
     * @param login
     * @return user
     */
	User getUtilisateurByLogin(String login);

    /**
     * Get utilisateur groupeId by login name. This function will be used just one time per creation
     * of session to retrieve the user groupeId.
     * @param login
     *            - the user's login name
     * @return the groupeId of the user or null if the user doesn't exist
     */

    /**
     * @param code
     * @return
     */
    User getUtilisateurCode(Long code);

    /**
     * @param code
     * @return
     */
    boolean existUserWithCode(Long code);

    /**
     * @param name
     * @return
     */
    List<User> getUtilisateursByFirstName(String name);

    
    List<User> getUtilisateursByLastName(String name);
    
    /**
     * @param refUtilisateur
     * @return
     */
    User getUtilisateurParRef(Long refUtilisateur);

    /**
     * @param login
     * @return
     */
    List<User> getUtilisateursByLogin(String login);

    
	boolean existeLogin(String login);

	boolean userCodeExists(Long code);
	
}
