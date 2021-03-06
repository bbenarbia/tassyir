package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.dao.IUserDao;
import net.bbenarbia.dao.common.IGenericDao;
import net.bbenarbia.domain.User;
import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.service.generic.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("utilisateurService")
@Transactional
public class UtilisateurService extends GenericService<User> implements IUtilisateurService {

	@Autowired
	private IUserDao utilisateurDao;

    @Override 
    @Autowired
    @Qualifier("utilisateurDao")
    public void setGenericDao(IGenericDao<User> genericDao) {
        this.genericDao = genericDao;
    }

    @Override
	public User getUtilisateurByCode(Long codeUtilisateur) {
		User utilisateur = utilisateurDao
				.getUtilisateurCode(codeUtilisateur);
		return utilisateur;
	}


	@Override
	public List<User> getUtilisateursByFirstName(String firstName) {
		
		return utilisateurDao.getUtilisateursByFirstName(firstName);
	}
	
	@Override
	public User getUtilisateurByLogin(String login) {
		return utilisateurDao.getUtilisateurByLogin(login);
	}
	
	
	@Override
	public List<User> getUtilisateursByLastName(String LastName) {
		
		return utilisateurDao.getUtilisateursByLastName(LastName);
	}

	@Override
	public boolean updatePassword(Long userId, String oldPassword , String newPassword) {
		
		User user = utilisateurDao.get(userId);
		if(user.getPassword().equals(oldPassword)){
			user.setPassword(newPassword);
			utilisateurDao.save(user);
			return true;
		}
		else return false;
		
		
	}

	@Override
	public boolean existeLogin(String login) {
		return utilisateurDao.existeLogin(login);
	}
	
	@Override
	public boolean userCodeExists(Long code) {
		return utilisateurDao.userCodeExists(code);
	}

}