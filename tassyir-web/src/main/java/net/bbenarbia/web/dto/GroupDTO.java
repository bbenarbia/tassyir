package net.bbenarbia.web.dto;

public class GroupDTO extends NamedDTO{

	private RoleFormDTOList roleFormList;

	public RoleFormDTOList getRoleFormList() {
		return roleFormList;
	}

	public void setRoleFormList(RoleFormDTOList roleFormList) {
		this.roleFormList = roleFormList;
	}
	
}
