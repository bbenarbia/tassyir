package net.bbenarbia.web.dto;

import java.util.LinkedList;

public class GroupFormDTOList {

	private LinkedList<GroupFormDTO> groups = new LinkedList<GroupFormDTO>();

	public LinkedList<GroupFormDTO> getGroups() {
		return groups;
	}

	public void setGroups(LinkedList<GroupFormDTO> groups) {
		this.groups = groups;
	}
}
