/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Personne;
import java.util.List;

/**
 *
 * @author root
 */
public interface IPersonneDao extends IDao<Personne, Long>{
    
    public List<Personne> findbycompte() throws DataAccessException;
    
}
