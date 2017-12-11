package org.edu.eci.arem.logsapi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.edu.eci.arem.logsapp.services.LogsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2106457
 */
@Service
public class HelloWorldConsumer extends Thread implements ExceptionListener {

    private LogsServices logsServices;

    public HelloWorldConsumer(LogsServices logsServices) {
        this.logsServices = logsServices;
    }

    public void run() {
        try {

            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://ec2-52-32-88-131.us-west-2.compute.amazonaws.com:61616?jms.useAsyncSend=true");

            // Create a Connection
            Connection connection = connectionFactory.createConnection("smx", "smx");
            connection.start();

            connection.setExceptionListener(this);

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("salida");

            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination);

            // Wait for a message
            while (true) {
                Message message = consumer.receive();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String text = "La solicitud ha sido revisada " + dateFormat.format(date) + "\n";

                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    text += textMessage.getText();
                    System.out.println("Received: " + text);
                    logsServices.storeMessage(text);
                } else {
                    System.out.println("Received: " + message);
                }
                logsServices.storeMessage(text);
            }

        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
    
    @Autowired
    public void setLogsServices(LogsServices logsServices) {
        this.logsServices = logsServices;
    }
    
    
    
}
