package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.sql.SQLException;

@Repository
@Transactional
public interface Userdao {


    void editUser(Long id);

    void deleteUser(Long id);

    void addUser(User u) throws SQLException;

    User getUserData(Long id); //throws NoSuchAlgorithmException, InvalidKeySpecException

}
