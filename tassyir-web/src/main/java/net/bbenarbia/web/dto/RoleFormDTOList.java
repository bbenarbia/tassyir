package net.bbenarbia.web.dto;

import java.util.LinkedList;

public class RoleFormDTOList {

	private LinkedList<RoleFormDTO> roles = new LinkedList<RoleFormDTO>();

	public LinkedList<RoleFormDTO> getRoles() {
		return roles;
	}

	public void setRoles(LinkedList<RoleFormDTO> roles) {
		this.roles = roles;
	}

}
