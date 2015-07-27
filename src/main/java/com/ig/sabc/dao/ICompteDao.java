/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Compte;

/**
 *
 * @author root
 */
public interface ICompteDao extends IDao<Compte, Long>{
    public Compte FindByLogin(String s) throws DataAccessException;
}
