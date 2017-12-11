/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
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
        LogsAPIApplication ap = new LogsAPIApplication();
        ap.run();
        System.out.println("lol");
        SpringApplication.run(LogsAPIApplication.class, args);
    }

    public void run() {
        HelloWorldConsumer hl = new HelloWorldConsumer(logServices);
        hl.start();
    }

    @Autowired
    public void setLogServices(LogsServices logServices) {
        this.logServices = logServices;
    }

}
