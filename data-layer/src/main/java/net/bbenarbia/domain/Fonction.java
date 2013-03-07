package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.enums.EnumFonction;


@Entity
@Table(name = "fonction")
public class Fonction extends NamedEntity{

	@Enumerated(EnumType.ORDINAL)
    @Column(name = "fonction_type")
	private EnumFonction type;

	public EnumFonction getType() {
		return type;
	}

	public void setType(EnumFonction type) {
		this.type = type;
	} 


}