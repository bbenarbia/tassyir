package net.bbenarbia.web.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.bbenarbia.domain.Role;
import net.bbenarbia.domain.UserCategory;
import net.bbenarbia.service.IRoleService;
import net.bbenarbia.service.IUserCategoryService;
import net.bbenarbia.web.dto.RoleFormDTO;
import net.bbenarbia.web.dto.RoleFormDTOList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String rolesGroupForm(@PathVariable("groupId") Long groupId, Model model) {

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
		userCategoryService.saveOrUpdate(group);
		
		return "redirect:/groups";
	}
	
	
	
//	@RequestMapping(value = "/{groupId}/roles", method = RequestMethod.GET)
//	public String rolesUserForm(@PathVariable("groupId") Long groupId, Model model) {
//
//		RoleFormDTOList listFormDto = new RoleFormDTOList();
//
//		LinkedList<RoleFormDTO> roleFormList = new LinkedList<RoleFormDTO>();
//		User user = this.utilisateurService.get(userId);
//		List<Role> allRolesList = roleService.getAll();
//
//		for (Role role : allRolesList) {
//			if (user.getRoles() != null && user.getRoles().contains(role)) {
//				roleFormList.add(new RoleFormDTO(role, true));
//			} else {
//				roleFormList.add(new RoleFormDTO(role, false));
//			}
//		}
//		listFormDto.setRoles(roleFormList);
//		model.addAttribute("userId", userId);
//		model.addAttribute("roleFormList", listFormDto);
//		return "users/rolesList";
//	}
//
//	@RequestMapping(value = "/{userId}/roles/save", method = RequestMethod.POST)
//	public String saveRoles(
//			@ModelAttribute("roleFormList") RoleFormDTOList roleFormList,
//			@PathVariable("userId") Long userId) {
//
//		User user = this.utilisateurService.get(userId);
//		Set<Role> rolesList = new HashSet<Role>();
//		if (null != roleFormList.getRoles()
//				&& roleFormList.getRoles().size() > 0) {
//			for (RoleFormDTO roleDto : roleFormList.getRoles()) {
//				if (roleDto.isIncluded()) {
//					Role role = roleService.getRolesByName(
//							roleDto.getRole().getName()).get(0);
//					rolesList.add(role);
//				}
//			}
//		}
//		user.setRolesInternal(rolesList);
//		utilisateurService.saveOrUpdate(user);
//		
//		return "redirect:/users/" + user.getId();
////		return "users/usersList";
//	}
}
