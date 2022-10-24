package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Descriptiondao;
import com.gmr.porfolio.models.Description;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/description")
public class DescriptionController {
    @Autowired
    Descriptiondao descriptiondao;
    @Autowired
    JWTutil jwt;
    @GetMapping("/desc")
    public ArrayList getDescription(@RequestHeader(value = "Authorization") String token) {ArrayList description = descriptiondao.readDescription();
        return description;
    }

    @PatchMapping("add")
    public void addDescription(@RequestBody Description desc, @RequestHeader(value = "Authorization") String token){

    }
}
