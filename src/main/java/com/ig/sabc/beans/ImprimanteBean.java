/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.ImprimanteCategorie;
import com.ig.sabc.entities.Personne;
import com.ig.sabc.entities.Service;
import com.ig.sabc.service.ICategorieServ;
import com.ig.sabc.service.IImprimanteServ;
import com.ig.sabc.service.IPersonneServ;
import com.ig.sabc.service.IServiceServ;
import com.ig.sabc.serviceImpl.PersonneServImpl;
import com.ig.sabc.serviceImpl.ServiceServImpl;
import java.util.Calendar;
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
public class ImprimanteBean implements SelectableDataModel<Imprimante>{

    @ManagedProperty(value = "#{IImprimanteServ}")
    IImprimanteServ imprimanteServ;
    private Imprimante imprimante = new Imprimante();
    private List<Imprimante> imprimantes = new LinkedList<Imprimante>();
    @ManagedProperty(value = "#{ICategorieServ}")
    ICategorieServ categorieServ;
    private List<ImprimanteCategorie> categories = new LinkedList<ImprimanteCategorie>();
    private String cat;
    @ManagedProperty(value = "#{IServiceServ}")
    IServiceServ serviceServ;  
    List<Service> services = new LinkedList<Service>();     
    @ManagedProperty(value = "#{IPersonneServ}")
    IPersonneServ personneServ;
    List<Personne> personnes = new LinkedList<Personne>();

    public IServiceServ getServiceServ() {
        return serviceServ;
    }

    public void setServiceServ(IServiceServ serviceServ) {
        this.serviceServ = serviceServ;
    }

    public IPersonneServ getPersonneServ() {
        return personneServ;
    }

    public void setPersonneServ(IPersonneServ personneServ) {
        this.personneServ = personneServ;
    }
    
    
    

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public ICategorieServ getCategorieServ() {
        return categorieServ;
    }

    public void setCategorieServ(ICategorieServ categorieServ) {
        this.categorieServ = categorieServ;
    }
    
    
    public List<ImprimanteCategorie> getCategories() {
        try {
            categories = categorieServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
  
    public void setCategories(List<ImprimanteCategorie> categories) {
        this.categories = categories;
    }
  
    public Imprimante getImprimante() {
        return imprimante;
    }

    public void setImprimante(Imprimante imprimante) {
        this.imprimante = imprimante;
    }

    public List<Imprimante> getImprimantes() {
        try {
            imprimantes = imprimanteServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imprimantes;
    }

    public void setImprimantes(List<Imprimante> imprimantes) {
        this.imprimantes = imprimantes;
    }

    public IImprimanteServ getImprimanteServ() {
        return imprimanteServ;
    }

    public void setImprimanteServ(IImprimanteServ imprimanteServ) {
        this.imprimanteServ = imprimanteServ;
    }
    
    public void enregistrer(){
        List<ImprimanteCategorie> categories1 = new LinkedList<ImprimanteCategorie>();
         try {
            categories1 = categorieServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImprimanteCategorie ic = new ImprimanteCategorie();
        for (ImprimanteCategorie categories11 : categories1) {
            System.out.println("liste des ids des categories "+categories11.getId());
            if(categories11.getCategorie()==Integer.valueOf(cat))
                ic=categories11;
        }
        Calendar calendar = Calendar.getInstance();
        imprimante.setCategorie(ic);
        imprimante.setDate(calendar);
        try {
            imprimanteServ.create(imprimante);
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifier(){
         List<ImprimanteCategorie> categories1 = new LinkedList<ImprimanteCategorie>();
         try {
            categories1 = categorieServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImprimanteCategorie ic = new ImprimanteCategorie();
        for (ImprimanteCategorie categories11 : categories1) {
            System.out.println("liste des ids des categories "+categories11.getId());
            if(categories11.getCategorie()==Integer.valueOf(cat))
                ic=categories11;
        }
        Calendar calendar = Calendar.getInstance();
        imprimante.setCategorie(ic);
        imprimante.setDate(calendar);
        try {
            imprimanteServ.update(imprimante);
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void supprimer(){
        //System.out.println(imprimante.getId());
        try {
            personnes = personneServ.findAll();
            services = serviceServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        for (Personne personne : personnes) {
            if (personne.getImprimante() != null) {


                if ((personne.getImprimante().getId().compareTo(imprimante.getId())) == 0) {
                    personne.setImprimante(null);
                    try {
                        personneServ.update(personne);
                    } catch (DataAccessException ex) {
                        Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        for (Service service : services) {
            if (service.getImprimante() != null) {
                if ((service.getImprimante().getId().compareTo(imprimante.getId())) == 0) {
                    service.setImprimante(null);
                    try {
                        serviceServ.update(service);
                    } catch (DataAccessException ex) {
                        Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        try {
            imprimanteServ.delete(imprimante.getId());
        } catch (DataAccessException ex) {
            Logger.getLogger(ImprimanteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ImprimanteBean(){
        
    }
    @Override
    public Object getRowKey(Imprimante t) {
        return t.getId();
       
    }
    @Override
    public Imprimante getRowData(String string) {
         List<Imprimante> ag = new LinkedList<Imprimante>();
        for (Imprimante imprimante : ag) {
            if(imprimante.getId().equals(ag))
                return imprimante;
        }        
        return null;
    }
    
}
