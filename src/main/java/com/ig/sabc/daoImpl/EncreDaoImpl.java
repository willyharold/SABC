/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.daoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.ig.sabc.dao.IEncreDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Imprimante;
import java.util.Date;
import java.util.List;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
public class EncreDaoImpl extends GenericDao<Encre, Long> implements IEncreDao{

    public List<Encre> encrebyimp(Long id) throws DataAccessException {
         return (List<Encre>)(getManager().createNamedQuery("encre.Byimprimante").setParameter("param", id).getResultList());
    }

    public List<Encre> encrebydate(Date date1, Date date2) throws DataAccessException {
                 return (List<Encre>)(getManager().createNamedQuery("encre.Bydate").setParameter("param1", date1,TemporalType.DATE).setParameter("param2", date2,TemporalType.DATE).getResultList());
    }
    
}
