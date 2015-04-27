/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan.controller;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author win7
 */
public class ReportController {
   
     public static void previewReport(String namaReport, Map parameter, List dataSource , String judul){

        try {
            JasperPrint jasperPrint  = JasperFillManager.fillReport(namaReport, parameter,
                    new JRBeanCollectionDataSource(dataSource)
            );
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setTitle(judul);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
