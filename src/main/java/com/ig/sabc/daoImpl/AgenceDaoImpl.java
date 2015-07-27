/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IAgenceDao;
import com.ig.sabc.entities.Agence;

/**
 *
 * @author root
 */
public class AgenceDaoImpl extends GenericDao<Agence, Long> implements IAgenceDao{
    
    
    public Agence FindByregion(String s) throws DataAccessException {
        return (Agence)(getManager().createNamedQuery("agence.findbyreg").setParameter("param", s).getSingleResult());
    }

    public int ImprimanteByAgence(Long s) throws DataAccessException {
        return (Integer.valueOf((getManager().createNamedQuery("imprimante.byagence").setParameter("param", s).getSingleResult().toString())));
    }

    public int PersonneByAgence(Long s) throws DataAccessException {
       
        return(Integer.valueOf((getManager().createNamedQuery("personne.byagence").setParameter("param", s).getSingleResult().toString())));
    }

    public int ServiceByAgence(Long s) throws DataAccessException {
       
        return(Integer.valueOf((getManager().createNamedQuery("service.byagence").setParameter("param", s).getSingleResult().toString())));
    }

}
