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
@DiscriminatorValue(Constants.ENTREPOT)
public class Entrepot extends BienImmobilier{

	@Column(name = "age")
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
