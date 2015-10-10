/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.entities.Papier;
import com.ig.sabc.service.IEncreServ;
import com.ig.sabc.service.IPapierServ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class StatistiqueMoisBean {
    @ManagedProperty(value = "#{IEncreServ}")
    IEncreServ encreServ;
    Encre encre = new Encre();
    private String type_encre;
    private List<Encre> encres = new LinkedList<Encre>();
    
    @ManagedProperty(value = "#{IPapierServ}")
    IPapierServ papierServ;
    Papier papier = new Papier();
    private List<Papier> papiers = new LinkedList<Papier>();        
    
    private String annee = new String();
    
    private String annee1 = new String();

    public String getAnnee1() {
        return annee1;
    }

    public void setAnnee1(String annee1) {
        this.annee1 = annee1;
    }
    
    private LineChartModel dataModel;
    
    public LineChartModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(LineChartModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public IEncreServ getEncreServ() {
        return encreServ;
    }

    public void setEncreServ(IEncreServ encreServ) {
        this.encreServ = encreServ;
    }

    public Encre getEncre() {
        return encre;
    }

    public void setEncre(Encre encre) {
        this.encre = encre;
    }

    public String getType_encre() {
        return type_encre;
    }

    public void setType_encre(String type_encre) {
        this.type_encre = type_encre;
    }

    public List<Encre> getEncres(){
       try {
            encres = encreServ.findAll();
            return encres;
        } catch (DataAccessException ex) {
            Logger.getLogger(EncreBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    public void setEncres(List<Encre> encres) {
        this.encres = encres;
    }

    public IPapierServ getPapierServ() {
        return papierServ;
    }

    public void setPapierServ(IPapierServ papierServ) {
        this.papierServ = papierServ;
    }

    public Papier getPapier() {
        return papier;
    }

    public void setPapier(Papier papier) {
        this.papier = papier;
    }

    public List<Papier> getPapiers() throws DataAccessException {
        try {
            papiers = papierServ.findAll();
            return papiers;
        } catch (DataAccessException ex) {
            Logger.getLogger(PapierBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    public void setPapiers(List<Papier> papiers) {
        this.papiers = papiers;
    }
 
    public StatistiqueMoisBean() throws DataAccessException{      
        //this.getEncres();
        dataModel = initLinearModel();
        dataModel.setTitle("Zoomer pour plus de détails");
        dataModel.setZoom(true);
        dataModel.getAxis(AxisType.Y).setLabel("Valeur");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax("2015-12-31");
        axis.setTickFormat("%b %#d, %y");
        
        dataModel.getAxes().put(AxisType.X, axis);  
        dataModel.setAnimate(true);
        dataModel.setLegendPosition("se");    
    }
    
    public void select(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        
        annee= "2015-"+annee+"-01";
        annee1= "2015-"+annee1+"-01";
       
        Date date1 =new Date();
        Date date2 =new Date();
        try {
            date1 = dateFormat.parse(annee);
            date2 = dateFormat.parse(annee1);
                      
        } catch (ParseException ex) {
            Logger.getLogger(StatistiqueAnneeBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "La date est incorrecte."));

        }
        
        try {
            encres = encreServ.findbydate(date1,date2);
            papiers=papierServ.papierby_date(date1, date2);
        } catch (DataAccessException ex) {
            Logger.getLogger(StatistiqueAnneeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        chargerdonnee();
        annee="";
        annee1="";
    }
    
    public void chargerdonnee(){
        
        dataModel = initLinearModel();       
        dataModel.setTitle("Zoomer pour plus de détails");
        dataModel.setZoom(true);
        dataModel.getAxis(AxisType.Y).setLabel("Valeur");
        
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax(annee1);
        axis.setMin(annee);
        axis.setTickFormat("%b %#d, %y");
        
        dataModel.getAxes().put(AxisType.X, axis);  
        dataModel.setAnimate(true);
        dataModel.setLegendPosition("se");    
    }
    
    private LineChartModel initLinearModel(){
        LineChartModel model = new LineChartModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Consommation en encre");

        
        for (Encre encre1 : encres) {
            series1.set(dateFormat.format(encre1.getDate_debut().getTime()),encre1.getNbr_encre());
        }

 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Consommation en rame de papier");
        
        for (Papier p: papiers) {
            series2.set(dateFormat.format(p.getDate_debut().getTime()),p.getNbr_papier());
        }
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
}
