package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.bbenarbia.domain.base.BaseEntity;
import net.bbenarbia.domain.enums.EnumDroit;
import net.bbenarbia.domain.enums.EnumModule;

@Entity
@Table(name = "droitsutilisateur")
public class DroitsUtilisateur extends BaseEntity {

	/**
	 * to do Transform droit and module to enum
	 */
	private EnumDroit droit;
	private EnumModule module;
	private String description ;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public EnumDroit getDroit() {
		return droit;
	}

	public void setDroit(EnumDroit droit) {
		this.droit = droit;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public EnumModule getModule() {
		return module;
	}

	public void setModule(EnumModule module) {
		this.module = module;
	}

	@Column(nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getAutorisation() {
		if (module == null || droit == null) {
			return null;
		}
		return droit + "_" + module;
	}
}