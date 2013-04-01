package net.bbenarbia.domain.immobilier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import net.bbenarbia.constants.Constants;

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
	
}
