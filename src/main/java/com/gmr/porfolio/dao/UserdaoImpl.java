package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Repository
@Transactional
public class UserdaoImpl implements Userdao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void editUser(Long id, User editedUser) {
        User u = em.find(User.class, id);
        u.setName(editedUser.getName());
        u.setLastname(editedUser.getLastname());
        u.setNickname(editedUser.getNickname());
        u.setEmail(editedUser.getEmail());
        u.setPassword(editedUser.getPassword());
        em.merge(u);
        em.close();
    }


    @Override
    public void deleteUser(Long id) {
        User u = em.find(User.class, id);
        em.remove(u);
        em.close();

    }

    @Override
    public void addUser(User u) {
        //agrega a DDBB
        em.merge(u);
        em.close();
    }

    @Override
    public User getUserData(User u) throws NoSuchAlgorithmException, InvalidKeySpecException {


        String query = "FROM User WHERE email= :email";
        final List list = em.createQuery(query).setParameter("email", u.getEmail()).getResultList();

        if (list.isEmpty()) {
            System.out.println("vacio");
            em.close();
            return null;
        }

        User user = (User) list.get(0);

        if (Encrypt.validatePassword(u.getPassword(), user.getPassword()) ) {
            // revisar encrypting
            em.close();
            return user;
        }
        em.close();
        return user;
    }


}
