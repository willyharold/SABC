/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.ICompteDao;
import com.ig.sabc.entities.Compte;

/**
 *
 * @author root
 */
public class CompteDaoImpl extends GenericDao<Compte, Long> implements ICompteDao{

    public Compte FindByLogin(String s) throws DataAccessException{
          return (Compte)(getManager().createNamedQuery("compte.findByLogin").setParameter("param", s).getSingleResult());
    }
    
}
