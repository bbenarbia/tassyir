package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.Utilisateur;

/**
 * The Interface IUtilisateurService.
 * 
 * @author moad
 */
public interface IUtilisateurService {

	Utilisateur getUtilisateurByCode(int groupeId, int codeUtilisateur);

	/**
	 * @param filter
	 * @return
	 */
	List<String> getUtilisateurAndGestionnaireListOfLogins(String filter);

	/**
	 * gets the list of existent employees
	 * 
	 * @param groupeId
	 * @return list of employees
	 */
//	List<UtilisateurDTO> getExistentEmployeeList(int groupeId);
}
