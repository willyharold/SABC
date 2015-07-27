/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IAgenceDao;
import com.ig.sabc.entities.Agence;
import java.util.List;

/**
 *
 * @author root
 */
public interface IAgenceServ {
    

    public Agence findById(Long id) throws DataAccessException;
   
    public List<Agence> findAll() throws DataAccessException; 

    public Agence create(Agence t) throws DataAccessException; 
    
    public Agence update(Agence t) throws DataAccessException;
   
    public Agence findByreg(String t) throws DataAccessException;
    
    public int ImprimantefindByagence(Long t) throws DataAccessException;
    
    public int ServicefindByagence(Long t) throws DataAccessException;
    
    public int PersonnefindByagence(Long t) throws DataAccessException;
    
    public void delete(Long id) throws DataAccessException ;
}
