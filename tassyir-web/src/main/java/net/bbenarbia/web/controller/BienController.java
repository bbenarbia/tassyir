package net.bbenarbia.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.User;
import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeChauffage;
import net.bbenarbia.domain.enums.EnumTypeEauChaude;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.enums.EnumTypeVille;
import net.bbenarbia.domain.enums.ParameterCode;
import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.domain.immobilier.Maison;
import net.bbenarbia.domain.immobilier.Photo;
import net.bbenarbia.domain.immobilier.Studio;
import net.bbenarbia.service.IParameterService;
import net.bbenarbia.service.IPhotoService;
import net.bbenarbia.service.ITownService;
import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.service.impl.TownService;
import net.bbenarbia.utils.ImageService;
import net.bbenarbia.web.dto.BienDTO;
import net.bbenarbia.web.dto.FindBienDTO;
import net.bbenarbia.web.dto.NavigationDTO;
import net.bbenarbia.web.dto.UploadItem;
import net.bbenarbia.web.enums.EnumTypeAction;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("bien")
@RequestMapping("/biens")
public class BienController {

	@Autowired
	private IBienService bienService;

	@Autowired
	private IUtilisateurService userService;

	@Autowired
	private ITownService departementservice;

	@Autowired
	IParameterService parameterService;

	@Autowired
	IPhotoService photoService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/communes", method = RequestMethod.GET)
	public @ResponseBody
	Set<Town> communesForWilaya(
			@RequestParam(value = "stateName", required = true) String state) {
		// logger.debug("finding cities for state " + state);
		Set<Town> listCommunes = new HashSet<Town>();

		listCommunes.addAll(departementservice.getCommunesByState(state));
		return listCommunes;
	}

	@RequestMapping(value = "/states", method = RequestMethod.GET)
	public @ResponseBody
	List<Town> findAllStates() {
		// logger.debug("finding all states");
		List<Town> listDepartements = departementservice
				.getTownByType(EnumTypeVille.WILAYA);
		return new LinkedList<Town>(listDepartements);
	}

	
	
	@ModelAttribute("lastBiensAdded")
	public List<BienDTO> findLastBiens() throws Exception {
		
		List<BienImmobilier> lastBiens = bienService.getLastBiens(3);
		List<BienDTO> biensDto = new ArrayList<BienDTO>();
		
		for (BienImmobilier bien : lastBiens) {
			if (bien != null) {
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					biensDto.add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					biensDto.add(new BienDTO((Maison) bien));
				}
				else throw new Exception("Voir les autres types de biens non testés");
				//A voir les autres types
			}
		}
		
