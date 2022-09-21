package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface Userdao {


    void editUser(Long id);

    void deleteUser(Long id);

    void addUser(User u);

    User getUserData(User u) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
