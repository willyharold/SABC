/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IPersonneDao;
import com.ig.sabc.daoImpl.PersonneDaoImpl;
import com.ig.sabc.entities.Personne;
import com.ig.sabc.service.IPersonneServ;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class PersonneServImpl implements IPersonneServ{
    
    private IPersonneDao personne;

    public IPersonneDao getPersonne() {
        return personne;
    }

    public void setPersonne(IPersonneDao personne) {
        this.personne = personne;
    }

   
    public Personne findById(Long id) throws DataAccessException {
        return personne.findById(id);
    }

    public List<Personne> findAll() throws DataAccessException {
        return personne.findAll();
    }

    public Personne create(Personne t) throws DataAccessException {
        return personne.create(t);
    }

    public void delete(Personne t) throws DataAccessException {
        personne.delete(t);
    }

    public Personne update(Personne t) throws DataAccessException {
        return personne.update(t);
    }

    public void delete(Long t) throws DataAccessException {

    personne.delete(personne.findById(t));
    }

    public List<Personne> findbycompt() throws DataAccessException {
        return personne.findbycompte();
    }
    
}
