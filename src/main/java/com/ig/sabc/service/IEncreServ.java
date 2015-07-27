/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.entities.Encre;
import java.util.List;

/**
 *
 * @author root
 */
public interface IEncreServ{
    
    public Encre findById(Long id) throws DataAccessException;
    
    public List<Encre> findAll() throws DataAccessException;
    
    public Encre create(Encre t) throws DataAccessException;
    
    public void delete(Encre t) throws DataAccessException;
    
    public Encre update(Encre t) throws DataAccessException; 
}
