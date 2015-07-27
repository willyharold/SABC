/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;
import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.ICategorieDao;
import com.ig.sabc.daoImpl.CategorieDaoImpl;
import com.ig.sabc.entities.ImprimanteCategorie;
import com.ig.sabc.service.ICategorieServ;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class CategorieServImpl implements ICategorieServ{
    
    private ICategorieDao categorie;

    public ICategorieDao getCategorie() {
        return categorie;
    }

    public void setCategorie(ICategorieDao categorie) {
        this.categorie = categorie;
    }

   
    public ImprimanteCategorie findById(Long id) throws DataAccessException {
        return categorie.findById(id);
    }

    public List<ImprimanteCategorie> findAll() throws DataAccessException {
        return categorie.findAll();
    }

    public ImprimanteCategorie create(ImprimanteCategorie t) throws DataAccessException {
        return categorie.create(t);
    }

    public void delete(ImprimanteCategorie t) throws DataAccessException {
        categorie.delete(t);
    }

    public ImprimanteCategorie update(ImprimanteCategorie t) throws DataAccessException {
        return categorie.update(t);
    }

    public void delete(Long t) throws DataAccessException {

        categorie.delete(categorie.findById(t));
    }
    
}
