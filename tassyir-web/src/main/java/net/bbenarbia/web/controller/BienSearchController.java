package net.bbenarbia.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.subtype.Agricole;
import net.bbenarbia.domain.immobilier.subtype.Appartement;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;
import net.bbenarbia.domain.immobilier.subtype.Carcasse;
import net.bbenarbia.domain.immobilier.subtype.Commerce;
import net.bbenarbia.domain.immobilier.subtype.Maison;
import net.bbenarbia.domain.immobilier.subtype.Terrain;
import net.bbenarbia.domain.immobilier.subtype.Vacances;
import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.BienDTO;
import net.bbenarbia.web.dto.FindBienDTO;
import net.bbenarbia.web.dto.NavigationDTO;
import net.bbenarbia.web.enums.EnumTypeAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("findBiens")
@RequestMapping("/biens")
public class BienSearchController {

	@Autowired
	private IBienService bienService;

	@Autowired
	private IUtilisateurService userService;
	
	
	@RequestMapping(value = "/recherche-logement", method = RequestMethod.GET)
	public String rechercheBiensGlobal(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		Integer mainOperation = -1;
		FindBienDTO findBienDto = new FindBienDTO();
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		findBienDto.setTypeOperationBien(mainOperation);
		model.addAttribute("mainOperation", mainOperation);
		model.addAttribute("findBiens", findBienDto);
		return "immobilier/recherche-biens";

	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String rechercheBiens(Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		Integer mainOperation = -1;
		FindBienDTO findBienDto = new FindBienDTO();
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		findBienDto.setTypeOperationBien(mainOperation);
		model.addAttribute("mainOperation", mainOperation);
		model.addAttribute("findBiens", findBienDto);
		return "immobilier/recherche-biens";

	}
	
	
	@RequestMapping(value = "/recherche-logement/{typeAction}", method = RequestMethod.POST)
	public String rechercheSpecifiqueBiensInit(@ModelAttribute("findBiens") FindBienDTO findBienDto,
			@PathVariable("typeAction") Integer typeAction, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		
		searchBiens(findBienDto);
		model.addAttribute("page", 1);		
		int nbPages = findBienDto.getListBiens().size()/6 ;
		if(findBienDto.getListBiens().size()%6 != 0){
			nbPages++;
		}
		model.addAttribute("nbpages", nbPages);
		model.addAttribute("findBiens", findBienDto);
		
		return "redirect:/biens/search-result/1.htm";
	}

	@RequestMapping(value = "/search-result/{page}", method = RequestMethod.POST)
	public String rechercheSpecifiqueBiensResultForms(@ModelAttribute("findBiens") FindBienDTO findBienDto,
			@PathVariable("page") Integer page, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		
		
		searchBiens(findBienDto);
		model.addAttribute("page", page);		
		int nbPages = findBienDto.getListBiens().size()/6 ;
		if(findBienDto.getListBiens().size()%6 != 0){
			nbPages++;
		}
		model.addAttribute("nbpages", nbPages);
		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}
	@RequestMapping(value = "/search-result/{page}", method = RequestMethod.GET)
	public String rechercheSpecifiqueBiensResult(@ModelAttribute("findBiens") FindBienDTO findBienDto,
			@PathVariable("page") Integer page, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

//		searchBiens(findBienDto);
		model.addAttribute("page", page);
		
		int nbPages = findBienDto.getListBiens().size()/6 ;
		if(findBienDto.getListBiens().size()%6 != 0){
			nbPages++;
		}
		model.addAttribute("nbpages", nbPages);
//		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}

	public void searchBiens(FindBienDTO findBienDto) {
		String ref = findBienDto.getRefBien();
		findBienDto.getListBiens().clear();
		if (ref != null && !ref.isEmpty()) {
			BienImmobilier bien = bienService.getBienByRef(ref);
			if (bien != null) {				
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Maison) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Terrain) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Agricole) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.VACANCES.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Vacances) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Carcasse) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Commerce) bien));
				}
			}
		} else {
			EnumTypeOperation typeOperation = null;
			typeOperation = EnumTypeOperation.fromIndex(findBienDto
					.getTypeOperationBien());

			if (findBienDto.getDepartementBien().equals("-1")) {
				findBienDto.setDepartementBien(null);
			}

			Set<String> selectedTypes = new HashSet<String>();

			if (findBienDto.getAppartement()) {
				selectedTypes.add(EnumTypeBien.APPARTEMENT.toString());
			}
			if (findBienDto.getMaison()) {
				selectedTypes.add(EnumTypeBien.MAISON.toString());
			}
			if (findBienDto.getTerrain()) {
				selectedTypes.add(EnumTypeBien.TERRAIN.toString());
			}
			if (findBienDto.getAgricole()) {
				selectedTypes.add(EnumTypeBien.AGRICOLE.toString());
			}
			if (findBienDto.getCarcasse()) {
				selectedTypes.add(EnumTypeBien.CARCASSE.toString());
			}
			if (findBienDto.getCommercial()) {
				selectedTypes.add(EnumTypeBien.COMMERCE.toString());
			}
			if (findBienDto.getVacances()) {
				selectedTypes.add(EnumTypeBien.VACANCES.toString());
			}

			List<BienImmobilier> listBiensFound = bienService.searchBiens(
					selectedTypes, findBienDto.getDepartementBien(),
					findBienDto.getSurfaceMin(), findBienDto.getSurfaceMax(),
					findBienDto.getNbPiecesMin(), findBienDto.getNbPiecesMax(),
					findBienDto.getLoyerMin(), findBienDto.getLoyerMax(),
					findBienDto.getAscenseur(),
					findBienDto.getCuisineEquipee(), findBienDto.getJardin(),
					findBienDto.getInterphone(), findBienDto.getDigicode(),
					findBienDto.getGardien(), findBienDto.getMeuble(),
					findBienDto.getAdapteHandicape(), findBienDto.getPiscine(),
					findBienDto.getCaves(), findBienDto.getParking(),
					findBienDto.getTerrassesBalcons(), typeOperation);
			for (BienImmobilier bien : listBiensFound) {
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Maison) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Terrain) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Agricole) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.VACANCES.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Vacances) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Carcasse) bien));
				}
				else if (bien.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Commerce) bien));
				}
			}
		}
	}
	
	@RequestMapping(value = "/recherche-logement/{typeAction}", method = RequestMethod.GET)
	public String rechercheSpecifiqueBiensForm(
			@PathVariable("typeAction") Integer typeAction, Model model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {

		Integer mainOperation = null;
		FindBienDTO findBienDto = new FindBienDTO();
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		if (typeAction != null) {
			EnumTypeAction enumTypeAction = EnumTypeAction
					.fromIndex(typeAction);
			if (enumTypeAction != null) {
				mainOperation = enumTypeAction.getIndex();
			}
		}
		findBienDto.setTypeOperationBien(mainOperation);
		model.addAttribute("mainOperation", mainOperation);
		model.addAttribute("findBiens", findBienDto);
		return "immobilier/recherche-biens";
	}

}
