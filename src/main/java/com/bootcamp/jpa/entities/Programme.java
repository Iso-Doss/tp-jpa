/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity
@Table(name = "tp_programme")
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @Column(name = "objectif", length = 45, nullable = false)
    private String objectif;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeDebut;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDeFin;

    @Column(nullable = false)
    private double budgetPrevisionnel;

    @Column(nullable = false)
    private double budgetEffectif;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programme")
    private List<Projet> projets = new ArrayList<Projet>();

    @ManyToOne(fetch = FetchType.LAZY)
    private IndicateurPerformance indicateurPerformance;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "tp_programme_bailleur",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "bailleur_id")
    )
    private List<Bailleur> bailleurs = new ArrayList<Bailleur>();

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "tp_programme_beneficiaire",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "beneficiaire_id")
    )
    private List<Beneficiaire> beneficiaires = new ArrayList<Beneficiaire>();

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name = "tp_programme_fournisseur",
            joinColumns = @JoinColumn(name = "programme_id"),
            inverseJoinColumns = @JoinColumn(name = "fournisseur_id")
    )
    private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

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
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.tp.jpa.Programme[ id=" + id + " ]";
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
     * @return the objectif
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * @param objectif the objectif to set
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
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
     * @return the dateDeFin
     */
    public Date getDateDeFin() {
        return dateDeFin;
    }

    /**
     * @param dateDeFin the dateDeFin to set
     */
    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    /**
     * @return the budgetPrevisionnel
     */
    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    /**
     * @param budgetPrevisionnel the budgetPrevisionnel to set
     */
    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    /**
     * @return the budgetEffectif
     */
    public double getBudgetEffectif() {
        return budgetEffectif;
    }

    /**
     * @param budgetEffectif the budgetEffectif to set
     */
    public void setBudgetEffectif(double budgetEffectif) {
        this.budgetEffectif = budgetEffectif;
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
     * @return the bailleurs
     */
    public List<Bailleur> getBailleurs() {
        return bailleurs;
    }

    /**
     * @param bailleurs the bailleurs to set
     */
    public void setBailleurs(List<Bailleur> bailleurs) {
        this.bailleurs = bailleurs;
    }

    /**
     * @return the beneficiaires
     */
    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    /**
     * @param beneficiaires the beneficiaires to set
     */
    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }

    /**
     * @return the fournisseurs
     */
    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    /**
     * @param fournisseurs the fournisseurs to set
     */
    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }
}
