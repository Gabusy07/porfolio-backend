package com.gmr.porfolio.controllers;



import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;

import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;


@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/user")
public class UserController {
    @Autowired
    private Userdao userdao;
    @Autowired
    private JWTutil jwt;

    @PostMapping("/add")
    public String addUser(@RequestBody User u) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
        u.setPassword(passw);
        userdao.addUser(u);
        return "success";
    }

    @GetMapping("/data")
    public ResponseEntity<User> getUser(@PathVariable Long id,
                                        @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {

        if (verifyToken(token)){
            User user = userdao.getUser(id);
            return ResponseEntity.ok(user);
        }
        return null;



    }

    @DeleteMapping(value = "/delete/{id}")
    public String  deleteUser(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {

        if (verifyToken(token)){
            userdao.deleteUser(id);
            return "success";
        }
        return "FAIL";


    }


    @PatchMapping(value = "/update/{id}")
    public String updateUser(@RequestBody User u, @PathVariable("id") Long id,
                           @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // recibe el id del usuario y los datos nuevos del usuario


        if (verifyToken(token)){

            String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
            u.setPassword(passw);
            userdao.editUser(id, u);
            return "success";
        }
        return "FAIL";

    }

    private boolean verifyToken(String token) {
        String userId = jwt.getKey(token);
        return userId != null;

    }
}
