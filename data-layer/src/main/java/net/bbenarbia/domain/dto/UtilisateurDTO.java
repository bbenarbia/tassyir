package net.bbenarbia.domain.dto;

public class UtilisateurDTO {

	private String nomUtilisateur = "";
	private Integer codeUtilisateur = 0;

    public UtilisateurDTO(String nomUtilisateur, Integer codeUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.codeUtilisateur = codeUtilisateur;
    }

    public Integer getCodeUtilisateur() {
        return codeUtilisateur;
    }

    public void setCodeUtilisateur(Integer codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

}
