/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IPapierDao;
import com.ig.sabc.entities.Papier;
import java.util.List;

/**
 *
 * @author root
 */
public interface IPapierServ{
    
    public Papier findById(Long id) throws DataAccessException;

    public List<Papier> findAll() throws DataAccessException;
    
    public List<Papier> findbyImp(Long id) throws DataAccessException;

    public Papier create(Papier t) throws DataAccessException;

    public void delete(Papier t) throws DataAccessException;
    
    public Papier update(Papier t) throws DataAccessException;
    
}