		return new LinkedList<BienDTO>(biensDto);
	}
	
	
	@ModelAttribute("typesLogementList")
	public List<EnumTypeBien> populateLogementTypeList() {
		List<EnumTypeBien> typesLogementList = new LinkedList<EnumTypeBien>();
		for (EnumTypeBien typeBien : EnumTypeBien.values()) {
			typesLogementList.add(typeBien);
		}
		return typesLogementList;
	}

	@ModelAttribute("typesOperationsList")
	public List<EnumTypeOperation> populateTypeOperationList() {
		List<EnumTypeOperation> typesOperationsList = new LinkedList<EnumTypeOperation>();
		for (EnumTypeOperation typeOperationBien : EnumTypeOperation.values()) {
			typesOperationsList.add(typeOperationBien);
		}
		return typesOperationsList;
	}

	@ModelAttribute("departementsList")
	public List<Town> populateDepartementList() {

		List<Town> listDepartements = departementservice.getAll();

		return new LinkedList<Town>(listDepartements);
	}

	@ModelAttribute("statusList")
	public List<String> populateStatusList() {

		List<String> statusList = new LinkedList<String>();

		for (EnumStatutProperty status : EnumStatutProperty.values()) {
			statusList.add(status.toString());
		}
		return statusList;
	}

	@ModelAttribute("typeEauChaudeList")
	public List<String> populateTypeEauChaudeList() {

		List<String> typeEauChaudeList = new LinkedList<String>();

		for (EnumTypeEauChaude typeOperation : EnumTypeEauChaude.values()) {
			typeEauChaudeList.add(typeOperation.toString());
		}
		return typeEauChaudeList;
	}

	@ModelAttribute("typeNatureChauffageList")
	public List<String> populateNatureChauffageList() {

		List<String> typeNatureChauffageList = new LinkedList<String>();

		for (EnumNatureChauffage typeOperation : EnumNatureChauffage.values()) {
			typeNatureChauffageList.add(typeOperation.toString());
		}
		return typeNatureChauffageList;
	}

	@ModelAttribute("typeTypeChauffageList")
	public List<String> populateTypeChauffageList() {

		List<String> typeTypeChauffageList = new LinkedList<String>();

		for (EnumTypeChauffage typeOperation : EnumTypeChauffage.values()) {
			typeTypeChauffageList.add(typeOperation.toString());
		}
		return typeTypeChauffageList;
	}

	@ModelAttribute("etatBienList")
	public List<String> populatEetatBienList() {

		List<String> etatBienList = new LinkedList<String>();

		for (EnumEtatBien etatBien : EnumEtatBien.values()) {
			etatBienList.add(etatBien.toString());
		}
		return etatBienList;
	}

	@ModelAttribute("typeConsoEnergieList")
	public List<String> populateConsoEnergieList() {

		List<String> typeConsoEnergieList = new LinkedList<String>();

		for (EnumConsEnergie typeOperation : EnumConsEnergie.values()) {
			typeConsoEnergieList.add(typeOperation.toString());
		}
		return typeConsoEnergieList;
	}

	@ModelAttribute("typeImpactConsoList")
	public List<String> populateTypeImpactConsoListList() {

		List<String> typeImpactConsoList = new LinkedList<String>();

		for (EnumImpactConso typeOperation : EnumImpactConso.values()) {
			typeImpactConsoList.add(typeOperation.toString());
		}
		return typeImpactConsoList;
	}

