package com.gmr.porfolio.controllers;



import com.gmr.porfolio.dao.UserMatchDao;
import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
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
    private UserMatchDao userMatchdao;

    @Autowired
    private JWTutil jwt;

    @PostMapping("/add")
    public void addUser(@RequestBody User u) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
        u.setPassword(passw);
        userdao.addUser(u);
    }

    @GetMapping("/data")
    public User getUser(@RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {


        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            User user = userdao.getUser(Long.valueOf(id));
            return user;
        }
        return null;

    }

    @DeleteMapping(value = "/delete")
    public void  deleteUser( @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            userdao.deleteUser(Long.valueOf(id));
            userMatchdao.deleteUserMatch(Long.valueOf(id));
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
            userdao.editUser(Long.valueOf(id), u);

        }

    }


}
