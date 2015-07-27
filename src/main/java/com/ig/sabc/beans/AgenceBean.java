/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.service.IAgenceServ;
import com.ig.sabc.serviceImpl.AgenceServImpl;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class AgenceBean implements SelectableDataModel<Agence>{
    
    @ManagedProperty(value = "#{IAgenceServ}")
    IAgenceServ iAgenceServ;
    private Agence agence = new Agence();
    private Agence agencechoisi = new Agence();
    private List<Agence> agences = new LinkedList<Agence>();
    private List<Agence> agences1 = new LinkedList<Agence>();
    private int nbre_employé;
    private int nbr_imprimante;
    private Long id_supp;

    public Long getId_supp() {
        return id_supp;
    }

    public void setId_supp(Long id_supp) {
        this.id_supp = id_supp;
    }
    

    
    public IAgenceServ getiAgenceServ() {
        return iAgenceServ;
    }

    public void setiAgenceServ(IAgenceServ iAgenceServ) {
        this.iAgenceServ = iAgenceServ;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Agence> getAgences() {
        try {
            agences = iAgenceServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(AgenceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Agence agence1 : agences) {
            try {
                agence1.setNbre_imprimante(iAgenceServ.ImprimantefindByagence(agence1.getId()));
                agence1.setNbre_personne(iAgenceServ.PersonnefindByagence(agence1.getId()));
                agence1.setNbre_service(iAgenceServ.ServicefindByagence(agence1.getId()));
                iAgenceServ.update(agence1);
            } catch (DataAccessException ex) {
                Logger.getLogger(AgenceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return agences;
    }

    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }

    public Agence getAgencechoisi() {
        return agencechoisi;
    }

    public void setAgencechoisi(Agence agencechoisi) {
        this.agencechoisi = agencechoisi;
    }

    public int getNbre_employé() {
        return nbre_employé;
    }

    public void setNbre_employé(int nbre_employé) {
        this.nbre_employé = nbre_employé;
    }

    public int getNbr_imprimante() {
        try {
            return iAgenceServ.ImprimantefindByagence(1L);
        } catch (DataAccessException ex) {
            Logger.getLogger(AgenceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 3;
    }

    public void setNbr_imprimante(int nbr_imprimante) {
        this.nbr_imprimante = nbr_imprimante;
    }

    public AgenceBean(){
        
    }
    
    
    public void enregistrer() throws DataAccessException{
        //System.out.println("hello");
        agence.setNbre_imprimante(0);
        agence.setNbre_personne(0);
        agence.setNbre_service(0);
        iAgenceServ.create(agence);
    }

   @Override
    public Agence getRowData(String rowKey){

        List<Agence> ag = getAgences();
        for (Agence entre : ag) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Agence ag) {
        return ag.getId();
    }
    
    public void supprimer(){
        try {
            Agence a= new Agence();
            System.out.println("Mon id est :           " + agencechoisi.getId());
            Long id = agencechoisi.getId();
            a.setId(agencechoisi.getId());
            a.setRegion(agencechoisi.getRegion());
            a.setServices(agencechoisi.getServices());
            iAgenceServ.delete(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(AgenceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifier(){
        try {
            iAgenceServ.update(agencechoisi);
        } catch (DataAccessException ex) {
            Logger.getLogger(AgenceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
