/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Etat;
import com.ig.sabc.entities.Message;
import com.ig.sabc.service.IMessageServ;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author root
 */

@ManagedBean
@RequestScoped
public class MessagerieBean implements SelectableDataModel<Message>{

    @ManagedProperty(value = "#{IMessageServ}")
    IMessageServ messageServ;
    List<Message> messages = new LinkedList<Message>();
    Message message = new Message();
    
    
    public void MessagerieBean(){
        
    }
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
 
    public IMessageServ getMessageServ() {
        return messageServ;
    }

    public void setMessageServ(IMessageServ messageServ) {
        this.messageServ = messageServ;
    }

    public List<Message> getMessages() {
        try {
            messages = messageServ.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(MessagerieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }
    
    public void supprimer(){
        try {
            messageServ.delete(message.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "La suppression a été éffectué correctement."));

        } catch (DataAccessException ex) {
            Logger.getLogger(MessagerieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    public void modifier(){
        message.setStatus(Etat.LU);
        try {
            messageServ.update(message);
        } catch (DataAccessException ex) {
            Logger.getLogger(MessagerieBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
            
    public Object getRowKey(Message t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Message getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
