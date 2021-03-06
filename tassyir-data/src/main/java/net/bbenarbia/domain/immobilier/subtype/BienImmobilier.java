package net.bbenarbia.domain.immobilier.subtype;

import java.util.HashSet;
import java.util.Set;

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

import net.bbenarbia.domain.Town;
import net.bbenarbia.domain.User;
import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.base.UniteMesure;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.Photo;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeBien", discriminatorType = DiscriminatorType.STRING)
// @DiscriminatorValue("GENERIC")
public class BienImmobilier extends NamedEntity {

	@Column(name = "ref")
	private String reference;

	@Column(name = "adresse")
	private String adresse = "";

	@Column(name = "transport")
	private String transport;

	@Column(name = "adapteHandicape")
	private boolean adapteHandicape;

	@Column(name = "proximite")
	private String proximite;

	@ManyToOne
	@JoinColumn(name = "idDepartement")
	private Town departement;

	@Column(name = "description")
	private String description;

	@Column(name = "superficie")
	private double superficie;

	@ManyToOne
	@JoinColumn(name = "uniteSuperficie")
	private UniteMesure uniteSuperficie;

	@ManyToOne
	@JoinColumn(name = "proprietaire")
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

	@ManyToOne
	@JoinColumn(name = "unitePrix")
	private UniteMesure unitePrix;

	@Column(name = "depotGarantie")
	private double depotGarantie;

	@OneToMany(mappedBy = "bien", fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Photo> photos = new HashSet<Photo>(0);

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

	@Column(name = "validated")
	private boolean validated;

	@Column(name = "toDelete")
	private boolean toDelete;

	@Column(name = "whyDelete")
	private String whyDelete;

	@Column(name = "eauPotable")
	private boolean eauPotable;

	@Column(name = "gaz")
	private boolean gaz;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "dateMiseAjour", nullable = false)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	private LocalDateTime dateMiseAjour;

	public String getDescription() {
		return description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public Town getDepartement() {
		return departement;
	}

	public void setDepartement(Town departement) {
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

	public LocalDateTime getDateMiseAjour() {
		return dateMiseAjour;
	}

	public void setDateMiseAjour(LocalDateTime dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public boolean isEauPotable() {
		return eauPotable;
	}

	public void setEauPotable(boolean eauPotable) {
		this.eauPotable = eauPotable;
	}

	public boolean isGaz() {
		return gaz;
	}

	public void setGaz(boolean gaz) {
		this.gaz = gaz;
	}

	public boolean isToDelete() {
		return toDelete;
	}

	public void setToDelete(boolean toDelete) {
		this.toDelete = toDelete;
	}

	public String getWhyDelete() {
		return whyDelete;
	}

	public void setWhyDelete(String whyDelete) {
		this.whyDelete = whyDelete;
	}

	public UniteMesure getUniteSuperficie() {
		return uniteSuperficie;
	}

	public void setUniteSuperficie(UniteMesure uniteSuperficie) {
		this.uniteSuperficie = uniteSuperficie;
	}

	public UniteMesure getUnitePrix() {
		return unitePrix;
	}

	public void setUnitePrix(UniteMesure unitePrix) {
		this.unitePrix = unitePrix;
	}

	
}
