package com.gmr.porfolio.controllers;



import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.*;
import com.gmr.porfolio.services.UserMatchService;
import com.gmr.porfolio.services.UserRolService;
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
import java.util.ArrayList;


@CrossOrigin(origins="https://porfolio-eced8.web.app", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/user")
public class UserController {
    @Autowired
    private Userdao userdao;



    @Autowired
    private UserMatchService _userMatch;

    @Autowired
    private JWTutil jwt;

    @Autowired
    private UserRolService _userRol;

    @PostMapping("/add")
    public void addUser(@RequestBody User u) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
        u.setPassword(passw);
        userdao.addUser(u);
        //Long id = userdao.getIDFromUser(u.getEmail());
        //String name = u.getName();
        //_userRol.setUserRoles(name, id);
        //_userMatch.setDataMatch(id);

    }

    @GetMapping("/data")
    public User getUser(@RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            User user = userdao.getUser(Long.valueOf(id));
            //ArrayList<String> roles = new ArrayList<>(_userRol.getUserRoles(user.getId()));
            //user.setRoles(roles);
           // UserMatch matchData = _userMatch.getDataMatch(Long.valueOf(id));
            //user.setAvatar(matchData.getAvatar());
            //user.setPoints(matchData.getPoints());
            return user;
        }
        return null;

    }

    @DeleteMapping(value = "/delete")
    public void  deleteUser( @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            //int lenRoles = userdao.getUserDataById(Long.valueOf(id)).getRoles().size();
            //_userMatch.deleteUserMatch(Long.valueOf(id));
            //_userRol.deleteUserRoles(Long.valueOf(id), lenRoles);
            userdao.deleteUser(Long.valueOf(id));

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
