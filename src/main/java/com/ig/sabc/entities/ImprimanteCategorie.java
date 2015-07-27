/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author root
 */
@Entity
public class ImprimanteCategorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Column(nullable = false,unique = true)
    private int categorie;

    @Column(nullable = false)
    private int nbre_format;
    
    @Column(nullable = false)
    private int nbre_encre;

    public int getNbre_format() {
        return nbre_format;
    }

    public void setNbre_format(int nbre_format) {
        this.nbre_format = nbre_format;
    }

    public int getNbre_encre() {
        return nbre_encre;
    }

    public void setNbre_encre(int nbre_encre) {
        this.nbre_encre = nbre_encre;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return categorie + "" ;
    }
    
}
