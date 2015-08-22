/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IPersonneDao;
import com.ig.sabc.entities.Personne;
import java.util.List;

/**
 *
 * @author root
 */
public class PersonneDaoImpl extends GenericDao<Personne, Long> implements IPersonneDao {

    public List<Personne> findbycompte() throws DataAccessException {
        return (List<Personne>)(getManager().createNamedQuery("personne.no_compte").getResultList());
    }
    
}
