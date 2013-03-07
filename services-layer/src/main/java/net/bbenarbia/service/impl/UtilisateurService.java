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

@Service
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

    
	public User getUtilisateurByCode( int codeUtilisateur) {
		User utilisateur = utilisateurDao
				.getUtilisateurCode(codeUtilisateur);
		return utilisateur;
	}


	@Override
	public List<User> getUtilisateursByName(String name) {
		
		return utilisateurDao.getUtilisateursByName(name);
	}

}