package net.bbenarbia.service.impl;

import java.util.List;

import net.bbenarbia.dao.IUtilisateurDao;
import net.bbenarbia.domain.Utilisateur;
import net.bbenarbia.service.IUtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commonUtilisateurService")
@Transactional
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	private transient IUtilisateurDao utilisateurDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.bbenarbia.service.IUtilisateurService#
	 * getUtilisateurByCode(int, int)
	 */
	
	public Utilisateur getUtilisateurByCode(int groupeId, int codeUtilisateur) {
		Utilisateur utilisateur = utilisateurDao
				.getUtilisateurParGroupeIdAndCode(groupeId, codeUtilisateur);
		return utilisateur;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.bbenarbia.service.IUtilisateurService#
	 * getUtilisateurAndGestionnaireListOfLogins(java.lang.String)
	 */
	
	public List<String> getUtilisateurAndGestionnaireListOfLogins(String filter) {
		return utilisateurDao.getFilteredLoginsOfUsers(filter);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see net.bbenarbia.service.IUtilisateurService# 
	 *                                                                   getExistentEmployeeList
	 *                                                                   (int)
	 */
//	@Override
//	public List<UtilisateurDTO> getExistentEmployeeList(int groupeId) {
//		return utilisateurDao.getExistentEmployeeList(groupeId);
//	}
}