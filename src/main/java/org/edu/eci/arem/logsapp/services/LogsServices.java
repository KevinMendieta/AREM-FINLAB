/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapp.services;

import java.util.List;
import org.edu.eci.arem.logsapp.persistence.LogsPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KevinMendieta
 */
@Service
public class LogsServices {

    private LogsPersistence persistence;
    
    public void storeMessage(String message) {
        persistence.storeMessage(message);
    }
    
    public List<String> extractAllMessages() {
        return persistence.extractAllMessages();
    }
    
    @Autowired
    public void setPersistence(LogsPersistence persistence) {
        this.persistence = persistence;
    }

}
