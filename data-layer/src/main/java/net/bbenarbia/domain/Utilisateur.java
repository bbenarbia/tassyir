package net.bbenarbia.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.bbenarbia.domain.base.BenEntity;
import net.bbenarbia.domain.base.IDeletableEntity;
import net.bbenarbia.domain.enums.EnumRole;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * 
 * @author moad
 * @version 1.0
 */

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends BenEntity implements IDeletableEntity {

	private LocalDateTime dateSuppression;
	private LocalDateTime dateModification;
	private String nomUtilisateur = "";
	private Integer codeUtilisateur = 0;
	private String login = "";
	private String motDePasse = "";
	// private byte[] imageUtilisateur;
	private Boolean estVerrouille = false;
	private Boolean estConnecte = false;
	private Contact contact;
	private Boolean estSuperUser = false;
	private CategorieProfilUtilisateur categorieProfilUtilisateur;
	// private Set<Session> sessions = new HashSet<Session>();
	private Set<EnumRole> roles = new HashSet<EnumRole>();
	private String autorisations;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(name = "datemodification")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	public LocalDateTime getDateModification() {
		return dateModification;
	}

	public void setDateModification(LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}

	@Column(name = "datesuppression")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	public LocalDateTime getDateSuppression() {
		return dateSuppression;
	}

	public void setDateSuppression(LocalDateTime dateSuppression) {
		this.dateSuppression = dateSuppression;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public Integer getCodeUtilisateur() {
		return codeUtilisateur;
	}

	public void setCodeUtilisateur(Integer codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	// public byte[] getImageUtilisateur() {
	// return imageUtilisateur;
	// }
	//
	// public void setImageUtilisateur(byte[] imageUtilisateur) {
	// this.imageUtilisateur = imageUtilisateur;
	// }

	public Boolean getEstVerrouille() {
		return estVerrouille;
	}

	public void setEstVerrouille(Boolean estVerrouille) {
		this.estVerrouille = estVerrouille;
	}

	public Boolean getEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(Boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

	@OneToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "fk_contact")
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "fk_categorieprofilutilisateur")
	public CategorieProfilUtilisateur getCategorieProfilUtilisateur() {
		return categorieProfilUtilisateur;
	}

	public void setCategorieProfilUtilisateur(
			CategorieProfilUtilisateur categorieProfilUtilisateur) {
		this.categorieProfilUtilisateur = categorieProfilUtilisateur;
	}

	// @ManyToMany(mappedBy = "utilisateurs")
	// public Set<Session> getSessions() {
	// return sessions;
	// }
	//
	// public void setSessions(Set<Session> sessions) {
	// this.sessions = sessions;
	// }

	@Column(name = "enumrole")
	@Cascade(CascadeType.SAVE_UPDATE)
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "re_utilisateur_role", joinColumns = { @JoinColumn(name = "fk_utilisateur") })
	@Enumerated(EnumType.STRING)
	public Set<EnumRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<EnumRole> roles) {
		this.roles = roles;
	}

	public String getAutorisations() {
		return autorisations;
	}

	public void setAutorisations(String autorisations) {
		this.autorisations = autorisations;
	}

	@Transient
	public Collection<String> getAutorisationsAsList() {
		return autorisations == null ? new ArrayList<String>() : Arrays
				.asList(autorisations.split("\\|"));
	}

	public void setAutorisationsAsList(Collection<String> autorisations) {
		this.autorisations = StringUtils.join(autorisations, '|');
	}

	public Boolean getEstSuperUser() {
		return estSuperUser;
	}

	public void setEstSuperUser(Boolean estSuperUser) {
		this.estSuperUser = estSuperUser;
	}

}