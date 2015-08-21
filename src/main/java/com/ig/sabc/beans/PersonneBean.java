/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Personne;
import com.ig.sabc.entities.Service;
import com.ig.sabc.service.IAgenceServ;
import com.ig.sabc.service.IImprimanteServ;
import com.ig.sabc.service.IPersonneServ;
import com.ig.sabc.service.IServiceServ;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class PersonneBean implements SelectableDataModel<Personne>{
    
    @ManagedProperty(value = "#{IPersonneServ}")
    IPersonneServ personneServ;
    Personne personne = new Personne();
    Personne personne1 = new Personne();
    List<Personne> personnes = new LinkedList<Personne>();
    
    @ManagedProperty(value = "#{IImprimanteServ}")
    IImprimanteServ imprimanteServ;
    List<Imprimante> imprimantes  = new LinkedList<Imprimante>();

    @ManagedProperty(value = "#{IServiceServ}")
    IServiceServ serviceServ;
    List<Service> services = new LinkedList<Service>();
    private String imprimante_selec;
    private String service_selec;
    
    @ManagedProperty(value = "#{IAgenceServ}")
    IAgenceServ agenceServ;
    List<Agence> agences = new LinkedList<Agence>();
    private String nom_agence;

    public Personne getPersonne1() {
        return personne1;
    }

    public void setPersonne1(Personne personne1) {
        this.personne1 = personne1;
    }
   

    
    public IAgenceServ getAgenceServ() {
        return agenceServ;
    }

    public void setAgenceServ(IAgenceServ agenceServ) {
        this.agenceServ = agenceServ;
    }

    public List<Agence> getAgences() {
        try {
            agences = agenceServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agences;
    }

    public void setAgences(List<Agence> Agences) {
        this.agences = agences;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }
    
    public String getImprimante_selec() {
        return imprimante_selec;
    }

    public void setImprimante_selec(String imprimante_selec) {
        this.imprimante_selec = imprimante_selec;
    }

    public String getService_selec() {
        return service_selec;
    }

    public void setService_selec(String service_selec) {
        this.service_selec = service_selec;
    }
    
    
    public IImprimanteServ getImprimanteServ() {
        return imprimanteServ;
    }

    public void setImprimanteServ(IImprimanteServ imprimanteServ) {
        this.imprimanteServ = imprimanteServ;
    }

    public List<Imprimante> getImprimantes() {
        try {
            imprimantes = imprimanteServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imprimantes;
    }

    public void setImprimantes(List<Imprimante> imprimantes) {
        this.imprimantes = imprimantes;
    }

    public IServiceServ getServiceServ() {
        return serviceServ;
    }

    public void setServiceServ(IServiceServ serviceServ) {
        this.serviceServ = serviceServ;
    }

    public List<Service> getServices() {
        try {
            services = serviceServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return services;
    }
    

    public void setServices(List<Service> services) {
        this.services = services;
    }
     
    public PersonneBean(){
        
    }  
    public IPersonneServ getPersonneServ() {
        return personneServ;
    }

    public void setPersonneServ(IPersonneServ personneServ) {
        this.personneServ = personneServ;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Personne> getPersonnes() {
        try {
            personnes= personneServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
    
    
    public void enregistrer(){
//        System.out.println(service_selec);
        try {
            services = serviceServ.findAll();
            imprimantes = imprimanteServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Service s : services) {
            if(s.getNom().compareTo(service_selec)==0)
               personne1.setService(s);            
        }
        
        for (Imprimante i : imprimantes) {
            if(i.getIdentifiant().compareTo(imprimante_selec)==0)
                personne1.setImprimante(i);
        }
        try {
            personneServ.create(personne1);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "L'enregistrement a été éffectué correctement."));

        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Erreur lors de l'enregistrement."));

        }        
    }
    
      public void modifier(){
        try {
            services = serviceServ.findAll();
            imprimantes = imprimanteServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Service s : services) {
            if(s.getNom().compareTo(service_selec)==0)
               personne.setService(s);            
        }
        
        for (Imprimante i : imprimantes) {
            if(i.getIdentifiant().compareTo(imprimante_selec)==0)
                personne.setImprimante(i);
        }
        try {
            personneServ.update(personne);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "L'enregistrement a été éffectué correctement."));

        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Erreur lors de l'enregistrement."));

        }        
    }
      
      public void supprimer(){
        try {
            personneServ.delete(personne.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "La suppression a été éffectué correctement."));
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    

    public Object getRowKey(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Personne getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
