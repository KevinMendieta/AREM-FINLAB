/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapp.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.edu.eci.arem.logsapp.persistence.LogsPersistence;
import org.springframework.stereotype.Service;

/**
 *
 * @author KevinMendieta
 */
@Service
public class InMemoryLogsPersistence implements LogsPersistence{
    
    private static final ConcurrentLinkedDeque<String> messages = new ConcurrentLinkedDeque<>();;
    
    public InMemoryLogsPersistence() {
        messages.add("Email enviado a sebastian.moreno@gmail.com");
        messages.add("Email enviado a prueba@mail.com");
        messages.add("Email enviado a xdkevinxd12@gmail.com");
    }

    @Override
    public void storeMessage(String message) {
        messages.add(message);
    }

    @Override
    public List<String> extractAllMessages() {
        ArrayList<String> newMessages = new ArrayList<>();
        for(String msg : messages) {
            newMessages.add(msg);
        }
        return newMessages;
    }
    
}
