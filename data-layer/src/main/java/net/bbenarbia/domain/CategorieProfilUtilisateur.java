package net.bbenarbia.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import net.bbenarbia.domain.base.BenEntity;
import net.bbenarbia.domain.base.IDeletableEntity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
//@SuppressWarnings("serial")
public class CategorieProfilUtilisateur extends BenEntity implements IDeletableEntity {

    private LocalDateTime dateSuppression;
    private String libelleCategorieProfilUtilisateur = "";
    private Boolean estSupprimable = false;
    private Set<Fonction> fonctions = new HashSet<Fonction>();
    private Set<DroitsUtilisateur> droitsUtilisateurs = new HashSet<DroitsUtilisateur>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "datesuppression")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    public LocalDateTime getDateSuppression() {
        return dateSuppression;
    }

    public void setDateSuppression(LocalDateTime dateSuppression) {
        this.dateSuppression = dateSuppression;
    }

    public String getLibelleCategorieProfilUtilisateur() {
        return libelleCategorieProfilUtilisateur;
    }

    public void setLibelleCategorieProfilUtilisateur(String libelleCategorieProfilUtilisateur) {
        this.libelleCategorieProfilUtilisateur = libelleCategorieProfilUtilisateur;
    }

    public Boolean getEstSupprimable() {
        return estSupprimable;
    }

    public void setEstSupprimable(Boolean estSupprimable) {
        this.estSupprimable = estSupprimable;
    }

    @ManyToMany
    @JoinTable(name = "re_categorieprofilutilisateur_fonction", joinColumns = @JoinColumn(name = "fk_categorieprofilutilisateur"), inverseJoinColumns = @JoinColumn(name = "fk_fonction"))
    @Cascade(CascadeType.SAVE_UPDATE)
    public Set<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(Set<Fonction> fonctions) {
        this.fonctions = fonctions;
    }

    @ManyToMany
    @JoinTable(name = "re_categorieprofilutilisateur_droitsutilisateur", joinColumns = @JoinColumn(name = "fk_categorieprofilutilisateur"), inverseJoinColumns = @JoinColumn(name = "fk_droitsutilisateur"))
    @Cascade(CascadeType.SAVE_UPDATE)
    public Set<DroitsUtilisateur> getDroitsUtilisateurs() {
        return droitsUtilisateurs;
    }

    public void setDroitsUtilisateurs(Set<DroitsUtilisateur> droitsUtilisateurs) {
        this.droitsUtilisateurs = droitsUtilisateurs;
    }
}

