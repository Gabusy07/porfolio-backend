package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Repository
@Transactional
public class UserdaoImpl implements Userdao {

    @PersistenceContext
    EntityManager entManager;

    @Override
    public void editUser(Long id) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void addUser(User u) {

    }

    @Override
    public User getUserData(User u) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String query = "FROM User WHERE id= :id";
        final List list = entManager.createQuery(query).setParameter("id", u.getId())
                .getResultList();

        if (list.isEmpty()) {
            return null;
        }


        User user = (User) list.get(0);
        String hashedPass = user.getPassword();
        if (Encrypt.validatePassword(u.getPassword(), hashedPass)) {
            return user;
        }
        return null;
    }
}
