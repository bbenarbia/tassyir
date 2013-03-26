package net.bbenarbia.web.dto;

import net.bbenarbia.domain.UserCategory;

public class GroupFormDTO {
	private UserCategory group;
	private boolean included = false;
	
	public GroupFormDTO() {
		super();
	}
	public GroupFormDTO(UserCategory group, boolean included) {
		super();
		this.group = group;
		this.included = included;
	}
	
	public UserCategory getGroup() {
		return group;
	}
	public void setGroup(UserCategory group) {
		this.group = group;
	}
	public boolean isIncluded() {
		return included;
	}
	public void setIncluded(boolean included) {
		this.included = included;
	}
	
	
	
}
