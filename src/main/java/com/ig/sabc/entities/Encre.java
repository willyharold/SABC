/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "encre.Byimprimante",query = " SELECT e from Imprimante i, Encre e WHERE i.id = e.imprimante AND e.id = :param"),
    @NamedQuery(name = "encre.Bydate",query = " SELECT e from Encre e WHERE e.date_debut BETWEEN :param1 AND :param2"),
    @NamedQuery(name = "encre.Bytype",query = " SELECT e from Encre e WHERE e.date_debut BETWEEN :param1 AND :param2 AND e.encreType=:param3"),
})

public class Encre implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Calendar date_debut;
    
    @Temporal(TemporalType.DATE)
    private Calendar date_fin;
    
    @Column(nullable = false)
    private int nbr_encre;
    
    @ManyToOne
    private Imprimante imprimante;
    
    @Enumerated(EnumType.STRING)
    private EncreType encreType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Calendar date_debut) {
        this.date_debut = date_debut;
    }

    public Calendar getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Calendar date_fin) {
        this.date_fin = date_fin;
    }

    public int getNbr_encre() {
        return nbr_encre;
    }

    public void setNbr_encre(int nbr_encre) {
        this.nbr_encre = nbr_encre;
    }

    public Imprimante getImprimante() {
        return imprimante;
    }

    public void setImprimante(Imprimante imprimante) {
        this.imprimante = imprimante;
    }

    public EncreType getEncreType() {
        return encreType;
    }

    public void setEncreType(EncreType encreType) {
        this.encreType = encreType;
    }
    
    
    
}
