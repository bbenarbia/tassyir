package net.bbenarbia.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;

import net.bbenarbia.domain.base.BaseUser;
import net.bbenarbia.domain.base.Contact;
import net.bbenarbia.domain.enums.EnumTypeUser;
import net.bbenarbia.domain.immobilier.subtype.BienImmobilier;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name = "users")
public class User extends BaseUser {

	@Embedded
	private Contact contact;

	@Column(name = "photo")
	private String photo;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeUser typeUser;

	
	@OneToMany(mappedBy = "proprietaire", cascade = {
			javax.persistence.CascadeType.PERSIST,
			javax.persistence.CascadeType.MERGE })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<BienImmobilier> biens = new HashSet<BienImmobilier>(0);

	
	@ManyToMany(fetch=FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
	@JoinTable(name = "biens_favorites", joinColumns = { @JoinColumn(name = "id_user") },
	inverseJoinColumns = { @JoinColumn(name = "id_bien") })
	private Set<BienImmobilier> favorites = new HashSet<BienImmobilier>(0);
	
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "fk_categorieutilisateur")
	private UserCategory userCategory;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	@Cascade(CascadeType.PERSIST)
	private Set<Role> roles = new HashSet<Role>();

	@Column(name="activationUrl")
	private String activationUrl; 
	
	@Column(name = "dateMiseAjour", nullable = false)
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
	private LocalDateTime dateMiseAjour;
	
	
	
	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	@Transient
	public Set<Role> getGroupsAuthorities() {
		Set<Role> roles = new HashSet<Role>();
		if (this.userCategory != null) {
			roles.addAll(userCategory.getRoles());
		}
		return roles;
	}

	public void setRolesInternal(Set<Role> roles) {
		this.roles = roles;
	}

	protected Set<Role> getRolesInternal() {
		if (this.roles == null) {
			this.roles = new HashSet<Role>();
		}
		return this.roles;
	}

	@XmlElement
	public List<Role> getRoles() {
		List<Role> sortedSpecs = new ArrayList<Role>(getRolesInternal());
		PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name",
				true, true));
		return Collections.unmodifiableList(sortedSpecs);
	}

	public int getNrOfRoles() {
		return getRolesInternal().size();
	}

	public void addRole(Role role) {
		getRolesInternal().add(role);
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public Set<BienImmobilier> getBiens() {
		return biens;
	}

	public void setBiens(Set<BienImmobilier> biens) {
		this.biens = biens;
	}

	public EnumTypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(EnumTypeUser typeUser) {
		this.typeUser = typeUser;
	}

	public String getActivationUrl() {
		return activationUrl;
	}

	public void setActivationUrl(String activationUrl) {
		this.activationUrl = activationUrl;
	}

	public Set<BienImmobilier> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<BienImmobilier> favorites) {
		this.favorites = favorites;
	}

	public LocalDateTime getDateMiseAjour() {
		return dateMiseAjour;
	}

	public void setDateMiseAjour(LocalDateTime dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}
	
	

}
