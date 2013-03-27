package net.bbenarbia.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.bbenarbia.domain.base.NamedEntity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "user_categories")
public class UserCategory extends NamedEntity {


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_categories_roles", 
	joinColumns = @JoinColumn(name = "id_catgory"), 
	inverseJoinColumns = @JoinColumn(name = "id_role"))
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Role> roles = new HashSet<Role>();


//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "re_categorieUtilisateur_fonctions", joinColumns = @JoinColumn(name = "fk_categorieutilisateur"), inverseJoinColumns = @JoinColumn(name = "fk_fonction"))
//	@Cascade(CascadeType.SAVE_UPDATE)
//	private Set<Fonction> fonctions = new HashSet<Fonction>();

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "re_categorieUtilisateur_droits", joinColumns = @JoinColumn(name = "fk_categorieUtilisateur"), inverseJoinColumns = @JoinColumn(name = "fk_droitsutilisateur"))
//	@Cascade(CascadeType.SAVE_UPDATE)
//	private Set<UserDroit> droitsUtilisateurs = new HashSet<UserDroit>();

//	public Set<Fonction> getFonctions() {
//		return fonctions;
//	}
//
//	public void setFonctions(Set<Fonction> fonctions) {
//		this.fonctions = fonctions;
//	}

//	public Set<UserDroit> getDroitsUtilisateurs() {
//		return droitsUtilisateurs;
//	}
//
//	public void setDroitsUtilisateurs(Set<UserDroit> droitsUtilisateurs) {
//		this.droitsUtilisateurs = droitsUtilisateurs;
//	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


}
