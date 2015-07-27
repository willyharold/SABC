/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.daoImpl.EncreDaoImpl;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.service.IEncreServ;
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
    
}
