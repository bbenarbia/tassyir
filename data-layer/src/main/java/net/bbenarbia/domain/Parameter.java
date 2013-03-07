package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;

@Entity
@Table(name = "parameters")
public class Parameter extends NamedEntity {

	@Column(name = "parameter_value")
	private String value;

	@Column(name = "parameter_description")
	private String description;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
