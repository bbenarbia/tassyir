package net.bbenarbia.web.dto;

import java.util.List;

import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeChauffage;
import net.bbenarbia.domain.enums.EnumTypeEauChaude;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.Appartement;
import net.bbenarbia.domain.immobilier.Maison;
import net.bbenarbia.domain.immobilier.Studio;

import org.springframework.web.multipart.MultipartFile;
/**
 * Le Bien DTO 
 * @author bbenarbia
 *
 */
public class BienDTO {

	private String name;

	private Long id;

	private String reference;

	private String adresse;

	private String ville;

	private String codePostal;

	private String departement;

	private String description;

	private double superficie;

	private String status;

	private String typeBien;

	private double prixVente;
	
	private double prixMinVente;

	private double loyerMensuel;

	private double chargesMensuel;

	private String typeOperation;

	private String etatBien;

	private String etage = "0 sur 0";

	private int nbPieces;

	private int nbChambres;

	private Boolean ascenseur;

	private Boolean cuisineEquipee;

	private Boolean jardin;

	private int age;

	private int nbTerrasses;

	private int nbBalcons;

	private int nbParkingInt;

	private int nbParkingExt;

	private Boolean interphone;

	private Boolean digicode;

	private Boolean gardien;

	private String consoEnergie;

	private String typeEauChaude;

	private String impactConso;

	private String natureChauffage;

	private String typeChauffage;

	private Boolean meuble;

	private String transport;

	private Boolean adapteHandicape;

	private String proximite;

	private double honoraires;

	private double depotGarantie;

	private int nbSallesBains;

	private int nbCaves;

	private Boolean piscine;
	
	private List<MultipartFile> files;

	public BienDTO() {
		super();
	}

