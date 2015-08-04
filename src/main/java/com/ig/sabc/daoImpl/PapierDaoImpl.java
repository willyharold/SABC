/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IPapierDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Papier;
import java.util.List;

/**
 *
 * @author root
 */
public class PapierDaoImpl extends GenericDao<Papier, Long> implements IPapierDao{
    public List<Papier> papierbyimp(Long id) throws DataAccessException {
         return (List<Papier>)(getManager().createNamedQuery("papier.Byimprimante").setParameter("param", id).getResultList());
    }
}
