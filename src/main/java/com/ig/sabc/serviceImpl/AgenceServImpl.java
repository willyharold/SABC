/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IAgenceDao;
import com.ig.sabc.daoImpl.AgenceDaoImpl;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.service.IAgenceServ;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */

@Transactional
public class AgenceServImpl implements IAgenceServ{
    
    private IAgenceDao agence;

    public IAgenceDao getAgence() {
        return agence;
    }

    public void setAgence(IAgenceDao agence) {
        this.agence = agence;
    }

   
    public Agence findById(Long id) throws DataAccessException {
        return agence.findById(id);
        
        }

    public List<Agence> findAll() throws DataAccessException {
        return agence.findAll();
        }

    public Agence create(Agence t) throws DataAccessException {
        return agence.create(t);
    }

    public void delete(Long id) throws DataAccessException {
        Agence a = agence.findById(id);
        agence.delete(a);
        //agence.delete(t);
    }

    public Agence update(Agence t) throws DataAccessException {
        return agence.update(t);
    }

    public void delete(Agence t) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Agence findByreg(String t) throws DataAccessException {

        return agence.FindByregion(t);
    }

    public int ImprimantefindByagence(Long t) throws DataAccessException {
        
        return agence.ImprimanteByAgence(t);
    }

    public List<Agence> findAll_initialise() throws DataAccessException {  
        return null;
        }

    public int ServicefindByagence(Long t) throws DataAccessException {
        return agence.ServiceByAgence(t);
    }

    public int PersonnefindByagence(Long t) throws DataAccessException {
        return agence.PersonneByAgence(t);
    }

}
