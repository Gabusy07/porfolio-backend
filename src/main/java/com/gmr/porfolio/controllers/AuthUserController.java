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

@CrossOrigin(origins="${host}")
@RestController
@RequestMapping("/porfolio/api")
public class AuthUserController  {

    @Autowired
    private Userdao userdao;

    @Autowired
    private JWTutil jwt;

    @PostMapping("/login")
    public Token loginUser(@RequestBody User u) throws NoSuchPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, BadPaddingException, InvalidKeyException, NoSuchProviderException {

        System.out.println(u);
        try {
            User checkedUser = userdao.getUserDataByEmail(u);
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

    @GetMapping("/logged")
    public boolean isLogged(@RequestHeader(value = "Authorization") String token) {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            return true;
        }
        return false;

    }

    //-----------------------------



    @GetMapping(value = "auth/guest")
    public Token guestToken(){
        Token token = new Token(jwt.create("0000", "xxx"));
        return token;
    }

    @GetMapping("/doesExistAdmin")
    public boolean existsAdmin(){
        return !userdao.getAll().isEmpty();

    }
}