/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IImprimanteDao;
import com.ig.sabc.entities.Imprimante;
import java.util.List;

/**
 *
 * @author root
 */
public class ImprimanteDaoImpl extends GenericDao<Imprimante, Long> implements IImprimanteDao{

    public Imprimante FindByiden(String s) throws DataAccessException {
        return (Imprimante)(getManager().createNamedQuery("imprimante.findbyiden").setParameter("param", s).getSingleResult());
    }
    
    public List<Imprimante> FindALLenservice() throws DataAccessException {
        return (List<Imprimante>)(getManager().createNamedQuery("imprimanteEnservice").getResultList());
    }
}
