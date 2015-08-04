/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Imprimante;
import java.util.List;

/**
 *
 * @author root
 */
public interface IImprimanteDao extends IDao<Imprimante, Long>{
    public Imprimante FindByiden(String s) throws DataAccessException;
    public List<Imprimante> FindALLenservice() throws DataAccessException;

}
