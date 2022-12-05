package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserRol;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

@Repository
@Transactional
public interface UserRoldao {

    public ArrayList<String> getRoles(int id) throws NoSuchAlgorithmException, InvalidKeySpecException;


    public void deleteUserRol(int id) throws NoSuchAlgorithmException, InvalidKeySpecException;
    public void addUserRol(UserRol userRol);
    boolean isRolAdmin(int id) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean isRolGuess(int id) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean isRolCommon(int id) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
