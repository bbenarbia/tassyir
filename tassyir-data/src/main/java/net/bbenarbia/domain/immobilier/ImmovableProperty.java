package net.bbenarbia.domain.immobilier;

import java.util.List;

import javax.persistence.MappedSuperclass;

import net.bbenarbia.domain.Photo;
import net.bbenarbia.domain.base.NamedEntity;
import net.bbenarbia.domain.enums.EnumStatutProperty;


@MappedSuperclass
public class ImmovableProperty extends NamedEntity{

	private String reference;
	private String adresse;
	private String description;
	private double superficie;
	private EnumStatutProperty status;
	private double prixVente;
	private double prixMinVente;
	private double prixAchat;
	private List<Photo> photos;
	private double loyerMensuel;
	private double chargesMensuel;
	
	
	
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
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
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
	
	
}
