/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.ImprimanteCategorie;
import com.ig.sabc.service.ICategorieServ;
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
public class CategorieBean implements SelectableDataModel<ImprimanteCategorie>{

    @ManagedProperty(value = "#{ICategorieServ}")
    ICategorieServ categorieServ;
    List<ImprimanteCategorie> categories =new LinkedList<ImprimanteCategorie>();
    ImprimanteCategorie categorie = new ImprimanteCategorie();

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
            Logger.getLogger(CategorieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public void setCategories(List<ImprimanteCategorie> categories) {
        this.categories = categories;
    }

    public ImprimanteCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ImprimanteCategorie categorie) {
        this.categorie = categorie;
    }
    
    public void enregistrer(){
        try {
            categorieServ.create(categorie);
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifier(){
        try {
            categorieServ.update(categorie);
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void supprimer(){
        try {
            categorieServ.delete(categorie.getId());
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public Object getRowKey(ImprimanteCategorie t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ImprimanteCategorie getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}