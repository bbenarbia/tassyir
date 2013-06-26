package net.bbenarbia.domain.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import net.bbenarbia.domain.enums.EnumTypeUniteMesure;

@Entity
@Table(name = "unites")
public class UniteMesure extends NamedEntity {

	@Column(name = "abreviation")
	private String abreviation;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeUniteMesure typeUnite;

	@Column(name = "valeur")
	private Double value;
	
	
	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public EnumTypeUniteMesure getTypeUnite() {
		return typeUnite;
	}

	public void setTypeUnite(EnumTypeUniteMesure typeUnite) {
		this.typeUnite = typeUnite;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
