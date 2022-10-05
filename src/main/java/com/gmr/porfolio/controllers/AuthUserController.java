package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.User;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AuthUserController {

    @Autowired
    private Userdao userDao;
    @Autowired
    private JWTutil jwt;

    @PostMapping("/api/login")
    public String loginUser(@RequestBody User u) {
        try {
            User checkedUser = userDao.getUserData(u.getId());
            if (checkedUser != null) {
                String token = jwt.create(String.valueOf(checkedUser.getId()), checkedUser.getEmail()); // generando un
                // token devuelto para ser almacenado en cliente
                return token;
            } else {
                return "FAIL";
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return "FAIL";
        }


    }
}
