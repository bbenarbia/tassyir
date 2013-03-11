package net.bbenarbia.tassyir;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.bbenarbia.service.IUtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@SessionScoped
public class UserBean{
 
	@Autowired
	@Qualifier("utilisateurService")
	private IUtilisateurService utilisateurService;;
 

	public void setUtilisateurService(IUtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public String printMsgFromSpring() {
		return utilisateurService.getMessage();
	}
 
}
