/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.eci.arem.logsapp.controllers;

import javax.xml.ws.Response;
import org.edu.eci.arem.logsapp.services.LogsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KevinMendieta
 */
@RestController
@Service
@RequestMapping(value = "/logs")
public class LogsAPIController {
    
    private LogsServices logServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> extractMessages() {
        return new ResponseEntity<>(logServices.extractAllMessages(), HttpStatus.ACCEPTED);
    }
    
    @Autowired
    public void setLogServices(LogsServices logServices) {
        this.logServices = logServices;
    }

}
