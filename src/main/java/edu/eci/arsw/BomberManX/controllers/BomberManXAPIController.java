/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.BomberManX.controllers;

import edu.eci.arsw.BomberManX.services.BomberManXServices;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kvn CF <ECI>
 */

@RestController
@RequestMapping(value = "/sala")
public class BomberManXAPIController {
    @Autowired
    BomberManXServices gc=null;
    
    /**
     * Responde a a una petición get todos los Blueprints del author
     * @param author
     * @param model
     * @return
     */
    @RequestMapping(path = "/{id_sala}/{jugador}", method = RequestMethod.GET)
    public ResponseEntity<?> getForAuthor(@PathVariable String author, Model model){
        try {     
            Set<Jugador> data = gc.getBlueprintsByAuthor(author);
            if(data.isEmpty())throw new Exception("NOT FOUND");
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not Found User:" +author, HttpStatus.NOT_FOUND);

        }

    }
}