/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity
@Table(name = "tp_indicateur_performance")
public class IndicateurPerformance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", length = 45, nullable = false)
    private String libelle;

    @Column(name = "nature", length = 45, nullable = false)
    private String nature;

    @Column(name = "valeur", length = 45, nullable = false)
    private String valeur;

    @OneToMany(mappedBy = "indicateurPerformance")
    private List<Programme> programmes = new ArrayList<Programme>();

    @OneToMany(mappedBy = "indicateurPerformance")
    private List<Projet> projets = new ArrayList<Projet>();

    @OneToMany(mappedBy = "indicateurPerformance")
    private List<Livrable> livrables = new ArrayList<Livrable>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicateurPerformance")
    private List<IndicateurQualitatif> indicateurQualitatifs = new ArrayList<IndicateurQualitatif>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "indicateurPerformance")
    private List<IndicateurQuantitatif> indicateurQuantitatifs = new ArrayList<IndicateurQuantitatif>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof IndicateurPerformance)) {
            return false;
        }
        IndicateurPerformance other = (IndicateurPerformance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.tp.jpa.IndicateurPerformance[ id=" + id + " ]";
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the nature
     */
    public String getNature() {
        return nature;
    }

    /**
     * @param nature the nature to set
     */
    public void setNature(String nature) {
        this.nature = nature;
    }

    /**
     * @return the valeur
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    /**
     * @return the programmes
     */
    public List<Programme> getProgrammes() {
        return programmes;
    }

    /**
     * @param programmes the programmes to set
     */
    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

    /**
     * @return the projets
     */
    public List<Projet> getProjets() {
        return projets;
    }

    /**
     * @param projets the projets to set
     */
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    /**
     * @return the livrables
     */
    public List<Livrable> getLivrables() {
        return livrables;
    }

    /**
     * @param livrables the livrables to set
     */
    public void setLivrables(List<Livrable> livrables) {
        this.livrables = livrables;
    }

    /**
     * @return the indicateurQualitatifs
     */
    public List<IndicateurQualitatif> getIndicateurQualitatifs() {
        return indicateurQualitatifs;
    }

    /**
     * @param indicateurQualitatifs the indicateurQualitatifs to set
     */
    public void setIndicateurQualitatifs(List<IndicateurQualitatif> indicateurQualitatifs) {
        this.indicateurQualitatifs = indicateurQualitatifs;
    }

    /**
     * @return the indicateurQuantitatifs
     */
    public List<IndicateurQuantitatif> getIndicateurQuantitatifs() {
        return indicateurQuantitatifs;
    }

    /**
     * @param indicateurQuantitatifs the indicateurQuantitatifs to set
     */
    public void setIndicateurQuantitatifs(List<IndicateurQuantitatif> indicateurQuantitatifs) {
        this.indicateurQuantitatifs = indicateurQuantitatifs;
    }
}
