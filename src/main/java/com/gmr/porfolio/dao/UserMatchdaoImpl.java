package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.UserMatch;
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
public class UserMatchdaoImpl implements UserMatchDao{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<UserMatch> getAll() {
        String query = "FROM User_match"; // clase User consulta a hibernate
        ArrayList result = (ArrayList) em.createQuery(query).getResultList();
        return result;
    }

    @Override
    public UserMatch getData(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {

        Long id = getIDFromUser(idUser);
        return  em.find(UserMatch.class, id);

    }

    @Override
    public void editUserMatch(Long idUser, UserMatch edited) throws NoSuchAlgorithmException, InvalidKeySpecException {

        UserMatch m = em.find(UserMatch.class, idUser);
        m.setPoints(edited.getPoints());
        m.setAvatar((edited.getAvatar()));
        em.merge(m);
        em.close();

    }

    @Override
    public void deleteUserMatch(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Long id = getIDFromUser(idUser);
        em.remove(em.find(UserMatch.class, id));
        em.close();
        id = getIDFromUser(idUser);
        em.remove(em.find(UserMatch.class, id));


    }

    @Override
    public void addUserMatch(UserMatch userMatch) {
        em.merge(userMatch);

    }



    private Long getIDFromUser(Long idUser) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "Select id FROM UserMatch m WHERE user_id= :idUser"; // clase User consulta a hibernate
        final List list =  em.createQuery(query).setParameter("idUser", idUser).getResultList();
        return (Long) list.get(0);

    }
}
