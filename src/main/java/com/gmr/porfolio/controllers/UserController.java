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

import static java.lang.Integer.parseInt;


@CrossOrigin(origins="${host}", maxAge = 3600)

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
        int id = userdao.getIDFromUser(u.getEmail());
        String name = u.getName();
        _userMatch.setDataMatch(id);
        _userRol.setUserRoles(name, id);


    }

    @GetMapping("/data")
    public User getUser(@RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            User user = userdao.getUser(parseInt(id));

            UserMatch matchData = _userMatch.getDataMatch(parseInt(id));
            ArrayList<String> roles = _userRol.getUserRoles(parseInt(id));

            user.setRoles(roles);
            user.setPoints(matchData.getPoints());
            user.setAvatar(matchData.getAvatar());

            return user;
        }
        return null;

    }

    @DeleteMapping(value = "/delete")
    public void  deleteUser( @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)){
            int lenRoles = _userRol.getUserRoles(parseInt(id)).size();
            _userMatch.deleteUserMatch(parseInt(id));
            _userRol.deleteUserRoles(parseInt(id), lenRoles);
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
