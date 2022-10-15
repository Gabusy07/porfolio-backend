package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.Token;
import com.gmr.porfolio.models.User;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/api")
public class AuthUserController  {

    @Autowired
    private Userdao userdao;
    @Autowired
    private JWTutil jwt;

    @PostMapping("/login")
    public ResponseEntity<Token> loginUser(@RequestBody User u) {

        try {
            User checkedUser = userdao.getUserData(u);
            if (checkedUser != null) {
                String t = jwt.create(String.valueOf(checkedUser.getId()), checkedUser.getEmail()); // generando un
                // token devuelto para ser almacenado en cliente
                Token token = new Token(t);
                return new ResponseEntity<Token>(token, HttpStatus.OK);
            } else {
                return new ResponseEntity<Token>((Token) null, HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return new ResponseEntity<Token>((Token) null, HttpStatus.BAD_REQUEST);
        }
    }
}

