package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserRol;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

@Repository
@Transactional
public class UserRoldaoImpl implements UserRoldao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public ArrayList<String> getRoles(Long user_id) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "SELECT rol FROM UserRol WHERE user_id= :user_id";
        final ArrayList<String> list = (ArrayList<String>) em.createQuery(query).setParameter("user_id", user_id).getResultList();
        return list;
    }



    @Override
    public void deleteUserRol(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException {

    }

    @Override
    public void addUserRol(UserRol userRol) {
        em.merge(userRol);
        em.close();
    }
}
