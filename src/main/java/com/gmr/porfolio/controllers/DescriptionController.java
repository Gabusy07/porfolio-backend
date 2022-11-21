package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Descriptiondao;
import com.gmr.porfolio.models.Description;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@CrossOrigin(origins="${host}")
@RestController
@RequestMapping("/porfolio/*/description")
public class DescriptionController {
    @Autowired
    Descriptiondao descriptiondao;
    @Autowired
    JWTutil jwt;
    @GetMapping("/read")
    public ArrayList getDescription(@RequestHeader(value = "Authorization") String token) {ArrayList description = descriptiondao.readDescription();
        if (jwt.verifyToken(token)) {
            return description;
        }
        return null;
    }



    @PatchMapping("/update/{id}")
    public void updateDescription(@RequestBody Description editedDesc,
                                  @PathVariable Long id,
                                  @RequestHeader(value="Authorization") String token ){

        if (jwt.verifyToken(token)){
            descriptiondao.editDescription(id, editedDesc);
        }
    }

}
