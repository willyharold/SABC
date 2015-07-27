/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Service;
import com.ig.sabc.entities.ServiceType;
import com.ig.sabc.service.IAgenceServ;
import com.ig.sabc.service.IImprimanteServ;
import com.ig.sabc.service.IServiceServ;
//import com.sun.xml.internal.ws.developer.MemberSubmissionEndpointReference;
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
public class ServiceBean implements SelectableDataModel<Service>{
    
    @ManagedProperty(value = "#{IServiceServ}")
    IServiceServ serviceServ;   
    private Service service= new Service();
    private Service servicechoisi= new Service();
    private List<Service> services = new LinkedList<Service>();
    @ManagedProperty(value="#{IAgenceServ}")
    IAgenceServ agenceServ;
    private List<Agence> agences = new LinkedList<Agence>();
    @ManagedProperty(value="#{IImprimanteServ}")
    IImprimanteServ imprimanteServ;
    private List<Imprimante> imprimantes = new LinkedList<Imprimante>();
    private List<String> serviceTypes = new LinkedList<String>();
    private ServiceType type;
    private String s;
    private String agence_nom;
    private String imprimante_nom;

    public String getImprimante_nom() {
        return imprimante_nom;
    }

    public void setImprimante_nom(String imprimante_nom) {
        this.imprimante_nom = imprimante_nom;
    }

    public String getAgence_nom() {
        return agence_nom;
    }

    public void setAgence_nom(String agence_nom) {
        this.agence_nom = agence_nom;
    }

    
    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    

    public IAgenceServ getAgenceServ() {
        return agenceServ;
    }

    public void setAgenceServ(IAgenceServ agenceServ) {
        this.agenceServ = agenceServ;
    }

    public IImprimanteServ getImprimanteServ() {
        return imprimanteServ;
    }

    public void setImprimanteServ(IImprimanteServ imprimanteServ) {
        this.imprimanteServ = imprimanteServ;
    }

    public List<Agence> getAgences() {
        try {
            agences= agenceServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agences;
    }

    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }

    public List<Imprimante> getImprimantes() {
        try {
            imprimantes=imprimanteServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imprimantes;
    }

    public void setImprimantes(List<Imprimante> imprimantes) {
        this.imprimantes = imprimantes;
    }

    public List<String> getServiceTypes() {
        serviceTypes.add("REGION");
        serviceTypes.add("USINE");
        return serviceTypes;
    }

    public void setServiceTypes(List<String> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    
    public List<Service> getServices() {
        try {
            services= serviceServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    
    
    
    public IServiceServ getServiceServ() {
        return serviceServ;
    }

    public void setServiceServ(IServiceServ serviceServ) {
        this.serviceServ = serviceServ;
    }

    public Service getServicechoisi() {
        return servicechoisi;
    }

    public void setServicechoisi(Service servicechoisi) {
        this.servicechoisi = servicechoisi;
    }

    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    public ServiceBean(){
        
    }
    
    public void enregistrer(){
        try {
            Agence a= agenceServ.findByreg(agence_nom);
            if(s.compareTo("USINE")==0)
                service.setServicetype(type.USINE);
            else
                service.setServicetype(type.REGION);
            service.setAgence(a);
            serviceServ.create(service);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(service);
    }
    
    public void modifier(){
        try {
            
            Agence a= agenceServ.findByreg(agence_nom);
            if(s.compareTo("USINE")==0)
                service.setServicetype(type.USINE);
            else
                service.setServicetype(type.REGION);
            service.setAgence(a);
            serviceServ.update(service);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(service);
    }
    
    public void supprimer(){
        try {
            serviceServ.delete(service.getId());
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    public Service getRowData(String rowKey){

        List<Service> ag = getServices();
        for (Service entre : ag) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Service ag) {
        return ag.getId();
    }
    
}
