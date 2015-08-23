/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.dao.IMessageDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.EncreType;
import com.ig.sabc.entities.Etat;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
public class EncreDaoImpl extends GenericDao<Encre, Long> implements IEncreDao{

    public List<Encre> encrebyimp(Long id) throws DataAccessException {
         return (List<Encre>)(getManager().createNamedQuery("encre.Byimprimante").setParameter("param", id).getResultList());
    }

    public List<Encre> encrebydate(Date date1, Date date2) throws DataAccessException {
                 return (List<Encre>)(getManager().createNamedQuery("encre.Bydate").setParameter("param1", date1,TemporalType.DATE).setParameter("param2", date2,TemporalType.DATE).getResultList());
    }

    public List<Encre> encrebytype(Date date1, Date date2, Enum type) throws DataAccessException {
                 return (List<Encre>)(getManager().createNamedQuery("encre.Bytype").setParameter("param1", date1,TemporalType.DATE).setParameter("param2", date2,TemporalType.DATE).setParameter("param3", type).getResultList());
    }
    
    
    
    public int detect_encre_noir(Imprimante i) throws DataAccessException{
        Calendar calendar = Calendar.getInstance();
        String d1 = null;
        String d2 = null;
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
        d1 = dateFormat1.format(calendar.getTime()) + "-" + dateFormat.format(calendar.getTime()) + "-01";
        d2 = dateFormat1.format(calendar.getTime()) + "-" + dateFormat.format(calendar.getTime()) + "-30";
        System.out.println(d1);
        System.out.println(d2);
        Date date1 = null;
        Date date2 = null;
               
        try {
            date1 = dateFormat2.parse(d1);
            date2 = dateFormat2.parse(d2);
        } catch (ParseException ex) {
            Logger.getLogger(EncreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        List<Encre> es = new LinkedList<Encre>();
        
        es = encrebytype(date1, date2, EncreType.NOIR);
        int cmpt = 0;
        if (es != null) {
            for (Encre e : es) {
                cmpt = cmpt + e.getNbr_encre();
            }
        }
  
        if(cmpt > i.getCategorie().getNbre_encre()){
            return cmpt;
        }
        else
            return 0;
        
    } 
    
    public int detect_encre_couleur(Imprimante i) throws DataAccessException {
        Calendar calendar = Calendar.getInstance();
        String d1 = null;
        String d2 = null;
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
        d1 = dateFormat1.format(calendar.getTime()) + "-" + dateFormat.format(calendar.getTime()) + "-01";
        d2 = dateFormat1.format(calendar.getTime()) + "-" + dateFormat.format(calendar.getTime()) + "-30";
        System.out.println(d1);
        System.out.println(d2);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = dateFormat2.parse(d1);
            date2 = dateFormat2.parse(d2);
        } catch (ParseException ex) {
            Logger.getLogger(EncreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Encre> es2 = new LinkedList<Encre>();
        es2 = encrebytype(date1, date2, EncreType.COULEUR);
        int cmpt2 = 0;
        if (es2 != null) {
            for (Encre es21 : es2) {
                cmpt2 = cmpt2 + es21.getNbr_encre();
            }
        }
        if (cmpt2 > i.getCategorie().getNbre_encre_c()) {
            return cmpt2;
        } else {
            return 0;
        }
    }
}
