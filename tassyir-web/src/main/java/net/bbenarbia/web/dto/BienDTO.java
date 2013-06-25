package net.bbenarbia.web.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.bbenarbia.domain.enums.EnumConsEnergie;
import net.bbenarbia.domain.enums.EnumEtatBien;
import net.bbenarbia.domain.enums.EnumImpactConso;
import net.bbenarbia.domain.enums.EnumNatureChauffage;
import net.bbenarbia.domain.enums.EnumStatutProperty;
import net.bbenarbia.domain.enums.EnumTypeChauffage;
import net.bbenarbia.domain.enums.EnumTypeEauChaude;
import net.bbenarbia.domain.enums.EnumTypeOperation;
import net.bbenarbia.domain.immobilier.Photo;
import net.bbenarbia.domain.immobilier.subtype.Agricole;
import net.bbenarbia.domain.immobilier.subtype.Appartement;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;
import net.bbenarbia.domain.immobilier.subtype.Carcasse;
import net.bbenarbia.domain.immobilier.subtype.Commerce;
import net.bbenarbia.domain.immobilier.subtype.Maison;
import net.bbenarbia.domain.immobilier.subtype.Studio;
import net.bbenarbia.domain.immobilier.subtype.Terrain;
import net.bbenarbia.domain.immobilier.subtype.Vacances;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.multipart.MultipartFile;
/**
 * Le Bien DTO 
 * @author bbenarbia
 *
 */
