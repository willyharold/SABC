/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.entities;

import com.sun.corba.se.spi.ior.Identifiable;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@NamedQueries({
@NamedQuery(name = "imprimante.findbyiden",query = " SELECT i from Imprimante i WHERE i.identifiant = :param"),
})
public class Imprimante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Column(nullable = false)
    private String identifiant;
    
    @OneToMany(mappedBy = "imprimante")
    private List<Encre> encre;
    
    @OneToMany(mappedBy = "imprimante")
    private List<Papier> papier;
    
    @Temporal(TemporalType.DATE)
    private Calendar date;
    
    @OneToOne
    private ImprimanteCategorie categorie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String Identifiant) {
        this.identifiant = Identifiant;
    }

    public List<Encre> getEncre() {
        return encre;
    }

    public void setEncre(List<Encre> encre) {
        this.encre = encre;
    }

    public List<Papier> getPapier() {
        return papier;
    }

    public void setPapier(List<Papier> papier) {
        this.papier = papier;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public ImprimanteCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ImprimanteCategorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return  identifiant ;
    }  
    
}
