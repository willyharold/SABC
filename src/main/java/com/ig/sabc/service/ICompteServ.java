/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.ICompteDao;
import com.ig.sabc.entities.Compte;
import java.util.List;

/**
 *
 * @author root
 */
public interface ICompteServ{
    
    
    public Compte FindByLogin(String s) throws DataAccessException;
    
    public Compte findById(Long id) throws DataAccessException;
    
    public List<Compte> findAll() throws DataAccessException;
    
    public Compte create(Compte t) throws DataAccessException;
    
    public Compte update(Compte t) throws DataAccessException;
    
    public void delete(Long id) throws DataAccessException ;
}
