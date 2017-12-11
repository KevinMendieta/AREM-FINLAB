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
import org.springframework.stereotype.Service;

/**
 * @author KevinMendieta
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.edu.eci.arem.logsapp"})
public class LogsAPIApplication {

    public static void main(String[] args) {
        LogsAPIApplication ap = new LogsAPIApplication();
        ap.run();
        System.out.println("lol");
        SpringApplication.run(LogsAPIApplication.class, args);
    }
    
    public void run() {
        HelloWorldConsumer hl = new HelloWorldConsumer();
        hl.start();
    }

}
