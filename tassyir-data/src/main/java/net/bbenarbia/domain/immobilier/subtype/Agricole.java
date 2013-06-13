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
@DiscriminatorValue(Constants.AGRICOLE)
public class Agricole extends BienImmobilier {

	@Column(name = "puit")
	private boolean puit;

	public boolean isPuit() {
		return puit;
	}

	public void setPuit(boolean puit) {
		this.puit = puit;
	}
	
	
}
