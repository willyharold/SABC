/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IServiceDao;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.entities.Service;
import java.util.List;

/**
 *
 * @author root
 */
public class ServiceDaoImpl extends GenericDao<Service, Long> implements IServiceDao{

    public List<Service> findAllServicebyagence(Long id) throws DataAccessException {
        return (List<Service>)(getManager().createNamedQuery("service.findbyagen").setParameter("param", id).getResultList());
    }
    
}
