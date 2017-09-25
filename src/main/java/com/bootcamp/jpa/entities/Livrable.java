/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity
@Table(name = "tp_livrable")
public class Livrable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeDebut;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeLivraison;

    @ManyToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateurPerformance;

    @ManyToOne
    @JoinColumn(name = "projet", referencedColumnName = "id")
    private Projet projet;

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
        if (!(object instanceof Livrable)) {
            return false;
        }
        Livrable other = (Livrable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.tp.jpa.Livrable[ id=" + id + " ]";
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
     * @return the dateDeDebut
     */
    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    /**
     * @param dateDeDebut the dateDeDebut to set
     */
    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    /**
     * @return the dateDeLivraison
     */
    public Date getDateDeLivraison() {
        return dateDeLivraison;
    }

    /**
     * @param dateDeLivraison the dateDeLivraison to set
     */
    public void setDateDeLivraison(Date dateDeLivraison) {
        this.dateDeLivraison = dateDeLivraison;
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

    /**
     * @return the projet
     */
    public Projet getProjet() {
        return projet;
    }

    /**
     * @param projet the projet to set
     */
    public void setProjet(Projet projet) {
        this.projet = projet;
    }

}
