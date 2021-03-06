/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Imprimante;
import java.util.Date;
import java.util.List;

/**
 *
 * @author root
 */
public interface IEncreDao extends IDao<Encre, Long>{
   
    public List<Encre> encrebyimp(Long id) throws DataAccessException;
   
    public List<Encre> encrebydate(Date date1,Date date2) throws DataAccessException;
    
    public List<Encre> encrebytype(Date date1,Date date2, Enum type ) throws DataAccessException;
    
    public int detect_encre_noir(Imprimante i) throws DataAccessException;
    
    public int detect_encre_couleur(Imprimante i) throws DataAccessException;
}

