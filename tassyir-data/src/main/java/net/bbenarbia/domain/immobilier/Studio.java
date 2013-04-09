package net.bbenarbia.domain.immobilier;

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
@DiscriminatorValue(Constants.STUDIO)
public class Studio extends BienImmobilier{
	
	@Column(name = "etage")
	private int etage;
	
	@Column(name = "ascenseur")
	private boolean ascenseur;
	
	@Column(name = "age")
	private int age;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumConsEnergie  consoEnergie;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumImpactConso impactConso;
	
	@Column(name = "meuble")
	private boolean meuble;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNatureChauffage natureChauffage;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeChauffage typeChauffage;
	
	
	
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAscenseur() {
		return ascenseur;
	}
	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
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
	public boolean isMeuble() {
		return meuble;
	}
	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
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
