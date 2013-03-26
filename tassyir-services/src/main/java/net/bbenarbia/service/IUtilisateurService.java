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


	List<User> getUtilisateursByFirstName(String firstName);
	
	
	List<User> getUtilisateursByLastName(String lastName);
	
	boolean updatePassword(Long userId, String oldPassword , String newPassword);
		 
}
