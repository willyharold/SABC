/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IImprimanteDao;
import com.ig.sabc.daoImpl.ImprimanteDaoImpl;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.service.IImprimanteServ;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class ImprimanteServImpl implements IImprimanteServ{
    
    private IImprimanteDao imprimante;

    public IImprimanteDao getImprimante() {
        return imprimante;
    }

    public void setImprimante(IImprimanteDao imprimante) {
        this.imprimante = imprimante;
    }


    
    public Imprimante findById(Long id) throws DataAccessException {
        return imprimante.findById(id);
    }

    public List<Imprimante> findAll() throws DataAccessException {
        return imprimante.findAll();
    }

    public Imprimante create(Imprimante t) throws DataAccessException {
        return imprimante.create(t);
    }

    public void delete(Imprimante t) throws DataAccessException {
        imprimante.delete(t);
    }

    public Imprimante update(Imprimante t) throws DataAccessException {
        return imprimante.update(t);
    }

    public Imprimante findByiden(String t) throws DataAccessException {
        return imprimante.FindByiden(t);
    }

    public void delete(Long id) throws DataAccessException {
        imprimante.delete(imprimante.findById(id));
    }
    
    
}
