/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Imprimante;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
public interface IEncreServ{
    
    public Encre findById(Long id) throws DataAccessException;
    
    public List<Encre> findAll() throws DataAccessException;
    
    public List<Encre> findbyImp(Long id) throws DataAccessException;
    
    public List<Encre> findbydate(Date d1, Date d2) throws DataAccessException;
    
    public List<Encre> findbytype(Date d1, Date d2, Enum type) throws DataAccessException;
    
    public Encre create(Encre t) throws DataAccessException;
    
    public void delete(Encre t) throws DataAccessException;
    
    public Encre update(Encre t) throws DataAccessException; 
    
    public int detect_encre_N(Imprimante i) throws DataAccessException;
    
    public int detect_encre_C(Imprimante i) throws DataAccessException;
    
}
