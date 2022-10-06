package com.gmr.porfolio.controllers;



import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.dao.UserdaoImpl;
import com.gmr.porfolio.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Userdao userdao;

    public UserController() throws SQLException {
    }


    public void addUser(User u) throws SQLException {


        userdao.addUser(u);
    }

    public User getUser(){
        User data = userdao.getUserData(
                5373743454864848L
        );
        System.out.println(data);
        return data;
    }
}
