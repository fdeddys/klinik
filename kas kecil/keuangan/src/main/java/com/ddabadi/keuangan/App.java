/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddabadi.keuangan;

import com.ddabadi.keuangan.view.FrmLogin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author win7
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static ApplicationContext context;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.setVisible(true);
        
        
    }
    
}
