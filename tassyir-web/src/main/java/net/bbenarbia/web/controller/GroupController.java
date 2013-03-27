package net.bbenarbia.web.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.service.IRoleService;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.web.dto.GroupDTO;
import net.bbenarbia.web.dto.RoleFormDTO;
import net.bbenarbia.web.dto.RoleFormDTOList;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("group")
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private IUserCategoryService userCategoryService;;

	@Autowired
	private IRoleService roleService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showGroupList(Model model) {

		Collection<UserCategory> results = this.userCategoryService.getAll();
		model.addAttribute("selections", results);
		return "groups/groupList";
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
		return "groups/updateGroupForm";
	}

	@RequestMapping(value = "/{groupId}/edit", method = RequestMethod.POST)
	public String processUpdateGroupForm(@Valid GroupDTO groupDto,
			BindingResult result, @PathVariable("groupId") Long groupId,
			SessionStatus status) {
		try {

			if (result.hasErrors()) {
				return "groups/createGroupForm";
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
		return "groups/createGroupForm";
	}
}
