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


    void editUser(Long id, User editedUser);

    void deleteUser(Long id);

    void addUser(User u) throws SQLException;

    User getUserData(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException;

}
