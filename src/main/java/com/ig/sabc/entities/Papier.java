/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
public class Papier implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Calendar date_debut;
    
    @Temporal(TemporalType.DATE)
    private Calendar date_fin;
    
    @Column(nullable = false)
    private int nbr_papier;
    
    @ManyToOne
    private Imprimante imprimante;

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

    public int getNbr_papier() {
        return nbr_papier;
    }

    public void setNbr_papier(int nbr_papier) {
        this.nbr_papier = nbr_papier;
    }

    public Imprimante getImprimante() {
        return imprimante;
    }

    public void setImprimante(Imprimante imprimante) {
        this.imprimante = imprimante;
    }
    
    
}