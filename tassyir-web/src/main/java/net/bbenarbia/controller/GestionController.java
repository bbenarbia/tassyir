package net.bbenarbia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gestion/**")
public class GestionController {
//	 private static final Logger LOGGER = LoggerFactory.getLogger(GestionController.class);

	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String goToUsers() {
        return "users/userindex";
    }
	

}
