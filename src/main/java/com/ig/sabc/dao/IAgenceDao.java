/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Agence;
import com.ig.sabc.entities.Compte;
import java.util.List;

/**
 *
 * @author root
 */
public interface IAgenceDao extends IDao<Agence, Long>{
    public Agence FindByregion(String s) throws DataAccessException;
    
    public int ImprimanteByAgence(Long s) throws DataAccessException;
    
    public int PersonneByAgence(Long s) throws DataAccessException;
    
    public int ServiceByAgence(Long s) throws DataAccessException;
}
