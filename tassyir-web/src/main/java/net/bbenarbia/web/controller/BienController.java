package net.bbenarbia.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.bbenarbia.domain.Departement;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeBien;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.enums.ParameterCode;
import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.BienImmobilier;
import net.bbenarbia.domain.immobilier.Photo;
import net.bbenarbia.domain.immobilier.Studio;
import net.bbenarbia.service.IDepartementService;
import net.bbenarbia.service.IParameterService;
import net.bbenarbia.service.IPhotoService;
import net.bbenarbia.service.immobilier.IBienService;
import net.bbenarbia.utils.ImageService;
import net.bbenarbia.web.dto.BienDTO;
import net.bbenarbia.web.dto.FindBienDTO;
import net.bbenarbia.web.dto.UploadItem;

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
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("bien")
@RequestMapping("/biens")
public class BienController {

	@Autowired
	private IBienService bienService;

	@Autowired
	private IDepartementService departementservice;

	@Autowired
	IParameterService parameterService;

	@Autowired
	IPhotoService photoService;

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

	@ModelAttribute("statusList")
	public List<String> populateStatusList() {

		List<String> statusList = new LinkedList<String>();

		for (EnumStatutProperty status : EnumStatutProperty.values()) {
			statusList.add(status.toString());
		}
		return statusList;
	}
	@ModelAttribute("typeOperationList")
	public List<String> populateTypeOperationList() {

		List<String> statusList = new LinkedList<String>();

		for (EnumTypeOperation typeOperation : EnumTypeOperation.values()) {
			statusList.add(typeOperation.toString());
		}
		return statusList;
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

	@RequestMapping(value = "{bienId}/photo/delete/{photoId}", method = RequestMethod.GET)
	public String deletePhoto(@PathVariable("photoId") Long photoId,
			@PathVariable("bienId") long bienId, Model model) {
		photoService.delete(photoId);
		return "redirect:/biens/" + bienId;
	}

	@RequestMapping(value = "/{bienId}/edit", method = RequestMethod.GET)
	public String initUpdateBienForm(@PathVariable("bienId") Long bienId,
			Model model) {
		BienImmobilier bien = this.bienService.get(bienId);
		BienDTO bienDto = null;
		if (bien.getTypeBien().equals(EnumTypeBien.APPARTEMENT.toString())) {
			bienDto = new BienDTO((Appartement) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/updateAppartementForm";
		}
		// else if(bien.getTypeBien().equals(EnumTypeBien.MAISON.toString())){
		// bienDto = new BienDTO((Maison)bien);
		// }
		else if (bien.getTypeBien().equals(EnumTypeBien.STUDIO.toString())) {
			bienDto = new BienDTO((Studio) bien);
			model.addAttribute("bien", bienDto);
			return "immobilier/updateStudioForm";
		}
		 else if(bien.getTypeBien().equals(EnumTypeBien.TERRAIN.toString())){
//		 bienDto = new BienDTO((Terrain)bien);
			 model.addAttribute("bien", bienDto);
			 return "immobilier/updateTerrainForm";
		 }

		else return "immobilier/updateBienForm";
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

			for (MultipartFile multipartFile : files) {
				if (multipartFile.getSize() != 0) {
					try {
						File destFile = new File(new File(TEMP_DIR),
								multipartFile.getOriginalFilename());
						multipartFile.transferTo(destFile);
						BufferedImage bimg = ImageIO.read(destFile);
						BufferedImage bimgResized =  ImageService.createResizedCopy(bimg, 300, 300, true);
						File destFile1 = new File(new File(TEMP_DIR),
								"small_"+ multipartFile.getOriginalFilename());
						ImageIO.write(bimgResized, "jpeg", destFile1) ;
						
					} catch (IOException e) {
						return "upload/uploadForm";
					}
					
					
					
					Photo photo = new Photo();
					photo.setName(multipartFile.getOriginalFilename());
					photo.setPhotoPath(TEMP_DIR
							+ multipartFile.getOriginalFilename());
					photo.setBien(bien);
					bien.getPhotos().add(photo);
				}
			}
			bienService.merge(bien);
		}
		return "redirect:/biens/" + bienId;
	}
}
