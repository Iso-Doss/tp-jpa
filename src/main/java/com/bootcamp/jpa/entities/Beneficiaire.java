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
@Entity(name = "Beneficiaire")
@Table(name = "tp_beneficiaire")
@NamedQueries({
    @NamedQuery(
            name = "Beneficiaire.findAll",
            query = "select beneficiaire from Beneficiaire beneficiaire")
    ,
    @NamedQuery(
            name = "Beneficiaire.findByName",
            query = "select beneficiaire from Beneficiaire beneficiaire where beneficiaire.nom = :nom")
    , 
    @NamedQuery(
            name = "Beneficiaire.countAll",
            query = "select count(beneficiaire) from Beneficiaire beneficiaire"),})
public class Beneficiaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "beneficiaires")
    private List<Programme> programmes = new ArrayList<Programme>();

    @ManyToMany(mappedBy = "beneficiaires")
    private List<Projet> projets = new ArrayList<Projet>();

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
        if (!(object instanceof Beneficiaire)) {
            return false;
        }
        Beneficiaire other = (Beneficiaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.tp.jpa.Beneficiaire[ id=" + id + " ]";
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

}
