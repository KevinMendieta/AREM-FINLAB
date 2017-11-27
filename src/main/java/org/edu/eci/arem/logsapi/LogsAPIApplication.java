/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnectionFactory;
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
    
    public static void main(String[] args) throws JMSException {
        SpringApplication.run(LogsAPIApplication.class, args);
        
        /*ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://ec2-52-32-88-131.us-west-2.compute.amazonaws.com");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Topic topic = session.createTopic("/logs");
        
        MessageConsumer consumer = session.createConsumer(topic);
     
        MessageListener listner = new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    logServices.storeMessage(textMessage.getText());
                } catch (JMSException ex) {
                    Logger.getLogger(LogsAPIApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        consumer.setMessageListener(listner);
        connection.close();*/
    }
    
    @Autowired
    public void setLogServices(LogsServices logServices) {
        this.logServices = logServices;
    }

}
