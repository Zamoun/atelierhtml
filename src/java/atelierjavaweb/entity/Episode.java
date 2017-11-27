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
@Table(name = "EPISODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episode.findAll", query = "SELECT e FROM Episode e")})
public class Episode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NUMEPISODE")
    private Integer numepisode;
    @Column(name = "TITRE")
    private String titre;
    @OneToMany(mappedBy = "episode")
    private Collection<Lien> lienCollection;
    @JoinColumn(name = "SAISON_ID", referencedColumnName = "ID")
    @ManyToOne
    private Saison saison;

    public Episode() {
    }

    public Episode(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumepisode() {
        return numepisode;
    }

    public void setNumepisode(Integer numepisode) {
        this.numepisode = numepisode;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlTransient
    public Collection<Lien> getLienCollection() {
        return lienCollection;
    }

    public void setLienCollection(Collection<Lien> lienCollection) {
        this.lienCollection = lienCollection;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
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
        if (!(object instanceof Episode)) {
            return false;
        }
        Episode other = (Episode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atelierjavaweb.entity.Episode[ id=" + id + " ]";
    }
    
}
