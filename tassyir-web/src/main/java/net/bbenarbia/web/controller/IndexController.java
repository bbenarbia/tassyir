package net.bbenarbia.web.controller;

import java.util.List;

import net.bbenarbia.constants.Constants;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.domain.immobilier.Studio;
import net.bbenarbia.service.immobilier.IBienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "/" })
public class IndexController {

	@Autowired
	IBienService bienService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<BienImmobilier> results1 = this.bienService.getEntityByType(Constants.APPARTEMENT);
		
		model.addAttribute("selections", results1);
		
		
		model.addAttribute("message", "Tassyir Home page");
//		LOG.debug("Index Controller ");
		
		Studio studio = new Studio();
		studio.setAdresse("adresse");
		studio.setAge(10);
		studio.setAscenseur(false);
		studio.setChargesMensuel(100);
		studio.setDescription("Studio 1 save");
		studio.setEtage(1);
		studio.setEtatBien(EnumEtatBien.CORRECT);
		studio.setLoyerMensuel(200);
		studio.setName("Studio ben");
		studio.setPrixMinVente(200);
		studio.setPrixVente(300);
		studio.setReference("ref1111");
		studio.setStatus(EnumStatutProperty.DISPONIBLE);
		studio.setSuperficie(200);
		studio.setTypeOperation(EnumTypeOperation.A_LOUER);
		
		bienService.save(studio);

		return "index";

	}

}