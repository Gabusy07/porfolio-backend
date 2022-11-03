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
    public ArrayList<String> getRoles(Long user_id) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "SELECT rol FROM UserRol WHERE user_id= :user_id";
        final ArrayList<String> list = (ArrayList<String>) em.createQuery(query).setParameter("user_id", user_id).getResultList();
        return list;
    }



    @Override
    public void deleteUserRol(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Long id = getIDFromUser(idUser);
        em.remove(em.find(UserRol.class, id));
        em.close();

    }

    @Override
    public void addUserRol(UserRol userRol) {
        em.merge(userRol);
        em.close();
    }

    private Long getIDFromUser(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "Select id FROM UserRol m WHERE m.UserID= :idUser"; // clase User consulta a hibernate
        final List list =  em.createQuery(query).setParameter("idUser", idUser).getResultList();
        if (list.isEmpty()) {
            em.close();
        }
        return (Long) list.get(0);

    }
}
