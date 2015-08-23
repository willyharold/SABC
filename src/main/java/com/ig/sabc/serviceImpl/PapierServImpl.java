/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IPapierDao;
import com.ig.sabc.daoImpl.PapierDaoImpl;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Papier;
import com.ig.sabc.service.IPapierServ;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class PapierServImpl implements IPapierServ{
   
    private IPapierDao papier;

    public IPapierDao getPapier() {
        return papier;
    }

    public void setPapier(IPapierDao papier) {
        this.papier = papier;
    }

   
   public Papier findById(Long id) throws DataAccessException {
        return papier.findById(id);
    }

    public List<Papier> findAll() throws DataAccessException {
        return papier.findAll();
    }

    public Papier create(Papier t) throws DataAccessException {
        return papier.create(t);
    }

    public void delete(Papier t) throws DataAccessException {
        papier.delete(t);
    }

    public Papier update(Papier t) throws DataAccessException {
        return papier.update(t);
    }

    public List<Papier> findbyImp(Long id) throws DataAccessException {
        return papier.papierbyimp(id);
    }

    public List<Papier> papierby_date(Date date1, Date date2) throws DataAccessException {
        return papier.papierbydat(date1, date2);
    }

    public int detect_papier(Imprimante i) throws DataAccessException {
        return papier.detect_papier(i);
    }
    
}
