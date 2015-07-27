/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.entities.Service;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author root
 */
public interface IServiceDao extends IDao<Service, Long>{
    
    public List<Service> findAllServicebyagence(Long id) throws DataAccessException;
}
