package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.*;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Void> addUser(@RequestBody User u) {
        String passw = null;
        try {
            passw = Encrypt.generateStrongPasswordHash(u.getPassword());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println(e);
        }
        u = new User.Builder().setName(u.getName())
                .setLastname(u.getLastname())
                .setPassword(passw)
                .setEmail(u.getEmail())
                .setNickname(u.getNickname())
                .build();
        try {
            userdao.addUser(u);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @GetMapping("/data")
    public ResponseEntity getUser(@RequestHeader(value = "Authorization") String token) {
        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)) {
            return new ResponseEntity<User>(userdao.getUser(parseInt(id)), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("no se han moficado los datos", HttpStatus.NOT_MODIFIED);

    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteUser(@RequestHeader(value = "Authorization") String token) {

        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)) {
            userdao.deleteUser(parseInt(id));
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }


    @PatchMapping(value = "/update")
    public ResponseEntity updateUser(@RequestBody User u,
                                           @RequestHeader(value = "Authorization") String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // recibe el id del usuario y los datos nuevos del usuario
        String id = jwt.getKey(token);
        if (jwt.verifyToken(token)) {
            String passw = Encrypt.generateStrongPasswordHash(u.getPassword());
            if (userdao.editUser(parseInt(id), u, passw) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userdao.getAll();
        if (list != null) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }
}
