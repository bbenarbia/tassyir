package net.bbenarbia.web.dto;

import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.Studio;

public class BienDTO {

	private String name;

	private Long id;

	private String reference;

	private String adresse;

	private String description;

	private double superficie;

	private String status;

	private String typeBien;

	private double prixVente;

	private double loyerMensuel;

	private double chargesMensuel;

	private String typeOperation;

	private String etatBien;

	private String etage;

	private int nbPieces;

	private Boolean ascenseur;

	private Boolean cuisineEquipee;

	private Boolean jardin;

	private int age;

	private int nbTerrasses;

	private int nbBalcons;

	private int nbParkingInt;

	private int nbParkingExt;

	private boolean interphone;

	private boolean digicode;

	private boolean gardien;

	private String consoEnergie;

	private String typeEauChaude;

	private String impactConso;

	private String natureChauffage;

	private String typeChauffage;

	private boolean meuble;

	private String transport;

	private boolean adapteHandicape;

	private String proximite;

	private double honoraires;

	private double depotGarantie;

	private int nbSallesBains;

	private int nbCaves;

	private boolean piscine;

	public BienDTO() {
		super();
	}

	public BienDTO(Appartement appartement) {
		this(appartement.getId(), appartement.getName(), appartement
				.getReference(), appartement.getAdresse(), appartement
				.getDescription(), appartement.getSuperficie(), appartement
				.getStatus().toString(), appartement.getPrixVente(),
				appartement.getLoyerMensuel(),
				appartement.getChargesMensuel(), appartement.getTypeOperation()
						.toString(), appartement.getEtatBien().toString(),
				appartement.getEtage(), appartement.getNbPieces(), appartement
						.isAscenseur(), appartement.isCuisineEquipee(), null,
				appartement.getAge(), appartement.getTypeBien(), appartement
						.getNbTerrasses(), appartement.getNbBalcons(),
				appartement.getNbParkingInt(), appartement.getNbParkingExt(),
				appartement.isInterphone(), appartement.isDigicode(),
				appartement.isGardien(), appartement.getConsoEnergie()
						.toString(), appartement.getTypeEauChaude().toString(),
				appartement.getImpactConso().toString(), appartement
						.getNatureChauffage().toString(), appartement
						.getTypeChauffage().toString(), appartement.isMeuble(),
				appartement.getTransport(), appartement.isAdapteHandicape(),
				appartement.getProximite(), appartement.getHonoraires(),
				appartement.getDepotGarantie(), appartement.getNbSallesBains(),
				appartement.getNbCaves(), false);
	}

	public BienDTO(Studio studio) {
		this(studio.getId(), studio.getName(), studio.getReference(), studio
				.getAdresse(), studio.getDescription(), studio.getSuperficie(),
				studio.getStatus().toString(), studio.getPrixVente(), studio.getLoyerMensuel(), studio
						.getChargesMensuel(), studio.getTypeOperation()
						.toString(), studio.getEtatBien().toString(), studio
						.getEtage(), 0, studio.isAscenseur(), null, null,
				studio.getAge(), studio.getTypeBien(), studio.getNbTerrasses(),
				studio.getNbBalcons(), studio.getNbParkingInt(), studio
						.getNbParkingExt(), studio.isInterphone(), studio
						.isDigicode(), studio.isGardien(), studio
						.getConsoEnergie().toString(), studio
						.getTypeEauChaude().toString(), studio.getImpactConso()
						.toString(), studio.getNatureChauffage().toString(),
				studio.getTypeChauffage().toString(), studio.isMeuble(), studio
						.getTransport(), studio.isAdapteHandicape(), studio
						.getProximite(), studio.getHonoraires(), studio
						.getDepotGarantie(), studio.getNbSallesBains(), studio
						.getNbCaves(), false);
	}

	// public BienDTO(Commerce commerce) {
	// this(commerce.getId(), commerce.getName(), commerce.getReference(),
	// commerce.getAdresse(), commerce.getDescription(), commerce
	// .getSuperficie(), commerce.getStatus().toString(),
	// commerce.getPrixVente(), commerce.getPrixMinVente(), commerce
	// .getLoyerMensuel(), commerce.getChargesMensuel(),
	// commerce.getTypeOperation().toString(), commerce.getEtatBien()
	// .toString(), "", 0, null, null, null,
	// commerce.getAge(), commerce.getTypeBien());
	// }

