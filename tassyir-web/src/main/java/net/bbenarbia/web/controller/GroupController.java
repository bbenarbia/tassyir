package net.bbenarbia.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.domain.enums.ParameterCode;
import net.bbenarbia.service.IParameterService;
import net.bbenarbia.service.IRoleService;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.utils.ImageService;
import net.bbenarbia.web.dto.GroupDTO;
import net.bbenarbia.web.dto.NavigationDTO;
import net.bbenarbia.web.dto.RoleFormDTO;
import net.bbenarbia.web.dto.RoleFormDTOList;
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
@SessionAttributes("group")
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private IUserCategoryService userCategoryService;;

	@Autowired
	private IRoleService roleService;

	@Autowired
	IParameterService parameterService;
	
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showGroupList(Model model) {

		Collection<UserCategory> results = this.userCategoryService.getAll();
		model.addAttribute("selections", results);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		model.addAttribute("navigations", navigations);
		return "groups/groupList";
	}

	@RequestMapping(value = "/photo/{idGroup}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("idGroup") Long idGroup)
			throws IOException {
		UserCategory group = this.userCategoryService.get(idGroup);
		InputStream inputStream = new FileInputStream(group.getPhoto());
		byte[] fileContent = IOUtils.toByteArray(inputStream);
		return fileContent;
	}
	
	@RequestMapping(value = "/{groupId}/roles", method = RequestMethod.GET)
	public String rolesGroupForm(@PathVariable("groupId") Long groupId,
			Model model) {

		RoleFormDTOList listFormDto = new RoleFormDTOList();

		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
		UserCategory group = this.userCategoryService.get(groupId);
		List<Role> allRolesList = roleService.getAll();

		for (Role role : allRolesList) {
			if (group.getRoles() != null && group.getRoles().contains(role)) {
				roleFormList.add(new RoleFormDTO(role, true));
			} else {
				roleFormList.add(new RoleFormDTO(role, false));
			}
		}
		listFormDto.setRoles(roleFormList);
		model.addAttribute("groupId", groupId);
		model.addAttribute("roleFormList", listFormDto);
		return "groups/rolesList";
	}
	
	@RequestMapping("/{groupId}")
	public String showGroupDetails(@PathVariable("groupId") long groupId, Model model) {
		UserCategory group = this.userCategoryService.get(groupId);
		model.addAttribute("group",group);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/groups.htm", "group.gotolistgroup"));
		model.addAttribute("navigations", navigations);
		return "groups/groupDetails";
	}
	

	@RequestMapping(value = "/{groupId}/roles/save", method = RequestMethod.POST)
	public String saveRoles(
			@ModelAttribute("roleFormList") RoleFormDTOList roleFormList,
			@PathVariable("groupId") Long groupId) {

		UserCategory group = this.userCategoryService.get(groupId);
		Set<Role> rolesList = new HashSet<Role>();
		if (null != roleFormList.getRoles()
				&& roleFormList.getRoles().size() > 0) {
			for (RoleFormDTO roleDto : roleFormList.getRoles()) {
				if (roleDto.isIncluded()) {
					Role role = roleService.getRolesByName(
							roleDto.getRole().getName()).get(0);
					rolesList.add(role);
				}
			}
		}
		group.setRoles(rolesList);
		userCategoryService.merge(group);

		return "redirect:/groups";
	}

	@RequestMapping(value = "/{groupId}/edit", method = RequestMethod.GET)
	public String initUpdateGroupForm(@PathVariable("groupId") Long groupId,
			Model model) {
		UserCategory group = this.userCategoryService.get(groupId);
		GroupDTO groupDto = new GroupDTO();
		
		
		RoleFormDTOList listFormDto = new RoleFormDTOList();

		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
		List<Role> allRolesList = roleService.getAll();

		for (Role role : allRolesList) {
			if (group.getRoles() != null && group.getRoles().contains(role)) {
				roleFormList.add(new RoleFormDTO(role, true));
			} else {
				roleFormList.add(new RoleFormDTO(role, false));
			}
		}
		listFormDto.setRoles(roleFormList);
		groupDto.setRoleFormList(listFormDto);
		groupDto.setName(group.getName());
		groupDto.setId(String.valueOf(group.getId()));
		model.addAttribute("group", groupDto);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/groups.htm", "group.gotolistgroup"));
		navigations.add(new NavigationDTO("/groups/"+groupId+".htm", "group.action.details"));
		model.addAttribute("navigations", navigations);
		
		return "groups/updateGroupForm";
	}

	@RequestMapping(value = "/{groupId}/edit", method = RequestMethod.POST)
	public String processUpdateGroupForm(@Valid GroupDTO groupDto,
			BindingResult result, @PathVariable("groupId") Long groupId,
			SessionStatus status) {
		try {

			if (result.hasErrors()) {
				return "groups/updateGroupForm";
			}
			
			Set<Role> rolesList = new HashSet<Role>();
			if (null != groupDto.getRoleFormList().getRoles()
					&& groupDto.getRoleFormList().getRoles().size() > 0) {
				for (RoleFormDTO roleDto : groupDto.getRoleFormList().getRoles()) {
					if (roleDto.isIncluded()) {
						Role role = roleService.getRolesByName(
								roleDto.getRole().getName()).get(0);
						rolesList.add(role);
					}
				}
			}
			UserCategory group = this.userCategoryService.get(groupId);
			group.setName(groupDto.getName());
			group.setRoles(rolesList);
			userCategoryService.merge(group);
			status.setComplete();
			return "redirect:/groups";
		} catch (Exception e) {
			return "groups/updateGroupForm";
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String processCreationForm(
			@ModelAttribute("group") @Valid GroupDTO groupDto,
			BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			return "groups/createGroupForm";
		} else {
			
			List<UserCategory> userGroupList =  userCategoryService.getUserCategroryByName(groupDto.getName());
			
			if(userGroupList != null && !userGroupList.isEmpty()){
				result.rejectValue("name", "groupname.exists");
				return "groups/createGroupForm";
			}
			
			UserCategory group = new UserCategory();

			Set<Role> rolesList = new HashSet<Role>();
			if (null != groupDto.getRoleFormList().getRoles()
					&& groupDto.getRoleFormList().getRoles().size() > 0) {
				for (RoleFormDTO roleDto : groupDto.getRoleFormList()
						.getRoles()) {
					if (roleDto.isIncluded()) {
						Role role = roleService.getRolesByName(
								roleDto.getRole().getName()).get(0);
						rolesList.add(role);
					}
				}
			}
			group.setRoles(rolesList);
			group.setName(groupDto.getName());
			MultipartFile photo= groupDto.getPhotoFile();
			
			if (null != photo ) {
				String TEMP_DIR = parameterService
						.getParameterName(ParameterCode.TEMP_DIRECTORY.toString())
						.get(0).getValue();

					if (photo.getSize() != 0) {
						try {
							File destFile = new File(new File(TEMP_DIR),
									photo.getOriginalFilename());
							photo.transferTo(destFile);
							BufferedImage bimg = ImageIO.read(destFile);
							BufferedImage bimgResized = ImageService
									.createResizedCopy(bimg, 300, 300, true);
							File destFile1 = new File(new File(TEMP_DIR), "small_"
									+ photo.getOriginalFilename());
							ImageIO.write(bimgResized, "jpeg", destFile1);
							group.setPhoto(TEMP_DIR
									+ photo.getOriginalFilename());
						} catch (IOException e) {
							return "groups/createGroupForm";
						}
					}
			}
			this.userCategoryService.saveOrUpdate(group);
			status.setComplete();
			return "redirect:/groups";
		}
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String initFindForm(Model model) {

		GroupDTO group = new GroupDTO();

		RoleFormDTOList listFormDto = new RoleFormDTOList();

		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
		List<Role> allRolesList = roleService.getAll();

		for (Role role : allRolesList) {
			roleFormList.add(new RoleFormDTO(role, false));
		}
		listFormDto.setRoles(roleFormList);
		group.setRoleFormList(listFormDto);
		model.addAttribute("group", group);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/groups.htm", "group.gotolistgroup"));
		model.addAttribute("navigations", navigations);
		return "groups/createGroupForm";
	}
	
	
	@RequestMapping(value = "/upload/{groupId}/show", method = RequestMethod.GET)
	public String getUploadForm(@PathVariable("groupId") Long groupId, Model model) {
		model.addAttribute(new UploadItem());
		model.addAttribute("bienId", groupId);
		List<NavigationDTO> navigations = new ArrayList<NavigationDTO>();
		navigations.add(new NavigationDTO("/", "home"));
		navigations.add(new NavigationDTO("/groups.htm", "group.gotolistgroup"));
		navigations.add(new NavigationDTO("/groups/"+groupId+".htm", "group.action.details"));
		model.addAttribute("navigations", navigations);
		return "groups/uploadGroupPhotoForm";
	}

	@RequestMapping(value = "/upload/{groupId}/save", method = RequestMethod.POST)
	public String uploadAndSavePhotos(
			@ModelAttribute("uploadForm") UploadItem uploadForm,
			@PathVariable("groupId") long groupId, Model map) {

		UserCategory group = this.userCategoryService.get(groupId);

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
						BufferedImage bimgResized = ImageService
								.createResizedCopy(bimg, 300, 300, true);
						File destFile1 = new File(new File(TEMP_DIR), "small_"
								+ multipartFile.getOriginalFilename());
						ImageIO.write(bimgResized, "jpeg", destFile1);
						group.setPhoto(TEMP_DIR
								+ multipartFile.getOriginalFilename());
					} catch (IOException e) {
						return "groups/uploadGroupPhotoForm";
					}
				}
			}
			userCategoryService.merge(group);
		}
		return "redirect:/groups/" + groupId;
	}
}
