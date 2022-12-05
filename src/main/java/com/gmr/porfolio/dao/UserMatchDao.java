package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserMatch;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;


@Repository
@Transactional
public interface UserMatchDao {

    public List<UserMatch> getAll();

    public UserMatch getData(int id) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public void editUserMatch(int id, UserMatch edited) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public void deleteUserMatch(int idUser) throws NoSuchAlgorithmException, InvalidKeySpecException;

    public void addUserMatch(UserMatch userMatch);
}
