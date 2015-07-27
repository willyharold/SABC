/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IPersonneDao;
import com.ig.sabc.entities.Personne;
import java.util.List;

/**
 *
 * @author root
 */
public interface IPersonneServ{
    
     public Personne findById(Long id) throws DataAccessException;

    public List<Personne> findAll() throws DataAccessException;

    public Personne create(Personne t) throws DataAccessException;

    public void delete(Personne t) throws DataAccessException;
    
    public void delete(Long t) throws DataAccessException;

    public Personne update(Personne t) throws DataAccessException;
    
}
