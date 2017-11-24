/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapi;

import org.edu.eci.arem.logsapp.services.LogsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author KevinMendieta
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.edu.eci.arem.logsapp"})
public class LogsAPIApplication {
    
    private static LogsServices logServices;
    
    public static void main(String[] args) {
        SpringApplication.run(LogsAPIApplication.class, args);        
    }
    
    @Autowired
    public void setLogServices(LogsServices logServices) {
        this.logServices = logServices;
    }

}
