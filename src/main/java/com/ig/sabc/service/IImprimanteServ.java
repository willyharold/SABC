/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IImprimanteDao;
import com.ig.sabc.entities.Imprimante;
import java.util.List;

/**
 *
 * @author root
 */
public interface IImprimanteServ{
    
    public Imprimante findById(Long id) throws DataAccessException;

    public List<Imprimante> findAll() throws DataAccessException;

    public Imprimante create(Imprimante t) throws DataAccessException;

    public void delete(Imprimante t) throws DataAccessException;

    public Imprimante update(Imprimante t) throws DataAccessException;
    
    public Imprimante findByiden(String t) throws DataAccessException;
    
    public void delete(Long id) throws DataAccessException;
}
