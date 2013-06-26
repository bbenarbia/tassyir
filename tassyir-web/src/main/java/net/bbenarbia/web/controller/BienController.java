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
import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeChauffage;
import net.bbenarbia.domain.enums.EnumTypeEauChaude;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.enums.EnumTypeUniteMesure;
import net.bbenarbia.domain.enums.EnumTypeVille;
import net.bbenarbia.domain.enums.ParameterCode;
import net.bbenarbia.domain.immobilier.Photo;
import net.bbenarbia.domain.immobilier.subtype.Agricole;
import net.bbenarbia.domain.immobilier.subtype.Appartement;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;
import net.bbenarbia.domain.immobilier.subtype.Carcasse;
import net.bbenarbia.domain.immobilier.subtype.Commerce;
import net.bbenarbia.domain.immobilier.subtype.Maison;
import net.bbenarbia.domain.immobilier.subtype.Terrain;
import net.bbenarbia.domain.immobilier.subtype.Vacances;
import net.bbenarbia.service.IParameterService;
import net.bbenarbia.service.IPhotoService;
import net.bbenarbia.service.ITownService;
import net.bbenarbia.service.IUniteMesureService;
import net.bbenarbia.service.IUtilisateurService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.utils.ImageService;
import net.bbenarbia.web.dto.BienDTO;
import net.bbenarbia.web.dto.FindBienDTO;
import net.bbenarbia.web.dto.MessageDTO;
import net.bbenarbia.web.dto.NavigationDTO;
import net.bbenarbia.web.dto.UploadItem;

