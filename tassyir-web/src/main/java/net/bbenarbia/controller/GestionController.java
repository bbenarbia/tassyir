package net.bbenarbia.controller;

import java.util.List;

import net.bbenarbia.domain.Utilisateur;
import net.bbenarbia.service.IUtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gestion/**")
public class GestionController {
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(GestionController.class);
	@Autowired
	private IUtilisateurService utilisateurService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String goToUsers() {
		return "users/userindex";
	}

	@RequestMapping(value = "/listusers", method = RequestMethod.GET)
	public String getUserList() {

		List<Utilisateur> userList = utilisateurService.getAllUtilisateurs();
		for (Utilisateur utilisateur : userList) {
			System.out.println(utilisateur.getLogin());
		}
		return "users/listusers";
	}

}
