package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@Repository
@Transactional
public interface Userdao {


    void editUser(Long id, User editedUser);

    void deleteUser(Long id);

    void addUser(User u) throws SQLException;

    User getUserData(User u) throws NoSuchAlgorithmException, InvalidKeySpecException;

    User getUser(Long id) ;
    Long getIDFromUser(String email) throws NoSuchAlgorithmException, InvalidKeySpecException;

}
