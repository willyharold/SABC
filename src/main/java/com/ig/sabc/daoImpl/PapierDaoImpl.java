/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IPapierDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Papier;
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
public class PapierDaoImpl extends GenericDao<Papier, Long> implements IPapierDao{
    public List<Papier> papierbyimp(Long id) throws DataAccessException {
         return (List<Papier>)(getManager().createNamedQuery("papier.Byimprimante").setParameter("param", id).getResultList());
    }

    public List<Papier> papierbydat(Date date1, Date date2) throws DataAccessException {
         return (List<Papier>)(getManager().createNamedQuery("papier.Bytype").setParameter("param1", date1,TemporalType.DATE).setParameter("param2", date2,TemporalType.DATE).getResultList());
    }
    
    
    public int detect_papier(Imprimante i) throws DataAccessException{
        Calendar calendar = Calendar.getInstance();
        String d1 = null;
        String d2 = null;
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
        d1 = dateFormat1.format(calendar.getTime()) + "-" + dateFormat.format(calendar.getTime()) + "-01";
        d2 = dateFormat1.format(calendar.getTime()) + "-" + dateFormat.format(calendar.getTime()) + "-30";
//        System.out.println(d1);
//        System.out.println(d2);
        Date date1 = null;
        Date date2 = null;
               
        try {
            date1 = dateFormat2.parse(d1);
            date2 = dateFormat2.parse(d2);
        } catch (ParseException ex) {
            Logger.getLogger(EncreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        List<Papier> papiers =new LinkedList<Papier>();
        papiers = papierbydat(date1, date2);
        int cmpt = 0;
        if (papiers != null) {
            for (Papier papier : papiers) {
                   cmpt = cmpt + papier.getNbr_papier();
            }
        }
        
        if(cmpt>i.getCategorie().getNbre_format())
            return cmpt;
        else
        System.out.println(i.getCategorie().getNbre_format());
        System.out.println(cmpt);
            return 0;
    }
}
