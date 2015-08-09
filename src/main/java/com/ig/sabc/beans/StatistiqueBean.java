/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ig.sabc.beans;

import com.douwe.generic.dao.DataAccessException;
import com.ig.sabc.entities.Encre;
import com.ig.sabc.service.IEncreServ;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
public class StatistiqueBean implements Serializable{
    
    private LineChartModel dataModel;
    private String année;
    
    @ManagedProperty(value = "#{IEncreServ}")
    IEncreServ encreServ;
    Encre encre = new Encre();
    private String type_encre;
    private List<Encre> encres = new LinkedList<Encre>();
    String année2 = new String();
    static String anneefinal = new String("hello");
    static String anneefinal2 = new String();

    public String getAnnée() {
        return année;
    }

    public void setAnnée(String année) {
        this.année = année;
    }

    public String getAnnée2() {
        return année2;
    }

    public void setAnnée2(String année2) {
        this.année2 = année2;
    }
    
    
    

    
    @PostConstruct
        public void init()   {
            createLineModels();
        }

    public LineChartModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(LineChartModel dataModel) {
        this.dataModel = dataModel;
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

    public List<Encre> getEncres() {
        return encres;
    }

    public void setEncres(List<Encre> encres) {
        this.encres = encres;
    }

    
    
    public void envoyer(){
       
        if(getAnnée()==null)
            année = "2015";
        année2 = année;        
        année = année + "-01"+"-01";
        année2 = année2+ "-12" + "-31";
        anneefinal = année;
        createLineModels();
//        année = "2015-01-01";
//        année2="2015-12-31"; 
       // createLineModels();
        
    }
    public void createLineModels() {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date d1 = null;
        Date d2 = null;
        if(getAnnée()==null)
            année = "2015";
        année2 = année;        
        année = année + "-01"+"-01";
        année2 = année2+ "-12" + "-31";
//quand je ne mets pas année dans cette methode, annéée est constament null! pourquoi??
        System.out.println(année);
        if(!(année==null)){
            
        try {
            d1 = dateFormat.parse(année);
            d2 = dateFormat.parse(année2);
        } catch (ParseException ex) {
            Logger.getLogger(StatistiqueBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            encres = encreServ.findbydate(d1, d2);
        } catch (DataAccessException ex) {
            Logger.getLogger(StatistiqueBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("serie 1");
        for (Encre encre1 : encres) {
            series1.set(dateFormat.format(encre1.getDate_debut().getTime()),encre1.getNbr_encre());
        }
        dataModel.addSeries(series1);
        dataModel.setTitle("Zoomer pour plus de détails");
        dataModel.setZoom(true);
        dataModel.getAxis(AxisType.Y).setLabel("Valeur");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax("2015-12-31");
        axis.setTickFormat("%b %#d, %y");
        
        dataModel.getAxes().put(AxisType.X, axis);
    }
        else{
            dataModel = new LineChartModel();
            LineChartSeries series1 = new LineChartSeries();
            dataModel.addSeries(series1);
            dataModel.setTitle("Zoomer pour plus de détails");
            dataModel.setZoom(true);
            dataModel.getAxis(AxisType.Y).setLabel("Valeur");
            DateAxis axis = new DateAxis("Dates");
            axis.setTickAngle(-50);
            axis.setMax("2015-12-31");
            axis.setTickFormat("%b %#d, %y");

            dataModel.getAxes().put(AxisType.X, axis);

        }
    }
    
}
