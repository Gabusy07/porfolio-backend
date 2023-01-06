package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;



import javax.transaction.Transactional;

import java.security.NoSuchAlgorithmException;

import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@Repository
@Transactional
public interface Userdao {


    void editUser(int id, User editedUser);

    void deleteUser(int id);

    void addUser(User u) throws SQLException;

    User getUser(int id) ;
    int getIDFromUser(String email) throws NoSuchAlgorithmException, InvalidKeySpecException;
    User getUserDataByEmail(User u) throws NoSuchAlgorithmException, InvalidKeySpecException;

}
