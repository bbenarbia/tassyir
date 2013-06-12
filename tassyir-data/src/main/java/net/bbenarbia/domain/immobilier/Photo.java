package net.bbenarbia.domain.immobilier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;

@Entity
@Table(name = "photos")
public class Photo extends NamedEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bien")
	private BienImmobilier bien;

	@Column(name = "path")
	private String photoPath;

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

}
