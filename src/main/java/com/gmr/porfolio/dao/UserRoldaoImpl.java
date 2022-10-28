package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserRol;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;

@Repository
@Transactional
public class UserRoldaoImpl implements UserRoldao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Set<UserRol> getData(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return null;
    }

    @Override
    public void editUserRol(Long id, UserRol edited) throws NoSuchAlgorithmException, InvalidKeySpecException {

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
