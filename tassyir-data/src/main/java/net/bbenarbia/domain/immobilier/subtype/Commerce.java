package net.bbenarbia.domain.immobilier.subtype;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.bbenarbia.constants.Constants;
import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumTypeChauffage;

@Entity
@Table(name = "biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(Constants.COMMERCE)
public class Commerce extends BienImmobilier{

	@Column(name = "age")
	private int age;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumConsEnergie  consoEnergie;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumImpactConso impactConso;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNatureChauffage natureChauffage;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeChauffage typeChauffage;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EnumConsEnergie getConsoEnergie() {
		return consoEnergie;
	}

	public void setConsoEnergie(EnumConsEnergie consoEnergie) {
		this.consoEnergie = consoEnergie;
	}

	public EnumImpactConso getImpactConso() {
		return impactConso;
	}

	public void setImpactConso(EnumImpactConso impactConso) {
		this.impactConso = impactConso;
	}

	public EnumNatureChauffage getNatureChauffage() {
		return natureChauffage;
	}

	public void setNatureChauffage(EnumNatureChauffage natureChauffage) {
		this.natureChauffage = natureChauffage;
	}

	public EnumTypeChauffage getTypeChauffage() {
		return typeChauffage;
	}

	public void setTypeChauffage(EnumTypeChauffage typeChauffage) {
		this.typeChauffage = typeChauffage;
	}

}
