package com.gmr.porfolio.controllers;


import com.gmr.porfolio.dao.UserMatchDao;
import com.gmr.porfolio.models.UserMatch;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/user_match")
public class UserMatchController {
    @Autowired
    private UserMatchDao userMatchdao;

    @Autowired
    private JWTutil jwt;

    @GetMapping("/data")
    public UserMatch getMatchData(@RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String id = jwt.getKey(token);
        if (verifyToken(token)){
            UserMatch m = userMatchdao.getData(Long.valueOf(id));
            return m;
        }
        return null;

    }

    @PatchMapping("/update")
    public void updateMatch(@RequestBody UserMatch edited,
            @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String id = jwt.getKey(token);
        if (verifyToken(token)) {
            userMatchdao.editUserMatch(Long.valueOf(id), edited);
        }

    }



    private boolean verifyToken(String token) {
        String userId = jwt.getKey(token);
        return userId != null;

    }
}
