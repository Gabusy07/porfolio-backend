package com.gmr.porfolio.services;

import com.gmr.porfolio.dao.UserRoldao;
import com.gmr.porfolio.models.UserRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

@Service
public class UserRolService {
    @Autowired
    UserRoldao userRoldao;

    public  ArrayList<String> getUserRoles(Long user_id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ArrayList<String> roles = new ArrayList<>(userRoldao.getRoles(user_id));

        return roles;

    }

    public void setUserRoles(String userName, Long idUser){
        UserRol uRol = new UserRol();
        uRol.setIdUser(idUser);
        if (userName == "invitado"){
            uRol.setRol("guess");
        }else{
            uRol.setRol("common");
            userRoldao.addUserRol(uRol);
            uRol.setRol("guess"); //asegura que el usuario tenga dos roles
            userRoldao.addUserRol(uRol);
        }
    }

    public void deleteUserRoles(Long  userId) throws NoSuchAlgorithmException, InvalidKeySpecException {
        userRoldao.deleteUserRol(userId);
    }
}