import org.apache.commons.io.IOUtils;
import org.joda.time.LocalDateTime;
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
	
	@Autowired
	private IUniteMesureService uniteMesureService;
	

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
	
	@ModelAttribute("typesLogementList")
	public List<EnumTypeBien> populateLogementTypeList() {
		List<EnumTypeBien> typesLogementList = new LinkedList<EnumTypeBien>();
		for (EnumTypeBien typeBien : EnumTypeBien.values()) {
			typesLogementList.add(typeBien);
		}
		return typesLogementList;
	}
	
	@ModelAttribute("uniteMesureSuperficie")
	public Set<UniteMesure> populateUniteMesureSuperficieList() {
		return  uniteMesureService.getUniteByType(EnumTypeUniteMesure.SUPERFICIE);
	}
	
	@ModelAttribute("uniteMesurePrix")
	public Set<UniteMesure> populateUniteMesurePrixList() {
		return  uniteMesureService.getUniteByType(EnumTypeUniteMesure.PRICE);
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
					}else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
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
		
		model.addAttribute("page", 1);
		
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

	@RequestMapping(value = "/find-biens-reduit", method = RequestMethod.POST)
	public String searchBiensReduit(
			@ModelAttribute("findBiens") @Valid FindBienDTO findBienDto,
			BindingResult result, SessionStatus status, Model model) {

		// Recherche reduite

		model.addAttribute("findBiens", findBienDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		model.addAttribute("page", 1);
		
		int nbPages = findBienDto.getListBiens().size()/6 ;
		if(findBienDto.getListBiens().size()%6 != 0){
				nbPages++;
		}
		model.addAttribute("nbpages", nbPages);
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

	

	@RequestMapping(value = "/photo/{idBien}/{idPhoto}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("idBien") Long idBien,
			@PathVariable("idPhoto") Integer idPhoto) throws IOException {
		BienImmobilier bien = this.bienService.get(idBien);
		Photo photoToShow = null;
		for (Photo photo : bien.getPhotos()) {
			if(photo.getId().equals(idPhoto)){
				photoToShow = photo;
			}
		}
		if(photoToShow != null){
		InputStream inputStream = new FileInputStream(photoToShow.getPhotoPath());
		byte[] fileContent = IOUtils.toByteArray(inputStream);
		return fileContent;
		}
		else return null;
	}

	@RequestMapping("/{bienId}")
	public String showBienDetails(@PathVariable("bienId") long bienId,
			Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		BienImmobilier bien = this.bienService.get(bienId);
		if(bien != null){
		BienDTO bienDto = null;
		
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
		} else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
			bienDto = new BienDTO((Terrain) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())) {
			bienDto = new BienDTO((Agricole) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())) {
			bienDto = new BienDTO((Carcasse) bien);
		}else if (bien.getTypeBien().equals(EnumTypeBien.VACANCES.toString())) {
			bienDto = new BienDTO((Vacances) bien);
		}else if (bien.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())) {
			bienDto = new BienDTO((Commerce) bien);
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
			
		
		if(findBienDto.getTypeBien()==EnumTypeBien.APPARTEMENT.getIndex()){
			return "redirect:/biens/Appartement/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";		
		}else 
		if(findBienDto.getTypeBien()==EnumTypeBien.MAISON.getIndex()){
			return "redirect:/biens/Maison/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";
		}else
		if(findBienDto.getTypeBien()==EnumTypeBien.VACANCES.getIndex()){
			return "redirect:/biens/Vacances/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";
		}else
		if(findBienDto.getTypeBien()==EnumTypeBien.CARCASSE.getIndex()){
			return "redirect:/biens/Carcasse/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";
		}else if(findBienDto.getTypeBien()==EnumTypeBien.COMMERCE.getIndex()){
			return "redirect:/biens/Commerce/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";
		}else if(findBienDto.getTypeBien()==EnumTypeBien.TERRAIN.getIndex()){
			return "redirect:/biens/Terrain/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";
		}
		else if(findBienDto.getTypeBien()==EnumTypeBien.AGRICOLE.getIndex()){
			return "redirect:/biens/Agricole/"+findBienDto.getTypeOperationBien()+"/"+findBienDto.getCommuneBien()+"/new";
		}

		return "immobilier/modification/createBienForm";
		
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

	
	@RequestMapping(value = "/{typeBien}/{typeOperation}/{commune}/new", method = RequestMethod.GET)
	public String initCreateAppartementForm(@PathVariable("typeBien") String typeBien, @PathVariable("typeOperation") int typeOperation,@PathVariable("commune") String commune,
			Model model) {

		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/find-biens.htm", "biens.listbien"));
		model.addAttribute("navigations", navigations);
		
		BienDTO bienDto = new BienDTO();
		
		Town town = departementservice.getTownByReference(commune).get(0);
		bienDto.setVille(town.getName());
		bienDto.setDepartement(town.getDepartement());
		bienDto.setCodePostal(town.getReference());
		bienDto.setTypeBien(typeBien.toUpperCase());
		bienDto.setTypeOperation(EnumTypeOperation.fromIndex(typeOperation).toString());
		model.addAttribute("bien", bienDto);
		
		return "immobilier/modification/creation/create"+typeBien+"Form";
	}

	@RequestMapping(value = "/{typeBien}/{typeOperation}/{commune}/new", method = RequestMethod.POST)
	public String processCreationAppartementForm(
			@ModelAttribute("bien") @Valid BienDTO bienDto,
			BindingResult result, SessionStatus status, Model model) {

		if (result.hasErrors()) {
			return "immobilier/modification/creation/createAppartementForm";
		} else {
			String refVille = bienDto.getCodePostal();
			Town ville = null;
			List<Town> listVilles = departementservice
					.getTownByReference(refVille);
			if (listVilles != null && listVilles.size() != 0) {
				ville = listVilles.get(0);
			}
			
			String newRef = bienService.getNewReferenceBien();
			bienDto.setReference(newRef);
			BienImmobilier bienToCreate = null;
			if(bienDto.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())){
				bienToCreate = new Appartement();
				bienToCreate = bienDto.updateAppartement((Appartement)bienToCreate);
			}else if(bienDto.getTypeBien().equals(EnumTypeBien.MAISON.toString())){
				bienToCreate = new Maison();
				bienToCreate = bienDto.updateMaison((Maison)bienToCreate);
			}else if(bienDto.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())){
				bienToCreate = new Terrain();
				bienToCreate = bienDto.updateTerrain((Terrain)bienToCreate);
			}else if(bienDto.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())){
				bienToCreate = new Agricole();
				bienToCreate = bienDto.updateAgricole((Agricole)bienToCreate);
			}else if(bienDto.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())){
				bienToCreate = new Commerce();
				bienToCreate = bienDto.updateCommerce((Commerce)bienToCreate);
			}else if(bienDto.getTypeBien().equals(EnumTypeBien.VACANCES.toString())){
				bienToCreate = new Vacances();
				bienToCreate = bienDto.updateVacances((Vacances)bienToCreate);
			}else if(bienDto.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())){
				bienToCreate = new Carcasse();
				bienToCreate = bienDto.updateCarcasse((Carcasse)bienToCreate);
			}
			UniteMesure unitePrix = uniteMesureService.get(Long.valueOf(bienDto.getUnitePrix()));
			UniteMesure uniteSuperfice = uniteMesureService.get(Long.valueOf(bienDto.getUniteSuperficie()));
			bienToCreate.setUnitePrix(unitePrix);
			bienToCreate.setUniteSuperficie(uniteSuperfice);
			User user = null;
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			user = userService.getUtilisateurByLogin(auth.getName());
			bienToCreate.setProprietaire(user);
			
			bienToCreate.setDepartement(ville);
			bienService.save(bienToCreate);

			List<MultipartFile> files = bienDto.getFiles();
			if (null != files && files.size() > 0) {
				String TEMP_DIR = parameterService
						.getParameterName(
								ParameterCode.TEMP_DIRECTORY.toString()).get(0)
						.getValue();

				bienToCreate = uploadFiles(files, bienToCreate,
						TEMP_DIR);

				bienService.merge(bienToCreate);
				status.setComplete();
			}
			
			MessageDTO message = new MessageDTO();
			message.setText("Votre annonce est bien crée <br/> "
							+"Elle sera en ligne après validation dans moins de 24h"+
							"Clicker ici pour voir le bien" +
							"<a href='http://localhost:8080/tassyir-mvc/biens/"+bienToCreate.getId()+".htm'>Click here to show details ");
			model.addAttribute("message", message);

			return "/information";
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
			return "immobilier/modification/update/updateAppartementForm";
		}else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
			bienDto = new BienDTO((Maison) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/update/updateMaisonForm";
		} else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/update/updateTerrainForm";
		} else if (bien.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())) {
			bienDto = new BienDTO((Commerce) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/update/updateCommerceForm";
		}else if (bien.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())) {
			bienDto = new BienDTO((Carcasse) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/update/updateCarcasseForm";
		}else if (bien.getTypeBien().equals(EnumTypeBien.VACANCES.toString())) {
			bienDto = new BienDTO((Vacances) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/update/updateVacancesForm";
		}else if (bien.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())) {
			bienDto = new BienDTO((Agricole) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/modification/update/updateAgricoleForm";
		}
		else
			return "immobilier/modification/update/updateTerrainForm";
	}
	
	

	@RequestMapping(value = "/{bienId}/edit", method = RequestMethod.POST)
	public String processUpdateBienForm(@Valid BienDTO bienDto,
			BindingResult result, @PathVariable("bienId") Long bienId,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "immobilier/modification/update/updateTerrainForm";
		}

		BienImmobilier bien = bienService.get(bienId);

		if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
			bien = bienDto.updateAppartement((Appartement) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())) {
			bien = bienDto.updateMaison((Maison) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
			bien = bienDto.updateTerrain((Terrain) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.AGRICOLE.toString())) {
			bien = bienDto.updateAgricole((Agricole) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.VACANCES.toString())) {
			bien = bienDto.updateVacances((Vacances) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.CARCASSE.toString())) {
			bien = bienDto.updateCarcasse((Carcasse) bien);
		} else if (bien.getTypeBien().equals(EnumTypeBien.COMMERCE.toString())) {
			bien = bienDto.updateCommerce((Commerce) bien);
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
				}else if (bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())) {
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
				else throw new Exception("Voir les autres types");
				//A voir les autres types
			}
		
			
		model.addAttribute("page", 1);
			
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
	

	@RequestMapping(value = "/add-favorite/{bienId}", method = RequestMethod.GET)
	public String AddBienToFavorites(@PathVariable("bienId") Long bienId, Model model,
			SessionStatus status, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		User user = null;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		user = userService.getUtilisateurByLogin(auth.getName());
		if (user != null) {
			
			BienImmobilier bien = bienService.get(bienId);
			if(bien != null && !user.getFavorites().contains(bien)){
				user.getFavorites().add(bien);
				userService.merge(user);
				status.setComplete();
			}
		}
		return "redirect:/biens/" + bienId;
	}

	
	
	@RequestMapping(value = "/{bienId}/delete", method = RequestMethod.GET)
	public String deleteBienForm(@PathVariable("bienId") Long bienId,
			SessionStatus status , Model model) {
		BienImmobilier bien = this.bienService.get(bienId);
		User user = null;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		user = userService.getUtilisateurByLogin(auth.getName());
		if (user != null) {
			if(user.equals(bien.getProprietaire())){
				bien.setToDelete(true);
				bien.setWhyDelete("La raison de suppression");
				bien.setDateMiseAjour(new LocalDateTime());
				bienService.merge(bien);
				status.setComplete();
			
			MessageDTO message = new MessageDTO();
			message.setText("Votre demande de suppression d'annonce vient d'etre enregistrer <br/> "
							+"Elle ne sera plus en ligne, puis elle sera supprimée definitivement dans 7 jours <br/>"+
							"Vous pouvez la remettre en ligne pendant cette période la, sinon, elle sera supprimée" 
							);
			model.addAttribute("message", message);
			return "/information";
			}
			else {
				MessageDTO message = new MessageDTO();
				message.setText("Vous n'avez pas le droit de supprimer cette annonce");
				model.addAttribute("message", message);

				return "/information";
			}
		}
			else {
				MessageDTO message = new MessageDTO();
				message.setText("User not found ");
				model.addAttribute("message", message);

				return "/information";
			}	
			
		}
}
