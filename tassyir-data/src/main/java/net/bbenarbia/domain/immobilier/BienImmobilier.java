package net.bbenarbia.domain.immobilier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
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
import net.bbenarbia.domain.User;
import net.bbenarbia.domain.base.Adresse;
import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeOperation;

@Entity
@Table(name = "biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeBien", discriminatorType = DiscriminatorType.STRING)
// @DiscriminatorValue("GENERIC")
public class BienImmobilier extends NamedEntity {

	@Column(name = "ref")
	private String reference;

	@Embedded
	private Adresse adresse;
	
	@Column(name = "transport")
	private String transport;

	@Column(name = "adapteHandicape")
	private boolean adapteHandicape;

	@Column(name = "proximite")
	private String proximite;

	@ManyToOne
	@JoinColumn(name = "idDepartement")
	private Departement departement;

	@Column(name = "description")
	private String description;

	@Column(name = "superficie")
	private double superficie;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="proprietaire")
	private User proprietaire;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumStatutProperty status;

	@Column(name = "prixVente")
	private double prixVente;

	@Column(name = "prixMinVente")
	private double prixMinVente;
	
	@Column(name = "honoraires")
	private double honoraires;

	@Column(name = "depotGarantie")
	private double depotGarantie;

	@OneToMany(mappedBy = "bien", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	private List<Photo> photos = new ArrayList<Photo>(0);

	@Column(name = "loyerMensuel")
	private double loyerMensuel;

	@Column(name = "chargesMensuel")
	private double chargesMensuel;

	@Column(name = "nbSallesBains")
	private int nbSallesBains;

	@Column(name = "nbCaves")
	private int nbCaves;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeOperation typeOperation;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumEtatBien etatBien;

	@Column(nullable = false, updatable = false, insertable = false)
	private String typeBien;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		if(adresse != null){
			this.adresse = adresse;
		}
		else {
			this.adresse = new Adresse();
		}
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

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public boolean isAdapteHandicape() {
		return adapteHandicape;
	}

	public void setAdapteHandicape(boolean adapteHandicape) {
		this.adapteHandicape = adapteHandicape;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getProximite() {
		return proximite;
	}

	public void setProximite(String proximite) {
		this.proximite = proximite;
	}

	public double getHonoraires() {
		return honoraires;
	}

	public void setHonoraires(double honoraires) {
		this.honoraires = honoraires;
	}

	public double getDepotGarantie() {
		return depotGarantie;
	}

	public void setDepotGarantie(double depotGarantie) {
		this.depotGarantie = depotGarantie;
	}

	public int getNbCaves() {
		return nbCaves;
	}

	public void setNbCaves(int nbCaves) {
		this.nbCaves = nbCaves;
	}

	public int getNbSallesBains() {
		return nbSallesBains;
	}

	public void setNbSallesBains(int nbSallesBains) {
		this.nbSallesBains = nbSallesBains;
	}

	public double getPrixMinVente() {
		return prixMinVente;
	}

	public void setPrixMinVente(double prixMinVente) {
		this.prixMinVente = prixMinVente;
	}

	public User getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(User proprietaire) {
		this.proprietaire = proprietaire;
	}

}
