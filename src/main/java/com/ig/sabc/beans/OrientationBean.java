/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class OrientationBean {
    
    
    public OrientationBean() {
    }
    
    public String connexion(){
        return "connexion";
    }
    
    public String connexion_user(){
        return "connexion_user";
    }
    
    public String liste_agences(){
        return "liste_agences";
    }
    
    public String liste_comptes(){
        return "liste_comptes";
    }
    
    public String liste_personnels(){
        return "liste_personnels";
    }
    public String liste_imprimantes(){
        return "liste_imprimantes";
    }
    public String liste_categories(){
        return "liste_categories";
    }
    public String liste_services(){
        return "liste_services";
    }
    
    public String deconnexion(){
        return "deconnexion";
    }
    
    public String messagerie(){
        return "messagerie";
    }
    
     public String consommable(){
        return "consommable";
    }
     
     public String consommable_user(){
        return "consommable_user";
    }
     
     public String imprimante(){
        return "imprimant";
    }
     public String encre(){
         return "encre";
     }
     
     public String paper(){
         return "papier";
     }
     
     public String total(){
         return "total";
     }
     
     public String mensuelle(){
         return "mensuelle";
     }
     
     public String annuelle(){
         return "annuelle";
     }
     
     public String accueil(){
         return "accueil";
     }
     
     public String accueil_user(){
         return "accueil_user";
     }
}
