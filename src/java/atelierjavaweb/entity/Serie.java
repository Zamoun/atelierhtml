/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atelierjavaweb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "SERIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s")})
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SYNOPSIS")
    private String synopsis;
    @Column(name = "TITRE")
    private String titre;
    @ManyToMany(mappedBy = "serieCollection")
    private Collection<Pays> paysCollection;
    @ManyToMany(mappedBy = "serieCollection")
    private Collection<Personne> personneCollection;
    @ManyToMany(mappedBy = "serieCollection1")
    private Collection<Personne> personneCollection1;
    @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Genre genre;
    @OneToMany(mappedBy = "serie")
    private Collection<Saison> saisonCollection;

    public Serie() {
    }

    public Serie(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlTransient
    public Collection<Pays> getPaysCollection() {
        return paysCollection;
    }

    public void setPaysCollection(Collection<Pays> paysCollection) {
        this.paysCollection = paysCollection;
    }

    @XmlTransient
    public Collection<Personne> getPersonneCollection() {
        return personneCollection;
    }

    public void setPersonneCollection(Collection<Personne> personneCollection) {
        this.personneCollection = personneCollection;
    }

    @XmlTransient
    public Collection<Personne> getPersonneCollection1() {
        return personneCollection1;
    }

    public void setPersonneCollection1(Collection<Personne> personneCollection1) {
        this.personneCollection1 = personneCollection1;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @XmlTransient
    public Collection<Saison> getSaisonCollection() {
        return saisonCollection;
    }

    public void setSaisonCollection(Collection<Saison> saisonCollection) {
        this.saisonCollection = saisonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atelierjavaweb.entity.Serie[ id=" + id + " ]";
    }
    
}
