package net.bbenarbia.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.bbenarbia.web.dto.UploadItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	// @Autowired
	// private ParameterService parameterService;

	@RequestMapping(value = "/upload/show", method = RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute(new UploadItem());
		return "upload/uploadForm";
	}

	@RequestMapping(value = "/upload/save", method = RequestMethod.POST)
	public String saveFiles(
			@ModelAttribute("uploadForm") UploadItem uploadForm,
			BindingResult result, Model map) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "upload/uploadForm";
		}

		List<MultipartFile> files = uploadForm.getFiles();

		List<String> fileNames = new ArrayList<String>();

		if (null != files && files.size() > 0) {
			String tempDir = "/home/moad/tempfile/";// "parameterManager.getParameter(ParameterCode.TEMP_DIRECTORY)";
			for (MultipartFile multipartFile : files) {

				if (multipartFile.getSize() != 0) {
					try {
						multipartFile.transferTo(new File(new File(tempDir),
								multipartFile.getOriginalFilename()));
					} catch (IOException e) {
						return "upload/uploadForm";
					}
					String fileName = multipartFile.getOriginalFilename();
					fileNames.add(fileName);
				}

			}
		}

		return "file_upload_success";
	}
}
