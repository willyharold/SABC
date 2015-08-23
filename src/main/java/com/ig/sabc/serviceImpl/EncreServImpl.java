/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.dao.IMessageDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Message;
import com.ig.sabc.service.IEncreServ;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class EncreServImpl implements IEncreServ{
    
    private IEncreDao encre;
    
    public IEncreDao getEncre() {
        return encre;
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

    public int detect_encre_N(Imprimante i) throws DataAccessException {
        return encre.detect_encre_noir(i);
    }
    
    public int detect_encre_C(Imprimante i) throws DataAccessException {
        return encre.detect_encre_couleur(i);
    }
}
