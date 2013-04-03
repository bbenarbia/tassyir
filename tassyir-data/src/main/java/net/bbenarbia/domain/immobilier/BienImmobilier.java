package net.bbenarbia.domain.immobilier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bbenarbia.domain.Departement;
import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeOperation;

@Entity
@Table(name = "biens")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeBien",discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("GENERIC")
public class BienImmobilier extends NamedEntity {

	@Column(name = "ref")
	private String reference;
	
	@Column(name = "adresse")
	private String adresse;
	
	@ManyToOne
	@JoinColumn(name = "idDepartement")
	private Departement departement;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "superficie")
	private double superficie;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumStatutProperty status;
	
	@Column(name = "prixVente")
	private double prixVente;
	
	@Column(name = "prixMinVente")
	private double prixMinVente;
//	
	@OneToMany(mappedBy = "bien", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	private List<Photo> photos;
	
	@Column(name = "loyerMensuel")
	private double loyerMensuel;
	
	@Column(name = "chargesMensuel")
	private double chargesMensuel;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeOperation typeOperation;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumEtatBien etatBien;
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public EnumStatutProperty getStatus() {
		return status;
	}

	public void setStatus(EnumStatutProperty status) {
		this.status = status;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	public double getPrixMinVente() {
		return prixMinVente;
	}

	public void setPrixMinVente(double prixMinVente) {
		this.prixMinVente = prixMinVente;
	}

	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	public double getChargesMensuel() {
		return chargesMensuel;
	}

	public void setChargesMensuel(double chargesMensuel) {
		this.chargesMensuel = chargesMensuel;
	}

	public EnumTypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(EnumTypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public EnumEtatBien getEtatBien() {
		return etatBien;
	}

	public void setEtatBien(EnumEtatBien etatBien) {
		this.etatBien = etatBien;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
}
