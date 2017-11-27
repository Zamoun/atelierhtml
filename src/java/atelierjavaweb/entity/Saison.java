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
@Table(name = "SAISON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saison.findAll", query = "SELECT s FROM Saison s")})
public class Saison implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NUMSAISON")
    private Integer numsaison;
    @OneToMany(mappedBy = "saison")
    private Collection<Episode> episodeCollection;
    @JoinColumn(name = "SERIE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Serie serie;

    public Saison() {
    }

    public Saison(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumsaison() {
        return numsaison;
    }

    public void setNumsaison(Integer numsaison) {
        this.numsaison = numsaison;
    }

    @XmlTransient
    public Collection<Episode> getEpisodeCollection() {
        return episodeCollection;
    }

    public void setEpisodeCollection(Collection<Episode> episodeCollection) {
        this.episodeCollection = episodeCollection;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
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
        if (!(object instanceof Saison)) {
            return false;
        }
        Saison other = (Saison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "atelierjavaweb.entity.Saison[ id=" + id + " ]";
    }
    
}