//	@RequestMapping(value = "/find-biens", method = RequestMethod.GET)
//	public String initSearchBiens(Model model) {
//		List<BienImmobilier> listBiens = bienService.getAll();
//
//		FindBienDTO findBienDto = new FindBienDTO();
//		for (BienImmobilier bienImmobilier : listBiens) {
//			findBienDto.getListBiens().add(new BienDTO(bienImmobilier));
//		}
//		findBienDto.setListBiens(listBiens);
//		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
//		navigations.add(new NavigationDTO("/", "home"));
//		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
//		model.addAttribute("navigations", navigations);
//
//		model.addAttribute("findBiens", findBienDto);
//		return "immobilier/consultation/find-biens";
//	}

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

	@RequestMapping(value = "/recherche-logement/{typeAction}", method = RequestMethod.GET)
	public String rechercheSpecifiqueBiens(
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

	@RequestMapping(value = "/recherche-logement/{typeAction}", method = RequestMethod.POST)
	public String rechercherBiens(
			@ModelAttribute("findBiens") @Valid FindBienDTO findBienDto,
			BindingResult result, SessionStatus status, Model model) throws Exception {

		String ref = findBienDto.getRefBien();
		if (ref != null && !ref.isEmpty()) {
			BienImmobilier bien = bienService.getBienByRef(ref);
//			findBienDto.setListBiens(new ArrayList<BienImmobilier>());
			if (bien != null) {
				
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Maison) bien));
				}
				else throw new Exception("Voir les autres types");
				//A voir les autres types
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
			if (findBienDto.getBungalow()) {
				selectedTypes.add(EnumTypeBien.BUNGALOW.toString());
			}
			if (findBienDto.getFerme()) {
				selectedTypes.add(EnumTypeBien.FERME.toString());
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
				}
				else throw new Exception("Voir les autres types");
				//A voir les autres types
			}
		}
		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/find-biens", method = RequestMethod.POST)
	public String searchBiens(
			@ModelAttribute("findBiens") @Valid FindBienDTO findBienDto,
			BindingResult result, SessionStatus status, Model model) throws Exception {

		String ref = findBienDto.getRefBien();
		if (ref != null && !ref.isEmpty()) {
			BienImmobilier bien = bienService.getBienByRef(ref);
			if (bien != null) {
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Maison) bien));
				}
				else throw new Exception("Voir les autres types");
				//A voir les autres types
			}
		} else {
			// EnumTypeBien typeBien = null;
			EnumTypeOperation typeOperation = null;
			// try {
			// typeBien = EnumTypeBien.fromIndex(Integer.valueOf(findBienDto
			// .getTypeBien()));
			// } catch (NumberFormatException e) {
			// }
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
			if (findBienDto.getBungalow()) {
				selectedTypes.add(EnumTypeBien.BUNGALOW.toString());
			}
			if (findBienDto.getFerme()) {
				selectedTypes.add(EnumTypeBien.FERME.toString());
			}

			typeOperation = EnumTypeOperation.fromIndex(findBienDto
					.getTypeOperationBien());

			if (findBienDto.getDepartementBien().equals("-1")) {
				findBienDto.setDepartementBien(null);
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
				}
				else throw new Exception("Voir les autres types");
				//A voir les autres types
			}
		}
		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/{userId}/user-biens", method = RequestMethod.GET)
	public String showUserBiens(@PathVariable("userId") Long userId, Model model) throws Exception {
		User user = null;
		FindBienDTO findBienDto = new FindBienDTO();
		if (userId != null) {
			user = userService.get(userId);
			if (user != null) {
				Set<BienImmobilier> listBiens = user.getBiens();
				for (BienImmobilier bien : listBiens) {
					if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
						findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
					} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
						findBienDto.getListBiens().add(new BienDTO((Maison) bien));
					}
					else throw new Exception("Voir les autres types");
					//A voir les autres types
				}
			}
		}
		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/my-biens", method = RequestMethod.GET)
	public String showMyBiens(Model model) throws Exception {
		User user = null;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		user = userService.getUtilisateurByLogin(auth.getName());
		FindBienDTO findBienDto = new FindBienDTO();
		if (user != null) {
			Set<BienImmobilier> listBiens = user.getBiens();
			for (BienImmobilier bien : listBiens) {
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Maison) bien));
				}
				else throw new Exception("Voir les autres types");
				//A voir les autres types
			}
		}
		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/find-biens-reduit", method = RequestMethod.POST)
	public String searchBiensReduit(
			@ModelAttribute("findBiens") @Valid FindBienDTO findBienDto,
			BindingResult result, SessionStatus status, Model model) {

		// Recherche reduite

		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/appartements", method = RequestMethod.GET)
	public String showAppartementList(Model model) {

		LinkedList<BienDTO> listAppartementDto = new LinkedList<BienDTO>();
		List<BienImmobilier> results = this.bienService.getAllAppartement();
		for (BienImmobilier bienImmobilier : results) {
			listAppartementDto.add(new BienDTO((Appartement) bienImmobilier));
		}
		model.addAttribute("selections", listAppartementDto);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/studios", method = RequestMethod.GET)
	public String showStudiosList(Model model) {

		List<BienImmobilier> results = this.bienService.getAllStudio();

		model.addAttribute("selections", results);
		return "immobilier/consultation/biensList";
	}

	@RequestMapping(value = "/photo/{idBien}/{idPhoto}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("idBien") Long idBien,
			@PathVariable("idPhoto") Integer idPhoto) throws IOException {
		BienImmobilier bien = this.bienService.get(idBien);
		InputStream inputStream = new FileInputStream(bien.getPhotos()
				.get(idPhoto - 1).getPhotoPath());
		byte[] fileContent = IOUtils.toByteArray(inputStream);
		return fileContent;
	}

	@RequestMapping("/{bienId}")
	public String showBienDetails(@PathVariable("bienId") long bienId,
			Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		BienImmobilier bien = this.bienService.get(bienId);
		if(bien != null){
		BienDTO bienDto = null;
		String currency = parameterService
				.getParameterName(ParameterCode.MAIN_CURRENCY.toString())
				.get(0).getValue();
		model.addAttribute("currency", currency);
		
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/recherche-logement/2.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		
		User user = bien.getProprietaire(); 
		
		if(user != null){
			model.addAttribute("user", user);
		}		
		if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
			bienDto = new BienDTO((Appartement) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
			bienDto = new BienDTO((Maison) bien);
		}
		else throw new Exception("Voir les autres types");
		//A voir les autres types
		
			model.addAttribute("bien", bienDto);
		}
		return "immobilier/consultation/bienDetails";
	}

	@RequestMapping(value = "{bienId}/photo/delete/{photoId}", method = RequestMethod.GET)
	public String deletePhoto(@PathVariable("photoId") Long photoId,
			@PathVariable("bienId") long bienId, Model model) {
		photoService.delete(photoId);
		return "redirect:/biens/" + bienId;
	}

	@RequestMapping(value = "/studio/new", method = RequestMethod.GET)
	public String initCreateStudioForm(Model model) {

		BienDTO studio = new BienDTO();
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		model.addAttribute("studio", studio);
		return "immobilier/modification/createStudioForm";
	}

	@RequestMapping(value = "/studio/new", method = RequestMethod.POST)
	public String processCreationStudioForm(
			@ModelAttribute("studio") @Valid BienDTO bienDto,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "immobilier/modification/createStudioForm";
		} else {
			User user = null;
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			user = userService.getUtilisateurByLogin(auth.getName());
			if (user != null) {

				String refDepartement = bienDto.getDepartement();
				Town departement = null;
				List<Town> listDepartement = departementservice
						.getTownByReference(refDepartement);
				if (listDepartement != null && listDepartement.size() != 0) {
					departement = listDepartement.get(0);
				}

				Studio studio = new Studio();
				studio = bienDto.updateStudio(studio);
				studio.setDepartement(departement);
				studio.setProprietaire(user);
				bienService.save(studio);

				List<MultipartFile> files = bienDto.getFiles();
				if (null != files && files.size() > 0) {
					String TEMP_DIR = parameterService
							.getParameterName(
									ParameterCode.TEMP_DIRECTORY.toString())
							.get(0).getValue();

					studio = (Studio) uploadFiles(files, studio, TEMP_DIR);

					bienService.merge(studio);
					status.setComplete();

				}

				return "redirect:/biens/" + studio.getId();
			} else {
				return "immobilier/modification/createStudioForm";
			}
		}
	}

	@RequestMapping(value = "/maison/new", method = RequestMethod.GET)
	public String initCreateMaisonForm(Model model) {

		BienDTO maison = new BienDTO();
		model.addAttribute("maison", maison);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/modification/createMaisonForm";
	}

	@RequestMapping(value = "/maison/new", method = RequestMethod.POST)
	public String processCreationMaisonForm(
			@ModelAttribute("maison") @Valid BienDTO bienDto,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "immobilier/modification/createMaisonForm";
		} else {
			String refDepartement = bienDto.getDepartement();
			Town departement = null;
			List<Town> listDepartement = departementservice
					.getTownByReference(refDepartement);
			if (listDepartement != null && listDepartement.size() != 0) {
				departement = listDepartement.get(0);
			}
			Maison maison = new Maison();
			maison = bienDto.updateMaison(maison);
			maison.setDepartement(departement);
			bienService.save(maison);

			List<MultipartFile> files = bienDto.getFiles();
			if (null != files && files.size() > 0) {
				String TEMP_DIR = parameterService
						.getParameterName(
								ParameterCode.TEMP_DIRECTORY.toString()).get(0)
						.getValue();

				maison = (Maison) uploadFiles(files, maison, TEMP_DIR);

				bienService.merge(maison);
				status.setComplete();

			}

			return "redirect:/biens/" + maison.getId();

		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initCreateBienForm(Model model) {

		FindBienDTO findBienDto = new FindBienDTO();
		model.addAttribute("findBiens", findBienDto);
		
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/modification/addNewBienSelectorForm";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createBienFormSelector(
			@ModelAttribute("findBiens") @Valid FindBienDTO findBienDto,
			BindingResult result, SessionStatus status, Model model) {

		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		
		if(findBienDto.getDepartementBien() != null && !findBienDto.getDepartementBien().isEmpty()){			
		if(findBienDto.getCommuneBien() != null && !findBienDto.getCommuneBien().isEmpty()){

		BienDTO bienDto = new BienDTO();
		
		Town town = departementservice.getTownByReference(findBienDto.getCommuneBien()).get(0);
		bienDto.setVille(town.getName());
		bienDto.setDepartement(town.getDepartement());
		bienDto.setCodePostal(town.getCodePostal());
		bienDto.setTypeBien(EnumTypeBien.fromIndex(findBienDto.getTypeBien()).toString());
		bienDto.setTypeOperation(EnumTypeOperation.fromIndex(findBienDto.getTypeOperationBien()).toString());
		model.addAttribute("bien", bienDto);
		
		return "immobilier/modification/createBienForm";
		
//		if(findBienDto.getTypeBien() == EnumTypeBien.APPARTEMENT.getIndex()){
//			return "immobilier/modification/createBienForm";
//		}else 
//		if(findBienDto.getTypeBien()==EnumTypeBien.AGRICOLE.getIndex()){
//			return "agricole/new";
//		}else
//		if(findBienDto.getTypeBien()==EnumTypeBien.BUNGALOW.getIndex()){
//			return "bungalow/new";
//		}else
//		if(findBienDto.getTypeBien()==EnumTypeBien.CARCASSE.getIndex()){
//			return "carcasse/new";	
//		}else if(findBienDto.getTypeBien()==EnumTypeBien.COMMERCE.getIndex()){
//			return "commerce/new";
//		}else if(findBienDto.getTypeBien()==EnumTypeBien.FERME.getIndex()){
//			return "ferme/new";
//		}else if(findBienDto.getTypeBien()==EnumTypeBien.IMMEUBLE.getIndex()){
//			return "immeuble/new";
//		}else if(findBienDto.getTypeBien()==EnumTypeBien.MAISON.getIndex()){
//			return "maison/new";
//		}else if(findBienDto.getTypeBien()== EnumTypeBien.TERRAIN.getIndex()){
//			return "terrain/new";
//		}
//		else return "immobilier/modification/createBienForm";
		}	
		else {
			result.rejectValue("communeBien", "commune.null");
			model.addAttribute("findBiens", findBienDto);
			return "immobilier/modification/createBienForm";
		}
		}
		else {
			result.rejectValue("departementBien", "departement.null");
			model.addAttribute("findBiens", findBienDto);
			return "immobilier/modification/createBienForm";
		}
	}

	@RequestMapping(value = "/appartement/new", method = RequestMethod.GET)
	public String initCreateAppartementForm(Model model) {

		BienDTO appartement = new BienDTO();
		model.addAttribute("appartement", appartement);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/modification/createAppartementForm";
	}

	@RequestMapping(value = "/appartement/new", method = RequestMethod.POST)
	public String processCreationAppartementForm(
			@ModelAttribute("appartement") @Valid BienDTO bienDto,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "immobilier/modification/createAppartementForm";
		} else {
			String refDepartement = bienDto.getDepartement();
			Town departement = null;
			List<Town> listDepartement = departementservice
					.getTownByReference(refDepartement);
			if (listDepartement != null && listDepartement.size() != 0) {
				departement = listDepartement.get(0);
			}

			Appartement appartement = new Appartement();
			appartement = bienDto.updateAppartement(appartement);
			appartement.setDepartement(departement);
			bienService.save(appartement);

			List<MultipartFile> files = bienDto.getFiles();
			if (null != files && files.size() > 0) {
				String TEMP_DIR = parameterService
						.getParameterName(
								ParameterCode.TEMP_DIRECTORY.toString()).get(0)
						.getValue();

				appartement = (Appartement) uploadFiles(files, appartement,
						TEMP_DIR);

				bienService.merge(appartement);
				status.setComplete();
			}

			return "s/" + appartement.getId();
		}
	}

	@RequestMapping(value = "/{bienId}/edit", method = RequestMethod.GET)
	public String initUpdateBienForm(@PathVariable("bienId") Long bienId,
			Model model) {
		BienImmobilier bien = this.bienService.get(bienId);
		BienDTO bienDto = null;
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		navigations.add(new NavigationDTO("/biens/" + bienId + ".htm",
				"biens.action.details"));
		model.addAttribute("navigations", navigations);

		if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
			bienDto = new BienDTO((Appartement) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/updateAppartementForm";
		}/*
		 * else if (bien.getTypeBien().equals(EnumTypeBien.STUDIO.toString())) {
		 * bienDto = new BienDTO((Studio) bien); model.addAttribute("bien",
		 * bienDto); return "immobilier/modification/updateStudioForm"; }
		 */else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
			bienDto = new BienDTO((Maison) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/updateMaisonForm";
		} else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/updateTerrainForm";
		} else
			return "immobilier/modification/updateTerrainForm";
	}

	@RequestMapping(value = "/{bienId}/edit", method = RequestMethod.POST)
	public String processUpdateBienForm(@Valid BienDTO bienDto,
			BindingResult result, @PathVariable("bienId") Long bienId,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "immobilier/modification/updateTerrainForm";
		}

		BienImmobilier bien = bienService.get(bienId);

		if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
			bien = bienDto.updateAppartement((Appartement) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
			bien = bienDto.updateMaison((Maison) bien);
		}/*
		 * else if (bien.getTypeBien() .equals(EnumTypeBien.STUDIO.toString()))
		 * { bien = bienDto.updateStudio((Studio) bien); }
		 */
		List<Town> listDepartFound = departementservice
				.getTownByReference(bienDto.getDepartement());
		if (listDepartFound != null && listDepartFound.size() != 0) {
			bien.setDepartement(listDepartFound.get(0));
		} else {
			return "immobilier/modification/updateTerrainForm";
		}

		bienService.merge(bien);
		status.setComplete();
		return "redirect:/biens/" + bienId;
	}

	@RequestMapping(value = "/upload/{bienId}/show", method = RequestMethod.GET)
	public String getUploadForm(@PathVariable("bienId") Long bienId, Model model) {
		BienImmobilier bien = this.bienService.get(bienId);
		model.addAttribute(new UploadItem());
		model.addAttribute("bienId", bienId);
		model.addAttribute("nbFiles", 5 - bien.getPhotos().size());
		return "upload/uploadForm";
	}

	@RequestMapping(value = "/upload/{bienId}/save", method = RequestMethod.POST)
	public String uploadAndSavePhotos(
			@ModelAttribute("uploadForm") UploadItem uploadForm,
			@PathVariable("bienId") long bienId, Model map) {

		BienImmobilier bien = this.bienService.get(bienId);
		List<MultipartFile> files = uploadForm.getFiles();

		if (null != files && files.size() > 0) {
			String TEMP_DIR = parameterService
					.getParameterName(ParameterCode.TEMP_DIRECTORY.toString())
					.get(0).getValue();
			bien = uploadFiles(files, bien, TEMP_DIR);
			bienService.merge(bien);
		}
		return "redirect:/biens/" + bienId;
	}

	public BienImmobilier uploadFiles(List<MultipartFile> files,
			BienImmobilier bien, String tempDir) {

		for (MultipartFile multipartFile : files) {
			if (multipartFile.getSize() != 0) {
				File destFile = new File(new File(tempDir),
						multipartFile.getOriginalFilename());
				try {
					multipartFile.transferTo(destFile);
					BufferedImage bimg = ImageIO.read(destFile);
					BufferedImage bimgResized = ImageService.createResizedCopy(
							bimg, 300, 300, true);
					File destFile1 = new File(new File(tempDir), "small_"
							+ multipartFile.getOriginalFilename());
					ImageIO.write(bimgResized, "jpeg", destFile1);
				} catch (IllegalStateException e) {
					continue;
				} catch (IOException e) {
					continue;
				}
				Photo photo = new Photo();
				photo.setName(multipartFile.getOriginalFilename());
				photo.setPhotoPath(tempDir
						+ multipartFile.getOriginalFilename());
				photo.setBien(bien);
				bien.getPhotos().add(photo);
			}
		}
		return bien;
	}
	
	@RequestMapping(value = "/recherche-logement-by-dep/{idTown}", method = RequestMethod.GET)
	public String rechercherBienByTown(
			@PathVariable("idTown") Long idTown,
			 Model model) throws Exception {

			FindBienDTO findBienDto = new FindBienDTO();

			List<BienImmobilier> listBiensFound = bienService.searchBiensByTown(idTown);
			
			for (BienImmobilier bien : listBiensFound) {
				if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Appartement) bien));
				} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
					findBienDto.getListBiens().add(new BienDTO((Maison) bien));
				}
				else throw new Exception("Voir les autres types");
				//A voir les autres types
			}
		
		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/biens/find-biens.htm",
				"biens.listbien"));
		model.addAttribute("navigations", navigations);
		return "immobilier/consultation/biensList";
	}
}
