package net.bbenarbia.web.controller;

import java.util.LinkedList;
import java.util.List;

import net.bbenarbia.domain.Departement;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.service.IDepartementService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.FindBienDTO;

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
	 
	@Autowired
	private IDepartementService departementservice;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<Departement> listDepartements = departementservice.getAll();
		
		
		List<EnumTypeOperation> typesOperationsList = new LinkedList<EnumTypeOperation>();
		for (EnumTypeOperation typeOperationBien : EnumTypeOperation.values()) {
			typesOperationsList.add(typeOperationBien);
		}
		
		List<EnumTypeBien> typesLogementList = new LinkedList<EnumTypeBien>();
		for (EnumTypeBien typeBien : EnumTypeBien.values()) {
			typesLogementList.add(typeBien);
		}
		
		FindBienDTO findBienDto = new FindBienDTO();
		
		model.addAttribute("findBiens", findBienDto);
		model.addAttribute("departementsList", new LinkedList<Departement>(listDepartements));
		model.addAttribute("typesOperationsList", typesOperationsList);
		model.addAttribute("typesLogementList", typesLogementList);
		
//		List<BienImmobilier> results1 = this.bienService.getEntityByType(Constants.APPARTEMENT);
//		
//		model.addAttribute("selections", results1);
//		
//		
//		model.addAttribute("message", "Tassyir Home page");
////		LOG.debug("Index Controller ");
//		
//		Studio studio = new Studio();
////		studio.setAdresse("adresse");
//		studio.setAge(10);
//		studio.setAscenseur(false);
//		studio.setChargesMensuel(100);
//		studio.setDescription("Studio 1 save");
//		studio.setEtage("1/3");
//		studio.setEtatBien(EnumEtatBien.CORRECT);
//		studio.setLoyerMensuel(200);
//		studio.setName("Studio ben");
//		studio.setPrixVente(300);
//		studio.setReference("ref1111");
//		studio.setStatus(EnumStatutProperty.DISPONIBLE);
//		studio.setSuperficie(200);
//		studio.setTypeOperation(EnumTypeOperation.LOCATION);
//		
//		bienService.save(studio);

		
		return "index";
	}

	
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(ModelMap model) {
//
//		return "login";
//	}
}