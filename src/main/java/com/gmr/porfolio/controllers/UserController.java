package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.*;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;


@CrossOrigin(origins="${host}", maxAge = 3600)

@RestController
@RequestMapping("/porfolio/user")
public class UserController {
    @Autowired
    private Userdao userdao;

    @Autowired
    private JWTutil jwt;
    

    @PostMapping("/add")
    public void addUser(@RequestBody User u) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
        u.setPassword(passw);
        userdao.addUser(u);

    }

    @GetMapping("/data")
    public User getUser(@RequestHeader(value = "Authorization") String token) {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            return userdao.getUser(parseInt(id));
        }
        return null;

    }

    @DeleteMapping(value = "/delete")
    public void  deleteUser( @RequestHeader(value = "Authorization") String token) {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            userdao.deleteUser(parseInt(id));
        }
    }


    @PatchMapping(value = "/update")
    public void updateUser(@RequestBody User u,
                           @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // recibe el id del usuario y los datos nuevos del usuario


        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
            u.setPassword(passw);
            userdao.editUser(parseInt(id), u);
        }
    }

}
