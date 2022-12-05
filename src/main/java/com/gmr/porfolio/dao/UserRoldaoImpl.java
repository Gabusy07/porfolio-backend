package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserMatch;
import com.gmr.porfolio.models.UserRol;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRoldaoImpl implements UserRoldao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public ArrayList<String> getRoles(int userID) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "SELECT rol FROM UserRol WHERE user_id= :userID";
        final ArrayList<String> list = (ArrayList<String>) em.createQuery(query).setParameter("userID", userID).getResultList();
        return list;
    }



    @Override
    public void deleteUserRol(int idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int id = getIDFromUser(idUser);
        em.remove(em.find(UserRol.class, id));
    }

    @Override
    public void addUserRol(UserRol userRol) {
        em.merge(userRol);
    }

    private int getIDFromUser(int idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {


        String query = "Select rol_id FROM UserRol r WHERE r.user_id= :idUser"; // clase User consulta a hibernate
        final List list =  em.createQuery(query).setParameter("idUser", idUser).getResultList();
        return (int) list.get(0);

    }

    @Override
    public boolean isRolAdmin(int id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ArrayList roles = getRoles(id);
        return roles.contains("admin");
    }

    @Override
    public boolean isRolGuess(int id) throws NoSuchAlgorithmException, InvalidKeySpecException {

        ArrayList roles = getRoles(id);
        return roles.contains("guess");
    }

    @Override
    public boolean isRolCommon(int id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        ArrayList roles = getRoles(id);
        return roles.contains("common");
    }
}
