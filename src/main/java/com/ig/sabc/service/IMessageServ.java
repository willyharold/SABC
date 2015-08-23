/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.service;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IMessageDao;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Message;
import java.util.List;

/**
 *
 * @author root
 */
public interface IMessageServ{
    
    public Message findById(Long id) throws DataAccessException;
    
    public List<Message> findAll() throws DataAccessException;
    
    public Message create(Message t) throws DataAccessException;
    
    public void delete(Message t) throws DataAccessException;
    
    public void delete(Long t) throws DataAccessException;
    
    public Message update(Message t) throws DataAccessException;
    
    public void messageAlerte_noir(Imprimante i, int conso) throws DataAccessException;
    
    public void messageAlerte_couleur(Imprimante i, int conso) throws DataAccessException;
    
    public void messageAlerte_papier(Imprimante i, int conso) throws DataAccessException;
}
