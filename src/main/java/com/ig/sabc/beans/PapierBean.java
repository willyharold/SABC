/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Papier;
import com.ig.sabc.service.IPapierServ;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class PapierBean {
    
    
    @ManagedProperty(value = "#{IPapierServ}")
    IPapierServ papierServ;
    Papier papier = new Papier();
    private List<Papier> papiers = new LinkedList<Papier>();
    
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

    public List<Papier> getPapiers() {
        try {
            papiers = papierServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PapierBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return papiers;
    }

    public void setPapiers(List<Papier> papiers) {
        this.papiers = papiers;
    }
       
}
