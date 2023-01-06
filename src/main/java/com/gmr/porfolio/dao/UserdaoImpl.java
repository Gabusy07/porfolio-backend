package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


import java.util.List;

@Service
@Repository
@Transactional
public class UserdaoImpl implements Userdao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void editUser(int id, User editedUser) {
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
    public void deleteUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
    }

    @Override
    public void addUser(User u) {
        //agrega a DDBB
        em.persist(u);
    }

    public User getUser(int id){
        User u = em.find(User.class, id);
        return u;
}

    @Override
    public int getIDFromUser(String email) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "Select id FROM User m WHERE m.email= :email"; // clase User consulta a hibernate
        final List list = em.createQuery(query).setParameter("email", email).getResultList();
        if (list.isEmpty()) {
            return -1;
        }
        return (int) list.get(0);

    }

    @Override
    public User getUserDataByEmail(User u) throws NoSuchAlgorithmException, InvalidKeySpecException {

        String query = "FROM User WHERE email= :email";
        final List list = em.createQuery(query).setParameter("email", u.getEmail()).getResultList();

        if (list.isEmpty()) {
            System.out.println("not found");
            return null;
        }
        User user = (User) list.get(0);
        if (Encrypt.validatePassword(u.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }

}

