package net.bbenarbia.domain.immobilier.subtype;

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
@DiscriminatorValue(Constants.MAISON)
public class Maison extends HabitableBien {

	@Column(name = "jardin")
	private boolean jardin;

	@Column(name = "piscine")
	private boolean piscine;

	public boolean isJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public boolean isPiscine() {
		return piscine;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}	
}
