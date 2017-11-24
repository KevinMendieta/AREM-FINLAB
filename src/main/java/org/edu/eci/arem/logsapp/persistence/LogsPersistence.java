/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapp.persistence;

import java.util.List;

/**
 *
 * @author KevinMendieta
 */
public interface LogsPersistence {
    
    public void storeMessage(String message);
    
    public List<String> extractAllMessages();
    
}
