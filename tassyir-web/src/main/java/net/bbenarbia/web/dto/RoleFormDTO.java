package net.bbenarbia.web.dto;

import net.bbenarbia.domain.Role;

public class RoleFormDTO {

	private Role role;
	private boolean included = false;
	
	
	public RoleFormDTO() {
		super();
	}
	public RoleFormDTO(Role role, boolean included) {
		super();
		this.role = role;
		this.included = included;
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isIncluded() {
		return included;
	}
	public void setIncluded(boolean included) {
		this.included = included;
	}
	
	
}
