package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;

@Entity
@Table(name = "roles")
public class Role extends NamedEntity{

	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
