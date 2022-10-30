package com.gmr.porfolio.controllers;


import com.gmr.porfolio.dao.UserMatchDao;

import com.gmr.porfolio.models.UserMatch;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/user_match")
public class UserMatchController {
    @Autowired
    private UserMatchDao userMatchdao;

    @Autowired
    private JWTutil jwt;


    @PostMapping("/add")
    public void addUser(@RequestBody UserMatch m,
            @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {

        String userId = jwt.getKey(token);
        if (verifyToken(token)){
            m.setIdUser(Long.valueOf(userId));
            userMatchdao.addUserMatch(m);
        }
    }


    @GetMapping("/data")
    public UserMatch getMatchData(@RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String userId = jwt.getKey(token);
        if (verifyToken(token)){
            UserMatch m = userMatchdao.getData(Long.valueOf(userId));
            return m;
        }
        return null;

    }

    @PatchMapping("/update")
    public void updateMatch(@RequestBody UserMatch edited,
            @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String userId = jwt.getKey(token);
        if (verifyToken(token)) {
            userMatchdao.editUserMatch(Long.valueOf(userId), edited);
        }

    }

    @DeleteMapping("/delete")
    public void deleteMatch(@RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String userId = jwt.getKey(token);
        if (verifyToken(token)) {
            userMatchdao.deleteUserMatch(Long.valueOf(userId));
        }
    }



    private boolean verifyToken(String token) {
        String userId = jwt.getKey(token);
        return userId != null;

    }
}
