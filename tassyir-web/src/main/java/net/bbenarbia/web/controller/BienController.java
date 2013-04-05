package net.bbenarbia.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.bbenarbia.domain.Departement;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.domain.immobilier.Studio;
import net.bbenarbia.service.IDepartementService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.web.dto.BienDTO;
import net.bbenarbia.web.dto.FindBienDTO;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String initSearchBiens(Model model) {
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

		EnumTypeBien typeBien = null;
		try {
			typeBien = EnumTypeBien.fromIndex(Integer.valueOf(findBienDto
					.getTypeBien()));
		} catch (NumberFormatException e) {
		}

		List<BienImmobilier> listBiensFound = bienService.searchBiens(typeBien,
				findBienDto.getRefBien(), findBienDto.getDepartementBien(),
				findBienDto.getSurfaceMin(), findBienDto.getSurfaceMax(),
				findBienDto.getNbPiecesMin(), findBienDto.getNbPiecesMax(),
				findBienDto.getLoyerMin(), findBienDto.getLoyerMax());

		findBienDto.setListBiens(listBiensFound);
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
			HttpServletResponse response, HttpSession session) {
		BienImmobilier bien = this.bienService.get(bienId);
		model.addAttribute("bien", bien);

		return "immobilier/bienDetails";
	}

	@RequestMapping(value = "/{bienId}/edit", method = RequestMethod.GET)
	public String initUpdateBienForm(@PathVariable("bienId") Long bienId,
			Model model) {
		BienImmobilier bien = this.bienService.get(bienId);
		BienDTO bienDto = null;
		if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
			bienDto = new BienDTO((Appartement) bien);
		}
		// else if(bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())){
		// bienDto = new BienDTO((Maison)bien);
		// }
		else if (bien.getTypeBien().equals(EnumTypeBien.STUDIO.toString())) {
			bienDto = new BienDTO((Studio) bien);
		}
		// else if(bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())){
		// bienDto = new BienDTO((Terrain)bien);
		// }

		model.addAttribute("bien", bienDto);
		return "immobilier/updateBienForm";
	}

	@RequestMapping(value = "/{bienId}/edit", method = RequestMethod.POST)
	public String processUpdateBienForm(@Valid BienDTO bienDto,
			BindingResult result, @PathVariable("bienId") Long bienId,
			SessionStatus status) {
		try {

			if (result.hasErrors()) {
				return "immobilier/createBienForm";
			}

			BienImmobilier bien = new BienImmobilier();

			bienService.merge(bien);
			status.setComplete();
			return "redirect:/immobilier/" + bien.getId();
		} catch (Exception e) {
			return "immobilier/updateBienForm";
		}
	}
}
