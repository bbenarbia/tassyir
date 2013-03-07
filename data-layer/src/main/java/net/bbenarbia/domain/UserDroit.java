package net.bbenarbia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.bbenarbia.domain.base.BaseEntity;
import net.bbenarbia.domain.enums.EnumDroit;
import net.bbenarbia.domain.enums.EnumModule;

@Entity
@Table(name = "user_droit")
public class UserDroit extends BaseEntity {

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumDroit droit;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumModule module;

	@Column(nullable = false)
	private String description;

	@Transient
	public String getAutorisation() {
		if (module == null || droit == null) {
			return null;
		}
		return droit + "_" + module;
	}
}
