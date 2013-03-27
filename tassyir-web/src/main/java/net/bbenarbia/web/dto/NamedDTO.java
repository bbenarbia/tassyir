package net.bbenarbia.web.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class NamedDTO {

	@NotEmpty(message = "Name must not be empty.")
	protected String name;

	protected String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
