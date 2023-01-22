package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Contactdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="${host}")
@RestController
@RequestMapping("/porfolio/contact")
public class ContactController {
    @Autowired
    private Contactdao contactDAO;

    @GetMapping("/add")
    public ResponseEntity<?> addContact(){
        return null;
    }
}
