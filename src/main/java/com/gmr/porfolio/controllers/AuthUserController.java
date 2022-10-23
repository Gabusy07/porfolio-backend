package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.Token;
import com.gmr.porfolio.models.User;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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
    public Token loginUser(@RequestBody User u) throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, BadPaddingException, InvalidKeyException, NoSuchProviderException {

        try {
            User checkedUser = userdao.getUserData(u);
            if (checkedUser != null) {
                String t = jwt.create(String.valueOf(checkedUser.getId()), checkedUser.getEmail()); // generando un
                // token devuelto para ser almacenado en cliente
                Token token = new Token(t);
                return new Token(t);
            } else {
                return new Token("FAIL");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return new Token("FAIL");
        }


    }

}