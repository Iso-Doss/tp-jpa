/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity
@Table(name = "tp_indicateur_quantitatif")
public class IndicateurQuantitatif implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @Column(name = "propriete", length = 45, nullable = false)
    private String propriete;

    @Column(name = "valeur", nullable = false)
    private Integer valeur;

    @ManyToOne
    @JoinColumn(name = "indicateurPerformance", referencedColumnName = "id")
    private IndicateurPerformance indicateurPerformance;

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
        if (!(object instanceof IndicateurQuantitatif)) {
            return false;
        }
        IndicateurQuantitatif other = (IndicateurQuantitatif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.tp.jpa.IndicateurQuantitatif[ id=" + id + " ]";
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the propriete
     */
    public String getPropriete() {
        return propriete;
    }

    /**
     * @param propriete the propriete to set
     */
    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    /**
     * @return the valeur
     */
    public Integer getValeur() {
        return valeur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    /**
     * @return the indicateurPerformance
     */
    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    /**
     * @param indicateurPerformance the indicateurPerformance to set
     */
    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

}
