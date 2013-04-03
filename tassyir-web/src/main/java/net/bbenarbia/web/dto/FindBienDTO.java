package net.bbenarbia.web.dto;

import java.util.List;

import net.bbenarbia.domain.immobilier.BienImmobilier;

public class FindBienDTO {

	private String refBien;
	private Long departementBien;
	private String typeBien;
	private Integer nbPiecesMin;
	private Integer nbPiecesMax;
	private Double surfaceMin;
	private Double surfaceMax;
	private Double loyerMin;
	private Double loyerMax;

	List<BienImmobilier> listBiens;

	public String getRefBien() {
		return refBien;
	}

	public void setRefBien(String refBien) {
		this.refBien = refBien;
	}

	public Long getDepartementBien() {
		return departementBien;
	}

	public void setDepartementBien(Long departementBien) {
		this.departementBien = departementBien;
	}

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public Integer getNbPiecesMin() {
		return nbPiecesMin;
	}

	public void setNbPiecesMin(Integer nbPiecesMin) {
		this.nbPiecesMin = nbPiecesMin;
	}

	public Integer getNbPiecesMax() {
		return nbPiecesMax;
	}

	public void setNbPiecesMax(Integer nbPiecesMax) {
		this.nbPiecesMax = nbPiecesMax;
	}

	public Double getSurfaceMin() {
		return surfaceMin;
	}

	public void setSurfaceMin(Double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}

	public Double getSurfaceMax() {
		return surfaceMax;
	}

	public void setSurfaceMax(Double surfaceMax) {
		this.surfaceMax = surfaceMax;
	}

	public Double getLoyerMin() {
		return loyerMin;
	}

	public void setLoyerMin(Double loyerMin) {
		this.loyerMin = loyerMin;
	}

	public Double getLoyerMax() {
		return loyerMax;
	}

	public void setLoyerMax(Double loyerMax) {
		this.loyerMax = loyerMax;
	}

	public List<BienImmobilier> getListBiens() {
		return listBiens;
	}

	public void setListBiens(List<BienImmobilier> listBiens) {
		this.listBiens = listBiens;
	}

}
