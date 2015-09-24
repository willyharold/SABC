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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class StatistiqueAnneeBean implements Serializable{
 
    @ManagedProperty(value = "#{IEncreServ}")
    IEncreServ encreServ;
    Encre encre = new Encre();
    private String type_encre;
    private List<Encre> encres = new LinkedList<Encre>();
    
    @ManagedProperty(value = "#{IPapierServ}")
    IPapierServ papierServ;
    Papier papier = new Papier();
    private List<Papier> papiers = new LinkedList<Papier>();        
    
    private String année = new String();

    private LineChartModel dataModel;
    
    public LineChartModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(LineChartModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getAnnée() {
        return année;
    }

    public void setAnnée(String année) {
        this.année = année;
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
//       try {
//            encres = encreServ.findAll();
//        } catch (DataAccessException ex) {
//            Logger.getLogger(EncreBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return encres;
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
//        try {
//            papiers = papierServ.findAll();
//        } catch (DataAccessException ex) {
//            Logger.getLogger(PapierBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return papiers;
    }

    public void setPapiers(List<Papier> papiers) {
        this.papiers = papiers;
    }
 
    public StatistiqueAnneeBean() throws DataAccessException{      
        
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
    
    private LineChartModel initLinearModel() throws DataAccessException {
        LineChartModel model = new LineChartModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Consommation en encre");
        
        for (Encre encre1 : getEncres()) {
            series1.set(dateFormat.format(encre1.getDate_debut().getTime()),encre1.getNbr_encre());
        }

 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Consommation en rame de papier");
        
        for (Papier p: getPapiers()) {
            series2.set(dateFormat.format(p.getDate_debut().getTime()),p.getNbr_papier());
        }
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
}
