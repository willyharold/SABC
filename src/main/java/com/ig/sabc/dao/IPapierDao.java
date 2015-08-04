/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Papier;
import java.util.List;

/**
 *
 * @author root
 */
public interface IPapierDao extends IDao<Papier, Long>{
    public List<Papier> papierbyimp(Long id) throws DataAccessException;
}