/**
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
	
	private String shortDescription;

	private double superficie;
	
	private boolean validated;

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
	
	private String dateMiseAjour;
	
	private List<MultipartFile> files;
	
	private List<Photo> photos = new ArrayList<Photo>();
	
	private Boolean puit;
	
	private Boolean eauPotable;
	
	private Boolean gaz;

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
				appartement.getStatus(), appartement.getPrixVente(), appartement.getPrixMinVente(),
				appartement.getLoyerMensuel(), appartement.getChargesMensuel(),
				appartement.getTypeOperation().toString(), appartement
						.getEtatBien(), appartement.getEtage(),
				appartement.getNbPieces(), appartement.getNbChambres(),
				appartement.isAscenseur(), appartement.isCuisineEquipee(),
				null, appartement.getAge(), appartement.getTypeBien(),
				appartement.getNbTerrasses(), appartement.getNbBalcons(),
				appartement.getNbParkingInt(), appartement.getNbParkingExt(),
				appartement.isInterphone(), appartement.isDigicode(),
				appartement.isGardien(), appartement.getConsoEnergie()
						, appartement.getTypeEauChaude(),
				appartement.getImpactConso(), appartement
						.getNatureChauffage(), appartement
						.getTypeChauffage(), appartement.isMeuble(),
				appartement.getTransport(), appartement.isAdapteHandicape(),
				appartement.getProximite(), appartement.getHonoraires(),
				appartement.getDepotGarantie(), appartement.getNbSallesBains(),
				appartement.getNbCaves(), false, appartement.getPhotos(), appartement.getDateMiseAjour(), appartement.isValidated(), false, appartement.isEauPotable(), appartement.isGaz());
	}
	
	
	
	public BienDTO(Terrain terrain) {
		this(terrain.getId(), terrain.getName(), terrain
				.getReference(), terrain.getAdresse(),
				terrain.getDepartement().getCodePostal(), terrain
						.getDepartement().getName(), terrain.getDepartement()
						.getReference(), terrain.getDescription(),
				terrain.getSuperficie(),
				terrain.getStatus(), terrain.getPrixVente(), terrain.getPrixMinVente(),
				terrain.getLoyerMensuel(), terrain.getChargesMensuel(),
				terrain.getTypeOperation().toString(), terrain
						.getEtatBien(), null,
				0, 0,
				false, false,
				false, 0, terrain.getTypeBien(),
				0, 0,
				0, 0,
				false, false,
				false,null
						, null,
				null, null, null, false,
				terrain.getTransport(), terrain.isAdapteHandicape(),
				terrain.getProximite(), terrain.getHonoraires(),
				terrain.getDepotGarantie(), terrain.getNbSallesBains(),
				terrain.getNbCaves(), false, terrain.getPhotos(), terrain.getDateMiseAjour(), terrain.isValidated(), false, terrain.isEauPotable(), terrain.isGaz());
	}
	
	public BienDTO(Vacances vacances) {
		this(vacances.getId(), vacances.getName(), vacances
				.getReference(), vacances.getAdresse(),
				vacances.getDepartement().getCodePostal(), vacances
						.getDepartement().getName(), vacances.getDepartement()
						.getReference(), vacances.getDescription(),
				vacances.getSuperficie(),
				vacances.getStatus(), vacances.getPrixVente(), vacances.getPrixMinVente(),
				vacances.getLoyerMensuel(), vacances.getChargesMensuel(),
				vacances.getTypeOperation().toString(), vacances
						.getEtatBien(), null,
				0, 0,
				false, false,
				false, 0, vacances.getTypeBien(),
				0, 0,
				0, 0,
				false, false,
				false,null
						, null,
				null, null, null, false,
				vacances.getTransport(), vacances.isAdapteHandicape(),
				vacances.getProximite(), vacances.getHonoraires(),
				vacances.getDepotGarantie(), vacances.getNbSallesBains(),
				vacances.getNbCaves(), false, vacances.getPhotos(), vacances.getDateMiseAjour(), vacances.isValidated(), false, vacances.isEauPotable(), vacances.isGaz());
	}
	
	public BienDTO(Agricole agricole) {
		this(agricole.getId(), agricole.getName(), agricole
				.getReference(), agricole.getAdresse(),
				agricole.getDepartement().getCodePostal(), agricole
						.getDepartement().getName(), agricole.getDepartement()
						.getReference(), agricole.getDescription(),
				agricole.getSuperficie(),
				agricole.getStatus(), agricole.getPrixVente(), agricole.getPrixMinVente(),
				agricole.getLoyerMensuel(), agricole.getChargesMensuel(),
				agricole.getTypeOperation().toString(), agricole
						.getEtatBien(), null,
				0, 0,
				false, false,
				false, 0, agricole.getTypeBien(),
				0, 0,
				0, 0,
				false, false,
				false,null
						, null,
				null, null, null, false,
				agricole.getTransport(), agricole.isAdapteHandicape(),
				agricole.getProximite(), agricole.getHonoraires(),
				agricole.getDepotGarantie(), agricole.getNbSallesBains(),
				agricole.getNbCaves(), false, agricole.getPhotos(), agricole.getDateMiseAjour(), agricole.isValidated(), agricole.isPuit(), agricole.isEauPotable(), agricole.isGaz());
	}
	
	public BienDTO(Carcasse carcasse) {
		this(carcasse.getId(), carcasse.getName(), carcasse.getReference(), carcasse
				.getAdresse(),
				carcasse.getDepartement().getCodePostal(), carcasse.getDepartement().getName()
						, carcasse.getDepartement().getReference(),
				carcasse.getDescription(), carcasse.getSuperficie(), carcasse
						.getStatus(), carcasse.getPrixVente(), carcasse.getPrixMinVente(), carcasse
						.getLoyerMensuel(), carcasse.getChargesMensuel(), carcasse
						.getTypeOperation().toString(), carcasse.getEtatBien()
						, null, 0, 0, null, false,
				false, 0, carcasse.getTypeBien(),
				0,0,0, 0, false, false, null, null, null, null
						, null,
						null, false, carcasse
						.getTransport(), carcasse.isAdapteHandicape(), carcasse
						.getProximite(), carcasse.getHonoraires(), carcasse
						.getDepotGarantie(), carcasse.getNbSallesBains(), carcasse
						.getNbCaves(), false, carcasse.getPhotos(), carcasse.getDateMiseAjour(), carcasse.isValidated(), false, carcasse.isEauPotable(), carcasse.isGaz());
	}
	
	public BienDTO(Commerce commerce) {
		this(commerce.getId(), commerce.getName(), commerce.getReference(), commerce
				.getAdresse(),
				commerce.getDepartement().getCodePostal(), commerce.getDepartement().getName()
						, commerce.getDepartement().getReference(),
				commerce.getDescription(), commerce.getSuperficie(), commerce
						.getStatus(), commerce.getPrixVente(), commerce.getPrixMinVente(), commerce
						.getLoyerMensuel(), commerce.getChargesMensuel(), commerce
						.getTypeOperation().toString(), commerce.getEtatBien()
						, null, 0, 0, null, false,
				false, commerce.getAge(), commerce.getTypeBien(),
				0, 0, 0, 0, false, false, null, null, null, null, null,
				null, false, commerce
						.getTransport(), commerce.isAdapteHandicape(), commerce
						.getProximite(), commerce.getHonoraires(), commerce
						.getDepotGarantie(), commerce.getNbSallesBains(), commerce
						.getNbCaves(),false, commerce.getPhotos(), commerce.getDateMiseAjour(), commerce.isValidated(), false, commerce.isEauPotable(), commerce.isGaz());
	}
	
	
	public BienDTO(Maison maison) {
		this(maison.getId(), maison.getName(), maison.getReference(), maison
				.getAdresse(),
				maison.getDepartement().getCodePostal(), maison.getDepartement().getName()
						, maison.getDepartement().getReference(),
				maison.getDescription(), maison.getSuperficie(), maison
						.getStatus(), maison.getPrixVente(), maison.getPrixMinVente(), maison
						.getLoyerMensuel(), maison.getChargesMensuel(), maison
						.getTypeOperation().toString(), maison.getEtatBien()
						, null, maison.getNbPieces(), maison
						.getNbChambres(), null, maison.isCuisineEquipee(),
				maison.isJardin(), maison.getAge(), maison.getTypeBien(),
				maison.getNbTerrasses(), maison.getNbBalcons(), maison
						.getNbParkingInt(), maison.getNbParkingExt(), maison
						.isInterphone(), maison.isDigicode(), null, maison
						.getConsoEnergie(), maison
						.getTypeEauChaude(), maison.getImpactConso()
						, maison.getNatureChauffage(),
				maison.getTypeChauffage(), maison.isMeuble(), maison
						.getTransport(), maison.isAdapteHandicape(), maison
						.getProximite(), maison.getHonoraires(), maison
						.getDepotGarantie(), maison.getNbSallesBains(), maison
						.getNbCaves(), maison.isPiscine(), maison.getPhotos(), maison.getDateMiseAjour(), maison.isValidated(), false, maison.isEauPotable(), maison.isGaz());
	}

	public BienDTO(Studio studio) {
		this(studio.getId(), studio.getName(), studio.getReference(), studio
				.getAdresse(),
				studio.getDepartement().getCodePostal(), studio.getDepartement()
						.getName(), studio.getDepartement().getReference(),
				studio.getDescription(), studio.getSuperficie(), studio
						.getStatus(), studio.getPrixVente(), studio.getPrixMinVente(), studio
						.getLoyerMensuel(), studio.getChargesMensuel(), studio
						.getTypeOperation().toString(), studio.getEtatBien(), studio.getEtage(), 0, 0, studio
						.isAscenseur(), null, null, studio.getAge(), studio
						.getTypeBien(), studio.getNbTerrasses(), studio
						.getNbBalcons(), studio.getNbParkingInt(), studio
						.getNbParkingExt(), studio.isInterphone(), studio
						.isDigicode(), studio.isGardien(), studio
						.getConsoEnergie(), studio
						.getTypeEauChaude(), studio.getImpactConso()
						, studio.getNatureChauffage(),
				studio.getTypeChauffage(), studio.isMeuble(), studio
						.getTransport(), studio.isAdapteHandicape(), studio
						.getProximite(), studio.getHonoraires(), studio
						.getDepotGarantie(), studio.getNbSallesBains(), studio
						.getNbCaves(), false, studio.getPhotos(), studio.getDateMiseAjour(), studio.isValidated(), false, studio.isEauPotable(), studio.isGaz());
	}

	public BienDTO(Long id, String name, String reference, String adresse,
			String codePostal, String ville, String departement,
			String description, double superficie, EnumStatutProperty status,
			double prixVente, double prixVenteMin,double loyerMensuel, double chargesMensuel,
			String typeOperation, EnumEtatBien etatBien, String etage, int nbPieces,
			int nbChambres, Boolean ascenseur, Boolean cuisineEquipee,
			Boolean jardin, int age, String typeBien, int nbTerrasses,
			int nbBalcons, int nbParkingInt, int nbParkingExt,
			Boolean interphone, Boolean digicode, Boolean gardien,
			EnumConsEnergie consoEnergie, EnumTypeEauChaude typeEauChaude, EnumImpactConso impactConso,
			EnumNatureChauffage natureChauffage, EnumTypeChauffage typeChauffage, Boolean meuble,
			String transport, Boolean adapteHandicape, String proximite,
			double honoraires, double depotGarantie, int nbSallesBains,
			int nbCaves, Boolean piscine, Set<Photo> photos, LocalDateTime dateMiseAjour, boolean validated,Boolean puit,Boolean eauPotable,Boolean gaz) {

		super();
		this.name = name;
		this.id = id;
		this.reference = reference;
		this.departement = departement;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.description = description;
		this.shortDescription= description.substring(0, Math.min(description.length(), 200)) ;
		this.superficie = superficie;
		if(status != null)
			this.status = status.toString();
		this.prixVente = prixVente;
		this.prixMinVente = prixVenteMin;
		this.loyerMensuel = loyerMensuel;
		this.chargesMensuel = chargesMensuel;
		this.typeOperation = typeOperation;
		if(etatBien != null)
			this.etatBien = etatBien.toString();
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
		if(consoEnergie != null)
			this.consoEnergie = consoEnergie.toString();
		if(typeEauChaude != null)
			this.typeEauChaude = typeEauChaude.toString();
		if(impactConso != null)
			this.impactConso = impactConso.toString();
		if(natureChauffage != null)
			this.natureChauffage = natureChauffage.toString();
		if(typeChauffage != null)
			this.typeChauffage = typeChauffage.toString();
		this.meuble = meuble;
		this.transport = transport;
		this.adapteHandicape = adapteHandicape;
		this.proximite = proximite;
		this.honoraires = honoraires;
		this.depotGarantie = depotGarantie;
		this.nbSallesBains = nbSallesBains;
		this.nbCaves = nbCaves;
		this.piscine = piscine;
		this.validated = validated;
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy  hh:mm");
		this.dateMiseAjour = dateMiseAjour.toString(fmt) ;
		this.photos.addAll(photos);
		this.puit = puit;
		this.eauPotable = eauPotable;
		this.gaz = gaz;
		}

	public Maison updateMaison(Maison maison) {

		//	Update the departement not complete
		maison = (Maison) updateBien(maison);
		
//		maison.setName(name);
//		maison.setReference(reference);
//		maison.setAdresse(adresse);
//		maison.setDescription(description);
//		maison.setSuperficie(superficie);
//		maison.setStatus(EnumStatutProperty.valueOf(status));
//		maison.setPrixVente(prixVente);
//		maison.setPrixMinVente(prixMinVente);
//		maison.setLoyerMensuel(loyerMensuel);
//		maison.setChargesMensuel(chargesMensuel);
//		maison.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		maison.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		maison.setTransport(transport);
//		maison.setAdapteHandicape(false);		
//		maison.setProximite(proximite);
//		maison.setHonoraires(honoraires);
//		maison.setDepotGarantie(depotGarantie);
//		maison.setNbSallesBains(nbSallesBains);
//		maison.setDateMiseAjour( new LocalDateTime());
		
		
		maison.setNbCaves(nbCaves);
		maison.setValidated(validated);
		maison.setNbPieces(nbPieces);
		maison.setNbChambres(nbChambres);
		
		maison.setAdapteHandicape(false);
		if(adapteHandicape!= null && adapteHandicape){
			maison.setAdapteHandicape(true);
		}
		maison.setCuisineEquipee(false);
		if(cuisineEquipee!= null && cuisineEquipee){
			maison.setCuisineEquipee(true);
		}
		maison.setInterphone(false);
		if(interphone!= null && interphone){
			maison.setInterphone(true);
		}		
		maison.setDigicode(false);
		if(digicode!= null && digicode){
			maison.setDigicode(true);
		}
//		maison.setConsoEnergie(null);
//		if(consoEnergie!= null){
//			maison.setConsoEnergie(EnumConsEnergie.valueOf(consoEnergie));
//		}
		maison.setTypeEauChaude(null);
		if(typeEauChaude!= null){
			maison.setTypeEauChaude(EnumTypeEauChaude.valueOf(typeEauChaude));
		}
//		maison.setImpactConso(null);
//		if(impactConso!= null){
//			maison.setImpactConso(EnumImpactConso.valueOf(impactConso));
//		}
		maison.setTypeChauffage(null);
		if(typeChauffage!= null){
			maison.setTypeChauffage(EnumTypeChauffage.valueOf(typeChauffage));
		}
		maison.setNatureChauffage(null);
		if(natureChauffage!= null){
			maison.setNatureChauffage(EnumNatureChauffage
					.valueOf(natureChauffage));
		}
		maison.setMeuble(false);
		if(meuble!= null && meuble){
			maison.setMeuble(true);
		}
		maison.setJardin(false);
		if(jardin!= null && jardin){
			maison.setJardin(true);
		}
		maison.setPiscine(false);
		if(piscine!= null && piscine){
			maison.setPiscine(true);
		}
		
		maison.setAge(age);
		maison.setNbTerrasses(nbTerrasses);
		maison.setNbBalcons(nbBalcons);
		maison.setNbParkingInt(nbParkingInt);
		maison.setNbParkingExt(nbParkingExt);
		
		

		return maison;
	}

	public Agricole updateAgricole(Agricole agricole) {

//		Update the agricole not complete
		
		agricole = (Agricole) updateBien(agricole);
		
//		agricole.setName(name);
//		agricole.setReference(reference);
//		agricole.setAdresse(adresse);
//		agricole.setDescription(description);
//		agricole.setSuperficie(superficie);
//		agricole.setStatus(EnumStatutProperty.valueOf(status));
//		agricole.setPrixVente(prixVente);
//		agricole.setPrixMinVente(prixMinVente);
//		agricole.setLoyerMensuel(loyerMensuel);
//		agricole.setChargesMensuel(chargesMensuel);
//		agricole.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		agricole.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		agricole.setTransport(transport);
//		agricole.setAdapteHandicape(false);		
//		agricole.setProximite(proximite);
//		agricole.setHonoraires(honoraires);
//		agricole.setDepotGarantie(depotGarantie);
//		agricole.setNbSallesBains(nbSallesBains);
//		agricole.setNbCaves(nbCaves);
//		agricole.setValidated(validated);
//		
//		agricole.setDateMiseAjour( new LocalDateTime());
		return agricole;
	}
	
	public Appartement updateAppartement(Appartement appartement) {

//		Update the departement not complete
		
		appartement = (Appartement) updateBien(appartement);
		
		
//		appartement.setName(name);
//		appartement.setReference(reference);
//		appartement.setAdresse(adresse);
//		appartement.setDescription(description);
//		appartement.setSuperficie(superficie);
//		appartement.setStatus(EnumStatutProperty.valueOf(status));
//		appartement.setPrixVente(prixVente);
//		appartement.setPrixMinVente(prixMinVente);
//		appartement.setLoyerMensuel(loyerMensuel);
//		appartement.setChargesMensuel(chargesMensuel);
//		appartement.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		appartement.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		appartement.setTransport(transport);
//		appartement.setAdapteHandicape(false);		
//		appartement.setProximite(proximite);
//		appartement.setHonoraires(honoraires);
//		appartement.setDepotGarantie(depotGarantie);
//		appartement.setNbSallesBains(nbSallesBains);
//		appartement.setNbCaves(nbCaves);
//		appartement.setValidated(validated);
//		appartement.setDateMiseAjour( new LocalDateTime());
		
		appartement.setNbPieces(nbPieces);
		appartement.setNbChambres(nbChambres);
		
		appartement.setAdapteHandicape(false);
		if(adapteHandicape!= null && adapteHandicape){
			appartement.setAdapteHandicape(true);
		}
		appartement.setCuisineEquipee(false);
		if(cuisineEquipee!= null && cuisineEquipee){
			appartement.setCuisineEquipee(true);
		}
		appartement.setAscenseur(false);
		if(ascenseur!= null && ascenseur){
			appartement.setAscenseur(true);
		}		
		appartement.setInterphone(false);
		if(interphone!= null && interphone){
			appartement.setInterphone(true);
		}		
		appartement.setDigicode(false);
		if(digicode!= null && digicode){
			appartement.setDigicode(true);
		}
		
//		appartement.setConsoEnergie(null);
//		if(consoEnergie!= null){
//			appartement.setConsoEnergie(EnumConsEnergie.valueOf(consoEnergie));
//		}
		appartement.setTypeEauChaude(null);
		if(typeEauChaude!= null){
			appartement.setTypeEauChaude(EnumTypeEauChaude.valueOf(typeEauChaude));
		}
//		appartement.setImpactConso(null);
//		if(impactConso!= null){
//			appartement.setImpactConso(EnumImpactConso.valueOf(impactConso));
//		}
		appartement.setTypeChauffage(null);
		if(typeChauffage!= null){
			appartement.setTypeChauffage(EnumTypeChauffage.valueOf(typeChauffage));
		}
		appartement.setNatureChauffage(null);
		if(natureChauffage!= null){
			appartement.setNatureChauffage(EnumNatureChauffage
					.valueOf(natureChauffage));
		}
		appartement.setMeuble(false);
		if(meuble!= null && meuble){
			appartement.setMeuble(true);
		}
		appartement.setEtage(etage);
		appartement.setAge(age);
		appartement.setNbTerrasses(nbTerrasses);
		appartement.setNbBalcons(nbBalcons);
		appartement.setNbParkingInt(nbParkingInt);
		appartement.setNbParkingExt(nbParkingExt);
		
		return appartement;
	}
	
	
	public BienImmobilier updateBien(BienImmobilier bien) {
		
//		Update the bien not complete
		bien.setName(name);
//		bien.setReference(reference);
		bien.setAdresse(adresse);
		bien.setDescription(description);
		bien.setSuperficie(superficie);
		if(status != null){
			bien.setStatus(EnumStatutProperty.valueOf(status));
		}
		bien.setPrixVente(prixVente);
		bien.setPrixMinVente(prixMinVente);
		bien.setLoyerMensuel(loyerMensuel);
		bien.setChargesMensuel(chargesMensuel);
		if(etatBien != null){
			bien.setEtatBien(EnumEtatBien.valueOf(etatBien));
		}
		if(typeOperation != null){
			bien.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
		}
		bien.setTransport(transport);
		bien.setAdapteHandicape(false);		
		bien.setProximite(proximite);
		bien.setHonoraires(honoraires);
		bien.setDepotGarantie(depotGarantie);
		bien.setNbSallesBains(nbSallesBains);
		bien.setNbCaves(nbCaves);
		bien.setValidated(validated);
		bien.setDateMiseAjour( new LocalDateTime());
		return bien;
	}
	
	public Carcasse updateCarcasse(Carcasse carcasse) {

//		Update the carcasse not complete
		carcasse = (Carcasse) updateBien(carcasse);
//		carcasse.setName(name);
//		carcasse.setReference(reference);
//		carcasse.setAdresse(adresse);
//		carcasse.setDescription(description);
//		carcasse.setSuperficie(superficie);
//		carcasse.setStatus(EnumStatutProperty.valueOf(status));
//		carcasse.setPrixVente(prixVente);
//		carcasse.setPrixMinVente(prixMinVente);
//		carcasse.setLoyerMensuel(loyerMensuel);
//		carcasse.setChargesMensuel(chargesMensuel);
//		carcasse.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		carcasse.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		carcasse.setTransport(transport);
//		carcasse.setAdapteHandicape(false);		
//		carcasse.setProximite(proximite);
//		carcasse.setHonoraires(honoraires);
//		carcasse.setDepotGarantie(depotGarantie);
//		carcasse.setNbSallesBains(nbSallesBains);
//		carcasse.setNbCaves(nbCaves);
//		carcasse.setValidated(validated);
//		carcasse.setDateMiseAjour( new LocalDateTime());
		return carcasse;
	}
	
	
	public Vacances updateVacances(Vacances vacances) {

//		Update the vacances not complete
//		vacances.setName(name);
//		vacances.setReference(reference);
//		vacances.setAdresse(adresse);
//		vacances.setDescription(description);
//		vacances.setSuperficie(superficie);
//		vacances.setStatus(EnumStatutProperty.valueOf(status));
//		vacances.setPrixVente(prixVente);
//		vacances.setPrixMinVente(prixMinVente);
//		vacances.setLoyerMensuel(loyerMensuel);
//		vacances.setChargesMensuel(chargesMensuel);
//		vacances.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		vacances.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		vacances.setTransport(transport);
//		vacances.setAdapteHandicape(false);		
//		vacances.setProximite(proximite);
//		vacances.setHonoraires(honoraires);
//		vacances.setDepotGarantie(depotGarantie);
//		vacances.setNbSallesBains(nbSallesBains);
//		vacances.setNbCaves(nbCaves);
//		vacances.setValidated(validated);
//		vacances.setDateMiseAjour( new LocalDateTime());
		vacances = (Vacances) updateBien(vacances);
		return vacances;
	}
	
	public Terrain updateTerrain(Terrain terrain) {

//		Update the Terrain not complete
//		terrain.setName(name);
//		terrain.setReference(reference);
//		terrain.setAdresse(adresse);
//		terrain.setDescription(description);
//		terrain.setSuperficie(superficie);
//		terrain.setStatus(EnumStatutProperty.valueOf(status));
//		terrain.setPrixVente(prixVente);
//		terrain.setPrixMinVente(prixMinVente);
//		terrain.setLoyerMensuel(loyerMensuel);
//		terrain.setChargesMensuel(chargesMensuel);
//		terrain.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		terrain.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		terrain.setTransport(transport);
//		terrain.setAdapteHandicape(false);		
//		terrain.setProximite(proximite);
//		terrain.setHonoraires(honoraires);
//		terrain.setDepotGarantie(depotGarantie);
//		terrain.setNbSallesBains(nbSallesBains);
//		terrain.setNbCaves(nbCaves);
//		terrain.setValidated(validated);
//		terrain.setAdapteHandicape(false);
//		terrain.setDateMiseAjour( new LocalDateTime());
		terrain = (Terrain) updateBien(terrain);
		return terrain;
	}
	
	public Commerce updateCommerce(Commerce commerce) {

//		Update the commerce not complete
//		commerce.setName(name);
//		commerce.setReference(reference);
//		commerce.setAdresse(adresse);
//		commerce.setDescription(description);
//		commerce.setSuperficie(superficie);
//		commerce.setStatus(EnumStatutProperty.valueOf(status));
//		commerce.setPrixVente(prixVente);
//		commerce.setPrixMinVente(prixMinVente);
//		commerce.setLoyerMensuel(loyerMensuel);
//		commerce.setChargesMensuel(chargesMensuel);
//		commerce.setTypeOperation(EnumTypeOperation.valueOf(typeOperation));
//		commerce.setEtatBien(EnumEtatBien.valueOf(etatBien));
//		commerce.setTransport(transport);
//		commerce.setAdapteHandicape(false);		
//		commerce.setProximite(proximite);
//		commerce.setHonoraires(honoraires);
//		commerce.setDepotGarantie(depotGarantie);
//		commerce.setNbSallesBains(nbSallesBains);
//		commerce.setNbCaves(nbCaves);
//		commerce.setValidated(validated);		
//		commerce.setAdapteHandicape(false);
//		commerce.setDateMiseAjour( new LocalDateTime());
		commerce = (Commerce) updateBien(commerce);
		commerce.setAge(age);
		
		
		return commerce;
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

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDateMiseAjour() {
		return dateMiseAjour;
	}

	public void setDateMiseAjour(String dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public Boolean getPuit() {
		return puit;
	}

	public void setPuit(Boolean puit) {
		this.puit = puit;
	}

	public Boolean getEauPotable() {
		return eauPotable;
	}

	public void setEauPotable(Boolean eauPotable) {
		this.eauPotable = eauPotable;
	}

	public Boolean getGaz() {
		return gaz;
	}

	public void setGaz(Boolean gaz) {
		this.gaz = gaz;
	}

	
}
