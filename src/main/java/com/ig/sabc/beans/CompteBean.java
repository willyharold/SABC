/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Compte;
import com.ig.sabc.entities.Personne;
import com.ig.sabc.entities.Role;
import com.ig.sabc.service.ICompteServ;
import com.ig.sabc.service.IPersonneServ;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class CompteBean implements SelectableDataModel<Compte>{
    
    @ManagedProperty(value = "#{ICompteServ}")
    private ICompteServ compteServ;
    private String message;
    private Compte compte = new Compte();
    private List<Compte> comptes= new LinkedList<Compte>();
    
    @ManagedProperty(value = "#{IPersonneServ}")
    private IPersonneServ personneServ;
    private List<Personne> personnes= new LinkedList<Personne>();
    private List<String> roles= new LinkedList<String>();
    private String role;
    private String nom_personne;

    
    public String getNom_personne() {
        return nom_personne;
    }

    public void setNom_personne(String nom_personne) {
        this.nom_personne = nom_personne;
    }

    public List<String> getRoles() {  
        roles.add("ADMIN");
        roles.add("EMPLOYE");
        return roles;
    }
    
    public List<String> initialise_role(){
        if(roles.isEmpty()){
        roles.add("ADMIN");
        roles.add("EMPLOYE");
        }
        return roles;     
    }

    
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
    
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IPersonneServ getPersonneServ() {
        return personneServ;
    }

    public void setPersonneServ(IPersonneServ personneServ) {
        this.personneServ = personneServ;
    }
    
    
    public List<Personne> getPersonnes() {
        try {
            personnes = personneServ.findbycompt();
        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }
    
    
    
    public ICompteServ getCompteServ() {
        return compteServ;
    }

    public List<Compte> getComptes() {
        try {
            comptes = compteServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
    
    
    public CompteBean(){
        
    }

    public void setCompteServ(ICompteServ compteServ) {
        this.compteServ = compteServ;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    
    
    Compte compte1 =new Compte();
    public String connec(){
        if(compte.getIdentifiant().compareTo("")==0||compte.getMot_passe().compareTo("")==0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "La valeur de l'identifiant ou du mot de passe ne peut être null."));
            return "erreur";
        } 
            
        try {
            compte1= compteServ.FindByLogin(compte.getIdentifiant());
            if(compte1.getMot_passe().compareTo(compte.getMot_passe())==0){
                if(compte1.getRole().compareTo(Role.ADMIN)==0)
                    return "connexion";
                if(compte1.getRole().compareTo(Role.EMPLOYE)==0)
                    return "connexion_user";
            }
            else{
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Login ou mot de passe incorrect."));

            }
        } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Contactez l'administrateur."));
                
        }
        System.out.println(compte1.getRole());
        return "erreur";
    }
    
    
    public void enregistrer(){
        try {
            
            if(role.compareTo("ADMIN")==0)
                compte.setRole(Role.ADMIN);
            else
                compte.setRole(Role.EMPLOYE);
            
            for (Personne p : getPersonnes()) {
                if(p.getNom().compareTo(nom_personne)==0)
                    compte.setPersonne(p);
            }
            compteServ.create(compte);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "L'enregistrement a été éffectué correctement."));

        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Erreur lors de l'enregistrement."));

        }
    }
    
    public void modifier(){
        try {
            personnes = personneServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            if(role.compareTo("ADMIN")==0)
                compte.setRole(Role.ADMIN);
            else
                compte.setRole(Role.EMPLOYE);
            
            for (Personne p : personnes) {
                if(nom_personne.compareTo(p.getNom())==0)
                    compte.setPersonne(p);
            }
            
            compteServ.update(compte);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "L'enregistrement a été éffectué correctement."));
  
        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Erreur lors de l'enregistrement."));

        }
    }

    public void supprimer(){
        try {
            Compte c = new Compte();
            Long id = compte.getId();
            c.setId(id);
            c.setIdentifiant(compte.getIdentifiant());
            c.setMot_passe(compte.getMot_passe());
            c.setMessages(compte.getMessages());
            c.setPersonne(compte.getPersonne());
            c.setRole(compte.getRole());
            compteServ.delete(compte.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "La suppression a été éffectué correctement."));

        } catch (DataAccessException ex) {
            Logger.getLogger(CompteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public Compte getRowData(String rowKey){

        List<Compte> ag = getComptes();
        for (Compte entre : ag) {
            if (entre.getId().equals(rowKey)) {
                return entre;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(Compte ag) {
        return ag.getId();
    }
}