	public BienDTO(Appartement appartement) {
		this(appartement.getId(), appartement.getName(), appartement
				.getReference(), appartement.getAdresse(),
				appartement.getDepartement().getCodePostal(), appartement
						.getDepartement().getName(), appartement.getDepartement()
						.getReference(), appartement.getDescription(),
				appartement.getSuperficie(),
				appartement.getStatus().toString(), appartement.getPrixVente(), appartement.getPrixMinVente(),
				appartement.getLoyerMensuel(), appartement.getChargesMensuel(),
				appartement.getTypeOperation().toString(), appartement
						.getEtatBien().toString(), appartement.getEtage(),
				appartement.getNbPieces(), appartement.getNbChambres(),
				appartement.isAscenseur(), appartement.isCuisineEquipee(),
				null, appartement.getAge(), appartement.getTypeBien(),
				appartement.getNbTerrasses(), appartement.getNbBalcons(),
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

	public BienDTO(Maison maison) {
		this(maison.getId(), maison.getName(), maison.getReference(), maison
				.getAdresse(),
				maison.getDepartement().getCodePostal(), maison.getDepartement().getName()
						, maison.getDepartement().getReference(),
				maison.getDescription(), maison.getSuperficie(), maison
						.getStatus().toString(), maison.getPrixVente(), maison.getPrixMinVente(), maison
						.getLoyerMensuel(), maison.getChargesMensuel(), maison
						.getTypeOperation().toString(), maison.getEtatBien()
						.toString(), null, maison.getNbPieces(), maison
						.getNbChambres(), null, maison.isCuisineEquipee(),
				maison.isJardin(), maison.getAge(), maison.getTypeBien(),
				maison.getNbTerrasses(), maison.getNbBalcons(), maison
						.getNbParkingInt(), maison.getNbParkingExt(), maison
						.isInterphone(), maison.isDigicode(), null, maison
						.getConsoEnergie().toString(), maison
						.getTypeEauChaude().toString(), maison.getImpactConso()
						.toString(), maison.getNatureChauffage().toString(),
				maison.getTypeChauffage().toString(), maison.isMeuble(), maison
						.getTransport(), maison.isAdapteHandicape(), maison
						.getProximite(), maison.getHonoraires(), maison
						.getDepotGarantie(), maison.getNbSallesBains(), maison
						.getNbCaves(), maison.isPiscine());
	}

	public BienDTO(Studio studio) {
		this(studio.getId(), studio.getName(), studio.getReference(), studio
				.getAdresse(),
				studio.getDepartement().getCodePostal(), studio.getDepartement()
						.getName(), studio.getDepartement().getReference(),
				studio.getDescription(), studio.getSuperficie(), studio
						.getStatus().toString(), studio.getPrixVente(), studio.getPrixMinVente(), studio
						.getLoyerMensuel(), studio.getChargesMensuel(), studio
						.getTypeOperation().toString(), studio.getEtatBien()
						.toString(), studio.getEtage(), 0, 0, studio
						.isAscenseur(), null, null, studio.getAge(), studio
						.getTypeBien(), studio.getNbTerrasses(), studio
						.getNbBalcons(), studio.getNbParkingInt(), studio
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
			String codePostal, String ville, String departement,
			String description, double superficie, String status,
			double prixVente, double prixVenteMin,double loyerMensuel, double chargesMensuel,
			String typeOperation, String etatBien, String etage, int nbPieces,
			int nbChambres, Boolean ascenseur, Boolean cuisineEquipee,
			Boolean jardin, int age, String typeBien, int nbTerrasses,
			int nbBalcons, int nbParkingInt, int nbParkingExt,
			Boolean interphone, Boolean digicode, Boolean gardien,
			String consoEnergie, String typeEauChaude, String impactConso,
			String natureChauffage, String typeChauffage, Boolean meuble,
			String transport, Boolean adapteHandicape, String proximite,
			double honoraires, double depotGarantie, int nbSallesBains,
			int nbCaves, Boolean piscine) {

		super();
		this.name = name;
		this.id = id;
		this.reference = reference;
		this.departement = departement;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.description = description;
		this.superficie = superficie;
		this.status = status;
		this.prixVente = prixVente;
		this.prixMinVente = prixVenteMin;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuel = chargesMensuel;
		this.typeOperation = typeOperation;
		this.etatBien = etatBien;
		this.etage = etage;
		this.nbPieces = nbPieces;
		this.nbChambres = nbChambres;
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

	public Maison updateMaison(Maison maison) {

		//	Update the departement not complete
		maison.setName(name);
		maison.setReference(reference);
		maison.setAdresse(adresse);
		maison.setDescription(description);
		maison.setSuperficie(superficie);
		maison.setStatus(EnumStatutProperty.valueOf(status));
		maison.setPrixVente(prixVente);
		maison.setPrixMinVente(prixMinVente);
		maison.setLoyerMensuel(loyerMensuel);
		maison.setChargesMensuel(chargesMensuel);
		maison.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
		maison.setEtatBien(EnumEtatBien.valueOf(etatBien));
		maison.setTransport(transport);
		maison.setAdapteHandicape(adapteHandicape);
		maison.setProximite(proximite);
		maison.setHonoraires(honoraires);
		maison.setDepotGarantie(depotGarantie);
		maison.setNbSallesBains(nbSallesBains);
		maison.setNbCaves(nbCaves);		
		maison.setNbPieces(nbPieces);
		maison.setNbChambres(nbChambres);
		maison.setCuisineEquipee(cuisineEquipee);
		maison.setJardin(jardin);
		maison.setAge(age);
		maison.setNbTerrasses(nbTerrasses);
		maison.setNbBalcons(nbBalcons);
		maison.setNbParkingInt(nbParkingInt);
		maison.setNbParkingExt(nbParkingExt);
		maison.setInterphone(interphone);
		maison.setDigicode(digicode);
		maison.setConsoEnergie(EnumConsEnergie.valueOf(consoEnergie));
		maison.setTypeEauChaude(EnumTypeEauChaude.valueOf(typeEauChaude));
		maison.setImpactConso(EnumImpactConso.valueOf(impactConso));
		maison.setNatureChauffage(EnumNatureChauffage.valueOf(natureChauffage));
		maison.setTypeChauffage(EnumTypeChauffage.valueOf(typeChauffage));
		maison.setMeuble(meuble);
		maison.setPiscine(piscine);

		return maison;
	}

	public Appartement updateAppartement(Appartement appartement) {

//		Update the departement not complete
		appartement.setName(name);
		appartement.setReference(reference);
		appartement.setAdresse(adresse);
		appartement.setDescription(description);
		appartement.setSuperficie(superficie);
		appartement.setStatus(EnumStatutProperty.valueOf(status));
		appartement.setPrixVente(prixVente);
		appartement.setPrixMinVente(prixMinVente);
		appartement.setLoyerMensuel(loyerMensuel);
		appartement.setChargesMensuel(chargesMensuel);
		appartement.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
		appartement.setEtatBien(EnumEtatBien.valueOf(etatBien));
		appartement.setTransport(transport);
		appartement.setAdapteHandicape(adapteHandicape);
		appartement.setProximite(proximite);
		appartement.setHonoraires(honoraires);
		appartement.setDepotGarantie(depotGarantie);
		appartement.setNbSallesBains(nbSallesBains);
		appartement.setNbCaves(nbCaves);
		
		appartement.setNbPieces(nbPieces);
		appartement.setNbChambres(nbChambres);
		appartement.setCuisineEquipee(cuisineEquipee);
		appartement.setAscenseur(ascenseur);
		appartement.setEtage(etage);
		appartement.setAge(age);
		appartement.setNbTerrasses(nbTerrasses);
		appartement.setNbBalcons(nbBalcons);
		appartement.setNbParkingInt(nbParkingInt);
		appartement.setNbParkingExt(nbParkingExt);
		appartement.setInterphone(interphone);
		appartement.setDigicode(digicode);
		appartement.setConsoEnergie(EnumConsEnergie.valueOf(consoEnergie));
		appartement.setTypeEauChaude(EnumTypeEauChaude.valueOf(typeEauChaude));
		appartement.setImpactConso(EnumImpactConso.valueOf(impactConso));
		appartement.setNatureChauffage(EnumNatureChauffage
				.valueOf(natureChauffage));
		appartement.setTypeChauffage(EnumTypeChauffage.valueOf(typeChauffage));
		appartement.setMeuble(meuble);

		return appartement;
	}
	
	public Studio updateStudio(Studio studio) {

//		Update the departement not complete
		studio.setName(name);
		studio.setReference(reference);
		studio.setAdresse(adresse);
		studio.setDescription(description);
		studio.setSuperficie(superficie);
		studio.setStatus(EnumStatutProperty.valueOf(status));
		studio.setPrixVente(prixVente);
		studio.setPrixMinVente(prixMinVente);
		studio.setLoyerMensuel(loyerMensuel);
		studio.setChargesMensuel(chargesMensuel);
		studio.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
		studio.setEtatBien(EnumEtatBien.valueOf(etatBien));
		studio.setTransport(transport);
		studio.setAdapteHandicape(adapteHandicape);
		studio.setProximite(proximite);
		studio.setHonoraires(honoraires);
		studio.setDepotGarantie(depotGarantie);
		studio.setNbSallesBains(nbSallesBains);
		studio.setNbCaves(nbCaves);
		
		
		studio.setAscenseur(ascenseur);
		studio.setEtage(etage);
		studio.setAge(age);
		studio.setNbTerrasses(nbTerrasses);
		studio.setNbBalcons(nbBalcons);
		studio.setNbParkingInt(nbParkingInt);
		studio.setNbParkingExt(nbParkingExt);
		studio.setInterphone(interphone);
		studio.setDigicode(digicode);
		studio.setConsoEnergie(EnumConsEnergie.valueOf(consoEnergie));
		studio.setTypeEauChaude(EnumTypeEauChaude.valueOf(typeEauChaude));
		studio.setImpactConso(EnumImpactConso.valueOf(impactConso));
		studio.setNatureChauffage(EnumNatureChauffage
				.valueOf(natureChauffage));
		studio.setTypeChauffage(EnumTypeChauffage.valueOf(typeChauffage));
		studio.setMeuble(meuble);

		return studio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
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

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
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

	public int getNbChambres() {
		return nbChambres;
	}

	public void setNbChambres(int nbChambres) {
		this.nbChambres = nbChambres;
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

	public Boolean getInterphone() {
		return interphone;
	}

	public void setInterphone(Boolean interphone) {
		this.interphone = interphone;
	}

	public Boolean getDigicode() {
		return digicode;
	}

	public void setDigicode(Boolean digicode) {
		this.digicode = digicode;
	}

	public Boolean getGardien() {
		return gardien;
	}

	public void setGardien(Boolean gardien) {
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

	public Boolean getMeuble() {
		return meuble;
	}

	public void setMeuble(Boolean meuble) {
		this.meuble = meuble;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Boolean getAdapteHandicape() {
		return adapteHandicape;
	}

	public void setAdapteHandicape(Boolean adapteHandicape) {
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

	public Boolean getPiscine() {
		return piscine;
	}

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public double getPrixMinVente() {
		return prixMinVente;
	}

	public void setPrixMinVente(double prixMinVente) {
		this.prixMinVente = prixMinVente;
	}

	
}
