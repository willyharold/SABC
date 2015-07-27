/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author root
 */
@Entity
@NamedQueries({
@NamedQuery(name = "agence.findbyreg",query = " SELECT a from Agence a WHERE a.region = :param"),
@NamedQuery(name="imprimante.byagence",query = "SELECT count(distinct i.id) from Agence a, Service s, Personne p, Imprimante i WHERE i.id=p.imprimante AND s.id=p.service AND s.agence= a.id AND a.id= :param"),
@NamedQuery(name="service.byagence",query="SELECT count(*) from Agence a, Service s WHERE s.agence=a.id AND a.id = :param"),
@NamedQuery(name="personne.byagence",query="SELECT count(*) from Agence a, Service s, Personne p WHERE p.service=s.id AND s.agence=a.id AND a.id = :param"),
})
public class Agence implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String region;
    
    @Column(nullable = true)
    private int nbre_personne;
     
     
    @Column(nullable = true)
    private int nbre_imprimante;
      
    @Column(nullable = true)
    private int nbre_service;
    
    @OneToMany(mappedBy = "agence")
    private List<Service> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String Region) {
        this.region = Region;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
    
    public int getNbre_personne() {
        return nbre_personne;
    }

    public void setNbre_personne(int nbre_personne) {
        this.nbre_personne = nbre_personne;
    }

    public int getNbre_imprimante() {
        return nbre_imprimante;
    }

    public void setNbre_imprimante(int nbre_imprimante) {
        this.nbre_imprimante = nbre_imprimante;
    }

    public int getNbre_service() {
        return nbre_service;
    }

    public void setNbre_service(int nbre_service) {
        this.nbre_service = nbre_service;
    }

    @Override
    public String toString() {
        return region;
    }

    
}
