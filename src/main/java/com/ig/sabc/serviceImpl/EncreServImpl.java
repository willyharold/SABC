/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.EncreType;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.service.IEncreServ;
import com.ig.sabc.service.IMessageServ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class EncreServImpl implements IEncreServ{
    
    private IEncreDao encre;
    public  IMessageServ messageServ = new MessageServImpl();
    
    public IEncreDao getEncre() {
        return encre;
    }

    public IMessageServ getMessageServ() {
        return messageServ;
    }

    public void setMessageServ(IMessageServ messageServ) {
        this.messageServ = messageServ;
    }
    
    public void setEncre(IEncreDao encre) {
        this.encre = encre;
    }

    public Encre findById(Long id) throws DataAccessException {
        return encre.findById(id);
    }

    public List<Encre> findAll() throws DataAccessException {
        return encre.findAll();
    }

    public Encre create(Encre t) throws DataAccessException {
        return encre.create(t);
    }

    public void delete(Encre t) throws DataAccessException {
        encre.delete(t);
    }

    public Encre update(Encre t) throws DataAccessException {
        return encre.update(t); 
    }

    public List<Encre> findbyImp(Long id) throws DataAccessException {
        return encre.encrebyimp(id);
    }

    public List<Encre> findbydate(Date d1, Date d2) throws DataAccessException {
        return encre.encrebydate(d1, d2);
    }

    public List<Encre> findbytype(Date d1, Date d2, Enum type) throws DataAccessException {
        return encre.encrebytype(d1, d2, type);
    }
    
    public void detect_encre(Imprimante i) throws DataAccessException{
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
            Logger.getLogger(EncreServImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Encre> es = new LinkedList<Encre>();
        
        es = encre.encrebytype(date1, date2, EncreType.NOIR);
        int cmpt = 0;
        if (es != null) {
            for (Encre e : es) {
                cmpt = cmpt + e.getNbr_encre();
            }
        }
        System.out.println("le nombre d'encre noir est " + cmpt);
        //JE VIENS DE RECUPERER L'ENSEMEBLE DE CONSOMMATION D'ENCRE NOIR SUR UNE DATE DONNEE
        //
        List<Encre> es2 = new LinkedList<Encre>();
        es2 = encre.encrebytype(date1, date2, EncreType.COULEUR);
        int cmpt2 = 0;
        if (es2 != null) {
            for (Encre es21 : es2) {
                cmpt2 = cmpt2 + es21.getNbr_encre();
            }
        }
        
//        if(cmpt > i.getCategorie().getNbre_encre())
//            messageServ.messageAlerte_noir(i, cmpt);
        //        
        //JE VIENS DE RECUPERER L'ENSEMEBLE DE CONSOMMATION D'ENCRE COULEUR SUR UNE DATE DONNEE
    } 
    
    
}