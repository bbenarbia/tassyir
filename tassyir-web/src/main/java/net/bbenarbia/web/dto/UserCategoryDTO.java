package net.bbenarbia.web.dto;

import net.bbenarbia.domain.UserCategory;

public class UserCategoryDTO {

	private Long id;
	private String name;

	
	
	public UserCategory getUserCategory(){
		UserCategory userCategory = new UserCategory();
		userCategory.setId(id);
		userCategory.setName(name);
		
		return userCategory;
		
	}
	public UserCategoryDTO() {
		super();
	}
	
	public UserCategoryDTO(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public UserCategoryDTO(UserCategory userCategory) {
		super();
		this.name = userCategory.getName();
		this.id = userCategory.getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
