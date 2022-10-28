package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserRol;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;

@Repository
@Transactional
public interface UserRoldao {

    public Set<UserRol> getData(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public void editUserRol(Long id, UserRol edited) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public void deleteUserRol(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public void addUserRol(UserRol userRol);
}