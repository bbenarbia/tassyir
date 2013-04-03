package net.bbenarbia.web.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import net.bbenarbia.domain.Departement;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.service.IDepartementService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.BienDTO;
import net.bbenarbia.web.dto.FindBienDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("bien")
@RequestMapping("/biens")
public class BienController {

	@Autowired
	private IBienService bienService;

	@Autowired
	private IDepartementService departementservice;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("typesLogementList")
	public List<EnumTypeBien> populateLogementTypeList() {
		List<EnumTypeBien> typesLogementList = new LinkedList<EnumTypeBien>();
		for (EnumTypeBien typeBien : EnumTypeBien.values()) {
			typesLogementList.add(typeBien);
		}
		return typesLogementList;
	}

	@ModelAttribute("departementsList")
	public List<Departement> populateDepartementList() {

		List<Departement> listDepartements = departementservice.getAll();

		return new LinkedList<Departement>(listDepartements);
	}

	@RequestMapping(value = "/find-biens", method = RequestMethod.GET)
	public String initSearchBiens( Model model) {
		List<BienImmobilier> listBiens = bienService.getAll();
		
		FindBienDTO findBienDto = new FindBienDTO();
		findBienDto.setListBiens(listBiens);

		model.addAttribute("findBiens", findBienDto);
		return "immobilier/biensList";
	}
	
	
	@RequestMapping(value = "/find-biens", method = RequestMethod.POST)
	public String searchBiens(
			@ModelAttribute("findBiens") @Valid FindBienDTO findBienDto,
			BindingResult result, SessionStatus status, Model model) {


		EnumTypeBien typeBien = EnumTypeBien.fromIndex(Integer.valueOf(findBienDto.getTypeBien()));
		findBienDto.setListBiens(bienService.searchBiens(
				typeBien,
				findBienDto.getRefBien(), findBienDto.getDepartementBien(),
				findBienDto.getSurfaceMin(), findBienDto.getSurfaceMax(), null,
				null, findBienDto.getLoyerMin(), findBienDto.getLoyerMax()));

		model.addAttribute("findBiens", findBienDto);
		return "immobilier/biensList";
	}

	@RequestMapping(value = "/appartements", method = RequestMethod.GET)
	public String showAppartementList(Model model) {

		LinkedList<BienDTO> listAppartementDto = new LinkedList<BienDTO>();
		List<BienImmobilier> results = this.bienService.getAllAppartement();
		for (BienImmobilier bienImmobilier : results) {
			listAppartementDto.add(new BienDTO((Appartement) bienImmobilier));
		}
		model.addAttribute("selections", listAppartementDto);
		return "immobilier/biensList";
	}

	@RequestMapping(value = "/studios", method = RequestMethod.GET)
	public String showStudiosList(Model model) {

		List<BienImmobilier> results = this.bienService.getAllStudio();

		model.addAttribute("selections", results);
		return "immobilier/biensList";
	}

}
