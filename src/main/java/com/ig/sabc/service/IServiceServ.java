/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IServiceDao;
import com.ig.sabc.entities.Service;
import java.util.List;

/**
 *
 * @author root
 */
public interface IServiceServ{
    
    
    public Service findById(Long id) throws DataAccessException;

    public List<Service> findAll() throws DataAccessException;
    
    public List<Service> findAllbyAgence(Long id) throws DataAccessException;

    public Service create(Service t) throws DataAccessException;

    public void delete(Service t) throws DataAccessException;
    
    public void delete(Long t) throws DataAccessException;

    public Service update(Service t) throws DataAccessException;
}