	public BienDTO(Long id, String name, String reference, String adresse,
			String description, double superficie, String status,
			double prixVente, double loyerMensuel,
			double chargesMensuel, String typeOperation, String etatBien,
			String etage, int nbPieces, Boolean ascenseur,
			Boolean cuisineEquipee, Boolean jardin, int age, String typeBien,
			int nbTerrasses, int nbBalcons, int nbParkingInt, int nbParkingExt,
			boolean interphone, boolean digicode, boolean gardien,
			String consoEnergie, String typeEauChaude, String impactConso,
			String natureChauffage, String typeChauffage, boolean meuble,
			String transport, boolean adapteHandicape, String proximite,
			double honoraires, double depotGarantie, int nbSallesBains,
			int nbCaves, boolean piscine) {
		super();
		this.name = name;
		this.id = id;
		this.reference = reference;
		this.adresse = adresse;
		this.description = description;
		this.superficie = superficie;
		this.status = status;
		this.prixVente = prixVente;
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
		this.typeBien = typeBien;
		this.nbTerrasses = nbTerrasses;
		this.nbBalcons = nbBalcons;
		this.nbParkingInt = nbParkingInt;
		this.nbParkingExt = nbParkingExt;
		this.interphone = interphone;
		this.digicode = digicode;
		this.gardien = gardien;
		this.consoEnergie = consoEnergie;
		this.typeEauChaude = typeEauChaude;
		this.impactConso = impactConso;
		this.natureChauffage = natureChauffage;
		this.typeChauffage = typeChauffage;
		this.meuble = meuble;
		this.transport = transport;
		this.adapteHandicape = adapteHandicape;
		this.proximite = proximite;
		this.honoraires = honoraires;
		this.depotGarantie = depotGarantie;
		this.nbSallesBains = nbSallesBains;
		this.nbCaves = nbCaves;
		this.piscine = piscine;
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

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
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

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public int getNbTerrasses() {
		return nbTerrasses;
	}

	public void setNbTerrasses(int nbTerrasses) {
		this.nbTerrasses = nbTerrasses;
	}

	public int getNbBalcons() {
		return nbBalcons;
	}

	public void setNbBalcons(int nbBalcons) {
		this.nbBalcons = nbBalcons;
	}

	public int getNbParkingInt() {
		return nbParkingInt;
	}

	public void setNbParkingInt(int nbParkingInt) {
		this.nbParkingInt = nbParkingInt;
	}

	public int getNbParkingExt() {
		return nbParkingExt;
	}

	public void setNbParkingExt(int nbParkingExt) {
		this.nbParkingExt = nbParkingExt;
	}

	public boolean isInterphone() {
		return interphone;
	}

	public void setInterphone(boolean interphone) {
		this.interphone = interphone;
	}

	public boolean isDigicode() {
		return digicode;
	}

	public void setDigicode(boolean digicode) {
		this.digicode = digicode;
	}

	public boolean isGardien() {
		return gardien;
	}

	public void setGardien(boolean gardien) {
		this.gardien = gardien;
	}

	public String getConsoEnergie() {
		return consoEnergie;
	}

	public void setConsoEnergie(String consoEnergie) {
		this.consoEnergie = consoEnergie;
	}

	public String getTypeEauChaude() {
		return typeEauChaude;
	}

	public void setTypeEauChaude(String typeEauChaude) {
		this.typeEauChaude = typeEauChaude;
	}

	public String getImpactConso() {
		return impactConso;
	}

	public void setImpactConso(String impactConso) {
		this.impactConso = impactConso;
	}

	public String getNatureChauffage() {
		return natureChauffage;
	}

	public void setNatureChauffage(String natureChauffage) {
		this.natureChauffage = natureChauffage;
	}

	public String getTypeChauffage() {
		return typeChauffage;
	}

	public void setTypeChauffage(String typeChauffage) {
		this.typeChauffage = typeChauffage;
	}

	public boolean isMeuble() {
		return meuble;
	}

	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public boolean isAdapteHandicape() {
		return adapteHandicape;
	}

	public void setAdapteHandicape(boolean adapteHandicape) {
		this.adapteHandicape = adapteHandicape;
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

	public int getNbSallesBains() {
		return nbSallesBains;
	}

	public void setNbSallesBains(int nbSallesBains) {
		this.nbSallesBains = nbSallesBains;
	}

	public int getNbCaves() {
		return nbCaves;
	}

	public void setNbCaves(int nbCaves) {
		this.nbCaves = nbCaves;
	}

	public boolean isPiscine() {
		return piscine;
	}

	public void setPiscine(boolean piscine) {
		this.piscine = piscine;
	}

}
