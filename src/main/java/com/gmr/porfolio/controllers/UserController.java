package com.gmr.porfolio.controllers;



import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;

import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;


@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/porfolio/user"})
public class UserController {
    @Autowired
    private Userdao userdao;
    @Autowired
    private JWTutil jwt;

    @PostMapping(value = "api/add")
    public void addUser(@RequestBody User u) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
        u.setPassword(passw);
        userdao.addUser(u);
    }

    @GetMapping(value = "api/user_data")
    public User getUserData(User u, @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {

        boolean userLogg = false;
        try {
            userLogg = verifyToken(token);

        } catch (Exception e) {
            System.out.println(e);
        }
        if (userLogg) {
            return userdao.getUserData(u);
        }

        return null;
    }

    @DeleteMapping(value = "api/delete")
    public void  deleteUser(@PathVariable Long id,  @RequestHeader(value = "Authorization") String token) {
        if (verifyToken(token)) {
            userdao.deleteUser(id);
        }
    }


    @RequestMapping(value = "api/update")
    public void updateUser(@RequestBody Long id, User u,  @RequestHeader(value = "Authorization") String token){  // recibe el id del usuario y los datos nuevos del usuario
        if (verifyToken(token)) {
            userdao.editUser(id, u);
        }

    }

    private boolean verifyToken(String token) {
        String userId = jwt.getKey(token);
        return userId != null;

    }
}
