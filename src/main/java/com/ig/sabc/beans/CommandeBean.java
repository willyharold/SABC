/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.EncreType;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Papier;
import com.ig.sabc.service.IEncreServ;
import com.ig.sabc.service.IImprimanteServ;
import com.ig.sabc.service.IPapierServ;
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
public class CommandeBean implements SelectableDataModel<Imprimante>{
    
    @ManagedProperty(value = "#{IEncreServ}")
    IEncreServ encreServ;
    Encre encre = new Encre();
    private String type_encre;
    
    @ManagedProperty(value = "#{IPapierServ}")
    IPapierServ papierServ;
    Papier papier = new Papier();
    private List<String> list = new LinkedList<String>();

    @ManagedProperty(value = "#{IImprimanteServ}")
    IImprimanteServ imprimanteServ;
    private Imprimante imprimante = new Imprimante();
    private List<Imprimante> imprimantes = new LinkedList<Imprimante>();

    
    
    
    
    public IImprimanteServ getImprimanteServ() {
        return imprimanteServ;
    }

    public void setImprimanteServ(IImprimanteServ imprimanteServ) {
        this.imprimanteServ = imprimanteServ;
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
            Logger.getLogger(CommandeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imprimantes;
    }

    public void setImprimantes(List<Imprimante> imprimantes) {
        this.imprimantes = imprimantes;
    }
    
    public List<String> getList() {
        list.add("NOIR");
        list.add("COULEUR");
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
 
    public String getType_encre() {
        return type_encre;
    }

    public void setType_encre(String type_encre) {
        this.type_encre = type_encre;
    }

    public IEncreServ getEncreServ() {
        return encreServ;
    }

    public void setEncreServ(IEncreServ encreServ) {
        this.encreServ = encreServ;
    }

    public Encre getEncre() {
        return encre;
    }

    public void setEncre(Encre encre) {
        this.encre = encre;
    }

    public IPapierServ getPapierServ() {
        return papierServ;
    }

    public void setPapierServ(IPapierServ papierServ) {
        this.papierServ = papierServ;
    }

    public Papier getPapier() {
        return papier;
    }

    public void setPapier(Papier papier) {
        this.papier = papier;
    }

    
    
    public void saveInk(){
        System.out.println(imprimante.getIdentifiant());
//        if(type_encre.compareTo("NOIR")==0)
//            encre.setEncreType(EncreType.NOIR);
//        else
//            encre.setEncreType(EncreType.COULEUR);
//        encre.setDate_debut(Calendar.getInstance());
//        try {
//            encre.setImprimante(imprimanteServ.findById(imprimante.getId()));
//            encreServ.create(encre);
//        } catch (DataAccessException ex) {
//            Logger.getLogger(CommandeBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    @Override
    public Object getRowKey(Imprimante t) {
        return t.getId();
        }
    
    @Override
    public Imprimante getRowData(String string) {
        List<Imprimante> ag =getImprimantes();
        for(Imprimante entre : ag)  {
            if(entre.getId().equals(string)){
                return entre;
            }
        }
        return null;
    }
    
}