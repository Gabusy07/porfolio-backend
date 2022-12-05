package com.gmr.porfolio.services;

import com.gmr.porfolio.dao.UserRoldao;
import com.gmr.porfolio.dao.Userdao;
import com.gmr.porfolio.models.User;
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

    @Autowired
    Userdao userdao;

    public  ArrayList<String> getUserRoles(int user_id) throws NoSuchAlgorithmException, InvalidKeySpecException {

        ArrayList<String> roles = new ArrayList<>(userRoldao.getRoles(user_id));
        return roles;

    }

    public void setUserRoles(String userName, int userID){
        UserRol uRol = new UserRol();
        uRol.setUserID(userID);
        uRol.setRol("common");
        userRoldao.addUserRol(uRol);

    }

    public void deleteUserRoles(int idUser, int lenRoles) throws NoSuchAlgorithmException, InvalidKeySpecException {
        for (int i=0; i< lenRoles; i++){
            userRoldao.deleteUserRol(idUser);
        }
    }
}
