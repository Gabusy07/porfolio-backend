package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Admin_user;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

@Repository
@Transactional
public interface Admindao {

    void editAdmin(Long id, Admin_user editedAdmin);

    void deleteAdmin(Long id);



    Admin_user getAdminData(Admin_user a) throws NoSuchAlgorithmException, InvalidKeySpecException;

    void addAdmin(Admin_user a) throws SQLException;
}