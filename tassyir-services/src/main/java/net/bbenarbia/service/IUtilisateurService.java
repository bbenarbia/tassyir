package net.bbenarbia.service;

import java.util.List;

import net.bbenarbia.domain.User;
import net.bbenarbia.service.generic.IGenericService;

/**
 * The Interface IUtilisateurService.
 * 
 * @author moad
 */
public interface IUtilisateurService extends IGenericService<User>{

	User getUtilisateurByCode( Long codeUtilisateur);

	boolean existeLogin(String login);
	
	List<User> getUtilisateursByFirstName(String firstName);
	
	List<User> getUtilisateursByLastName(String lastName);
	
	User getUtilisateurByLogin(String login);
	
	boolean updatePassword(Long userId, String oldPassword , String newPassword);
	
	boolean userCodeExists(Long code) ;		
	
}
