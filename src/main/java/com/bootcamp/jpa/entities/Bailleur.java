/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa.entities;

import com.bootcamp.jpa.enums.TypeDeBailleur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "Bailleur")
@Table(name = "tp_bailleur")
@NamedQueries({
    @NamedQuery(
            name = "Bailleur.findAll",
            query = "select bailleur from Bailleur bailleur")
    ,
    @NamedQuery(
            name = "Bailleur.findByName",
            query = "select bailleur from Bailleur bailleur where bailleur.nom = :nom")
    , 
    @NamedQuery(
            name = "Bailleur.countAll",
            query = "select count(bailleur) from Bailleur bailleur"),})
public class Bailleur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @Column(name = "typeDeBailleur", length = 45, nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeDeBailleur typeDeBailleur;

    @ManyToMany(mappedBy = "bailleurs")
    private List<Programme> programmes = new ArrayList<Programme>();

    @ManyToMany(mappedBy = "bailleurs")
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
        if (!(object instanceof Bailleur)) {
            return false;
        }
        Bailleur other = (Bailleur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.Bailleur[ id=" + id + " ]";
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
     * @return the typeDeBailleur
     */
    public TypeDeBailleur getTypeDeBailleur() {
        return typeDeBailleur;
    }

    /**
     * @param typeDeBailleur the typeDeBailleur to set
     */
    public void setTypeDeBailleur(TypeDeBailleur typeDeBailleur) {
        this.typeDeBailleur = typeDeBailleur;
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
