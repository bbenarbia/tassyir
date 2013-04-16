package net.bbenarbia.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class GroupDTO extends NamedDTO{

	private RoleFormDTOList roleFormList;
	private MultipartFile photoFile;
	
	
	public RoleFormDTOList getRoleFormList() {
		return roleFormList;
	}

	public void setRoleFormList(RoleFormDTOList roleFormList) {
		this.roleFormList = roleFormList;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}
	
}
