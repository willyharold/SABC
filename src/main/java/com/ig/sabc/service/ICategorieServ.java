/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.ICategorieDao;
import com.ig.sabc.entities.ImprimanteCategorie;
import java.util.List;

/**
 *
 * @author root
 */
public interface ICategorieServ{
    
    public ImprimanteCategorie findById(Long id) throws DataAccessException;
    
    public List<ImprimanteCategorie> findAll() throws DataAccessException;
    
    public ImprimanteCategorie create(ImprimanteCategorie t) throws DataAccessException;
    
    public void delete(ImprimanteCategorie t) throws DataAccessException;
    
    public void delete(Long t) throws DataAccessException;

    public ImprimanteCategorie update(ImprimanteCategorie t) throws DataAccessException;

}
