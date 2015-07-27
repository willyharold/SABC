/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.ICompteDao;
import com.ig.sabc.daoImpl.CompteDaoImpl;
import com.ig.sabc.entities.Compte;
import com.ig.sabc.service.ICompteServ;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class CompteServImpl implements ICompteServ{

    private ICompteDao compte;

    public ICompteDao getCompte() {
        return compte;
    }

    public void setCompte(ICompteDao compte) {
        this.compte = compte;
    }

    
    public Compte FindByLogin(String s) throws DataAccessException {
        return compte.FindByLogin(s);
    }

    public Compte findById(Long id) throws DataAccessException {
        return compte.findById(id);
    }

    public List<Compte> findAll() throws DataAccessException {
        return compte.findAll();
    }

    public Compte create(Compte t) throws DataAccessException {
        return compte.create(t);
      }

//    public void delete(Compte t) throws DataAccessException {
//        compte.delete(t);
//    }

    public Compte update(Compte t) throws DataAccessException {
        return compte.update(t);
    }

    public void delete(Long id) throws DataAccessException {
        Compte c= compte.findById(id);
        compte.delete(c);
    }
    
}
