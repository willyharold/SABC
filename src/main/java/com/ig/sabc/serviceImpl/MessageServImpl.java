/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.serviceImpl;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.dao.IMessageDao;
import com.ig.sabc.entities.Etat;
import com.ig.sabc.entities.Imprimante;
import com.ig.sabc.entities.Message;
import com.ig.sabc.service.IMessageServ;
import java.util.Calendar;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author root
 */
@Transactional
public class MessageServImpl implements IMessageServ{
    private IMessageDao message;

    public IMessageDao getMessage() {
        return message;
    }

    public void setMessage(IMessageDao message) {
        this.message = message;
    }
    
    
    
    public Message findById(Long id) throws DataAccessException {
        return message.findById(id);
    }

    public List<Message> findAll() throws DataAccessException {
        return message.findAll();
    }

    public Message create(Message t) throws DataAccessException {
        return message.create(t);
    }

    public void delete(Message t) throws DataAccessException {
        message.delete(t);
    }

    public Message update(Message t) throws DataAccessException {
        return message.update(t);
    }

    public void delete(Long t) throws DataAccessException {
        message.delete(message.findById(t));
    }
    
    public void messageAlerte_noir(Imprimante i, int conso) throws DataAccessException {
        String mes = "L'imprimante " + i.getIdentifiant() + " appartenant à .... a une consommation élévé par rapport à sa consommation abituelle. Sa consommation abituelle est de" + i.getCategorie().getNbre_encre() + " par mois. Il est déja consommé " + conso;
        Message msg = new Message();
        msg.setMessage(mes);
        msg.setDate_debut(Calendar.getInstance());
        msg.setStatus(Etat.NON_LU); 
        message.create(msg);
    }
}
