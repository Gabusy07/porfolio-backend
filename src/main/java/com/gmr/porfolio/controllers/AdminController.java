package com.gmr.porfolio.controllers;


import com.gmr.porfolio.dao.Admindao;
import com.gmr.porfolio.models.Admin_user;
import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/admin")
public class AdminController {

    @Autowired
    private Admindao admindao;
    @Autowired
    private JWTutil jwt;

    @PostMapping("/add")
    public String addAdmin(@RequestBody Admin_user a) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        String passw = Encrypt.generateStrongPasswordHash(a.getPassword());
        a.setPassword(passw);
        admindao.addAdmin(a);
        return "success";
    }

    @GetMapping("/data/{id}")
    public Admin_user getAdminData(@RequestBody Admin_user a, @RequestHeader(value = "Authorization") String token)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        if (verifyToken(token)){
            return admindao.getAdminData(a);
        }
        return null;


    }

    @DeleteMapping(value = "/delete/{id}")
    public String  deleteAdmin(@PathVariable Long id, @RequestHeader(value = "Authorization") String token) {

        if (verifyToken(token)){
            admindao.deleteAdmin(id);
            return "success";
        }
        return "FAIL";


    }


    @PatchMapping(value = "/update/{id}")
    public String updateUser(@RequestBody Admin_user a, @PathVariable("id") Long id,
                             @RequestHeader(value = "Authorization") String token) {
        // recibe el id del administrador y los datos nuevos


        if (verifyToken(token)){
            admindao.editAdmin(id, a);
            return "success";
        }
        return "FAIL";

    }

    private boolean verifyToken(String token) {
        String userId = jwt.getKey(token);
        return userId != null;

    }

}
