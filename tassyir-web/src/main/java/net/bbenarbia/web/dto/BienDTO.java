package net.bbenarbia.web.dto;

import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.Commerce;
import net.bbenarbia.domain.immobilier.Studio;

public class BienDTO {

	private String name;

	private Long id;

	private String reference;

	private String adresse;

	private String description;

	private double superficie;

	private String status;

	private double prixVente;

	private double prixMinVente;

	// private List<Photo> photos;

	private double loyerMensuel;

	private double chargesMensuel;

	private String typeOperation;

	private String etatBien;

	private int etage;

	private int nbPieces;

	private Boolean ascenseur;

	private Boolean cuisineEquipee;

	private Boolean jardin;

	private int age;

	public BienDTO() {
		super();
	}

	public BienDTO(Appartement appartement) {
		this(appartement.getId() ,appartement.getName(),  appartement.getReference(),  appartement.getAdresse(),
				appartement.getDescription(),  appartement.getSuperficie(), appartement.getStatus().toString(),
				appartement.getPrixVente(),  appartement.getPrixMinVente(),  appartement.getLoyerMensuel(),
				appartement.getChargesMensuel(),  appartement.getTypeOperation().toString(), appartement.getEtatBien().toString(),
				appartement.getEtage(),  appartement.getNbPieces(),  appartement.isAscenseur(),  appartement.isCuisineEquipee(),
				null,  appartement.getAge()) ;
	}
	
	
	public BienDTO(Studio studio) {
		this(studio.getId(), studio.getName(),  studio.getReference(),  studio.getAdresse(),
				studio.getDescription(),  studio.getSuperficie(), studio.getStatus().toString(),
				studio.getPrixVente(),  studio.getPrixMinVente(),  studio.getLoyerMensuel(),
				studio.getChargesMensuel(),  studio.getTypeOperation().toString(), studio.getEtatBien().toString(),
				studio.getEtage(),  0,  studio.isAscenseur(),  null,
				null,  studio.getAge()) ;
	}
	
	public BienDTO(Commerce commerce) {
		this(commerce.getId(), commerce.getName(),  commerce.getReference(),  commerce.getAdresse(),
				commerce.getDescription(),  commerce.getSuperficie(), commerce.getStatus().toString(),
				commerce.getPrixVente(),  commerce.getPrixMinVente(),  commerce.getLoyerMensuel(),
				commerce.getChargesMensuel(),  commerce.getTypeOperation().toString(), commerce.getEtatBien().toString(),
				0,  0,  null,  null,
				null,  commerce.getAge()) ;
	}
	
	
	public BienDTO(Long id, String name, String reference, String adresse,
			String description, double superficie, String status,
			double prixVente, double prixMinVente, double loyerMensuel,
			double chargesMensuel, String typeOperation, String etatBien,
			int etage, int nbPieces, Boolean ascenseur, Boolean cuisineEquipee,
			Boolean jardin, int age) {
		super();
		this.name = name;
		this.id = id;
		this.reference = reference;
		this.adresse = adresse;
		this.description = description;
		this.superficie = superficie;
		this.status = status;
		this.prixVente = prixVente;
		this.prixMinVente = prixMinVente;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuel = chargesMensuel;
		this.typeOperation = typeOperation;
		this.etatBien = etatBien;
		this.etage = etage;
		this.nbPieces = nbPieces;
		this.ascenseur = ascenseur;
		this.cuisineEquipee = cuisineEquipee;
		this.jardin = jardin;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public String getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(String typeOperation) {
		this.typeOperation = typeOperation;
	}

	public String getEtatBien() {
		return etatBien;
	}

	public void setEtatBien(String etatBien) {
		this.etatBien = etatBien;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}

	public Boolean getAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(Boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public Boolean getCuisineEquipee() {
		return cuisineEquipee;
	}

	public void setCuisineEquipee(Boolean cuisineEquipee) {
		this.cuisineEquipee = cuisineEquipee;
	}

	public Boolean getJardin() {
		return jardin;
	}

	public void setJardin(Boolean jardin) {
		this.jardin = jardin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
