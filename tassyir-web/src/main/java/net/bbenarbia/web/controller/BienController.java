package net.bbenarbia.web.controller;

import java.util.LinkedList;
import java.util.List;

import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.BienDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("bien")
@RequestMapping("/biens")
public class BienController {

	@Autowired
	private IBienService bienService;
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@RequestMapping(value="/appartements",method = RequestMethod.GET)
	public String showAppartementList(Model model) {

		LinkedList<BienDTO> listAppartementDto = new LinkedList<BienDTO>();
		List<BienImmobilier> results = this.bienService.getAllAppartement();
		for (BienImmobilier bienImmobilier : results) {
			listAppartementDto.add(new BienDTO((Appartement) bienImmobilier));
		}
		model.addAttribute("selections", listAppartementDto);
		return "immobilier/biensList";
	}

	@RequestMapping(value="/studios",method = RequestMethod.GET)
	public String showStudiosList(Model model) {

		List<BienImmobilier> results = this.bienService.getAllStudio();
		
		model.addAttribute("selections", results);
		return "biens/biensList";
	}
	
	
	
}
