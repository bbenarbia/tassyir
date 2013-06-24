package net.bbenarbia.web.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.service.ITownService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.FindBienDTO;
import net.bbenarbia.web.validator.FindBienValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping({ "/" })
public class IndexController {

	@Autowired
	IBienService bienService;
	 
	@Autowired
	private ITownService departementservice;
	
	@Autowired
	private BienSearchController searchController;
	
	@Autowired
	private FindBienValidator validator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<Town> listDepartements = departementservice.getAll();
		
		
		List<EnumTypeOperation> typesOperationsList = new LinkedList<EnumTypeOperation>();
		for (EnumTypeOperation typeOperationBien : EnumTypeOperation.values()) {
			typesOperationsList.add(typeOperationBien);
		}
		
		List<EnumTypeBien> typesLogementList = new LinkedList<EnumTypeBien>();
		for (EnumTypeBien typeBien : EnumTypeBien.values()) {
			typesLogementList.add(typeBien);
		}
		
		FindBienDTO findBienDto = new FindBienDTO();
		findBienDto.setTypeOperationBien(1);//Vente par default
		model.addAttribute("findBiens", findBienDto);
		model.addAttribute("departementsList", new LinkedList<Town>(listDepartements));
		model.addAttribute("typesOperationsList", typesOperationsList);
		model.addAttribute("typesLogementList", typesLogementList);
		
		return "index";
	}

	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String rechercheSpecifiqueBiensInit(@ModelAttribute("findBiens") FindBienDTO findBienDto,BindingResult result,
			 Model model, SessionStatus status,
				HttpSession session) {
		
		validator.validate(findBienDto, result);
		if (result.hasErrors()) {
			return "index";
		}
		
		searchController.searchBiens(findBienDto);
		model.addAttribute("page", 1);		
		int nbPages = findBienDto.getListBiens().size()/6 ;
		if(findBienDto.getListBiens().size()%6 != 0){
			nbPages++;
		}
		model.addAttribute("nbpages", nbPages);
//		model.addAttribute("findBiens", findBienDto);
		session.setAttribute("findBiens", findBienDto);
		return "redirect:/biens/search-result/1.htm";
	}
	
}