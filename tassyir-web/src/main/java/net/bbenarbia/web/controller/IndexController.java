package net.bbenarbia.web.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.enums.EnumTypeUniteMesure;
import net.bbenarbia.domain.immobilier.subtype.Agricole;
import net.bbenarbia.domain.immobilier.subtype.Appartement;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;
import net.bbenarbia.domain.immobilier.subtype.Carcasse;
import net.bbenarbia.domain.immobilier.subtype.Commerce;
import net.bbenarbia.domain.immobilier.subtype.Maison;
import net.bbenarbia.domain.immobilier.subtype.Terrain;
import net.bbenarbia.domain.immobilier.subtype.Vacances;
import net.bbenarbia.service.ITownService;
import net.bbenarbia.service.IUniteMesureService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.BienDTO;
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
	
	@Autowired
	private IUniteMesureService uniteMesureService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String indexPage(ModelMap model) {

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
	
	@ModelAttribute("lastBiensAdded")
	public List<BienDTO> findLastBiens() {
		
		List<BienImmobilier> lastBiens = bienService.getLastBiens(3);
		List<BienDTO> biensDto = new ArrayList<BienDTO>();
		
		for (BienImmobilier bien : lastBiens) {
			if (bien != null) {
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					biensDto.add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					biensDto.add(new BienDTO((Maison) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
					biensDto.add(new BienDTO((Terrain) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())) {
					biensDto.add(new BienDTO((Agricole) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.VACANCES.toString())) {
					biensDto.add(new BienDTO((Vacances) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())) {
					biensDto.add(new BienDTO((Carcasse) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())) {
					biensDto.add(new BienDTO((Commerce) bien));
				}
			}
		}
		
		return new LinkedList<BienDTO>(biensDto);
	}
	
	@ModelAttribute("uniteMesureSuperficie")
	public Set<UniteMesure> populateUniteMesureSuperficieList() {
		return  uniteMesureService.getUniteByType(EnumTypeUniteMesure.SUPERFICIE);
	}
	
	@ModelAttribute("uniteMesurePrix")
	public Set<UniteMesure> populateUniteMesurePrixList() {
		return  uniteMesureService.getUniteByType(EnumTypeUniteMesure.PRICE);
	}
	
	
	@RequestMapping(value = "/searchrapide", method = RequestMethod.POST)
	public String rechercheRapide(@ModelAttribute("findBiens") FindBienDTO findBienDto,BindingResult result,
			 Model model, SessionStatus status,
				HttpSession session) {
		
		return "/";
	}
		
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String rechercheSpecifiqueBiensInit(@ModelAttribute("findBiens") FindBienDTO findBienDto,BindingResult result,
			 Model model, SessionStatus status,
				HttpSession session) {
		
		validator.validate(findBienDto, result);
		if (result.hasErrors()) {
			return "index";
		}
		UniteMesure unitePrix = uniteMesureService.get(Long.valueOf(findBienDto.getUnitePrix()));
		UniteMesure uniteSuperfice = uniteMesureService.get(Long.valueOf(findBienDto.getUniteSuperficie()));
		
		if(findBienDto.getSurfaceMax() != null){
			findBienDto.setSurfaceMax(findBienDto.getSurfaceMax()*uniteSuperfice.getValue());
		}
		if(findBienDto.getSurfaceMin() != null){
			findBienDto.setSurfaceMin(findBienDto.getSurfaceMin()*uniteSuperfice.getValue());
		}
		if(findBienDto.getLoyerMax() != null){
			findBienDto.setLoyerMax(findBienDto.getLoyerMax()*unitePrix.getValue());
		}
		if(findBienDto.getLoyerMin() != null){
			findBienDto.setLoyerMin(findBienDto.getLoyerMin()*unitePrix.getValue());
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