/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IServiceDao;
import com.ig.sabc.entities.Service;
import com.ig.sabc.service.IServiceServ;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class ServiceServImpl implements IServiceServ{
    
    private IServiceDao service;

    public IServiceDao getService() {
        return service;
    }

    public void setService(IServiceDao service) {
        this.service = service;
    }
    
    public Service findById(Long id) throws DataAccessException {
        return service.findById(id);
    }

    public List<Service> findAll() throws DataAccessException {
        return service.findAll();
    }

    public Service create(Service t) throws DataAccessException {
        return service.create(t);
    }

    public void delete(Service t) throws DataAccessException {
        service.delete(t);
    }

    public Service update(Service t) throws DataAccessException {
        return service.update(t);
    }

    public List<Service> findAllbyAgence(Long id) throws DataAccessException {
        return service.findAllServicebyagence(id);
    }

    public void delete(Long t) throws DataAccessException {
        service.delete(service.findById(t));
        }
    
}
