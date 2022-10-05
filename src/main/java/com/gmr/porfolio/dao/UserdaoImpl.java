package com.gmr.porfolio.dao;

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
    }


    @Override
    public void deleteUser(Long id) {
        User u = em.find(User.class, id);
        em.remove(u);

    }

    @Override
    public void addUser(User u) {
        //agrega a DDBB
        em.merge(u);
    }

    @Override
    public User getUserData(Long id) throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("dao");
        String query = "FROM User WHERE id = :id";
        final List<User> list = em.createQuery(query).setParameter("id", id).getResultList();
        if (list.isEmpty()){
            return null;
        }
        System.out.println(list);
        return list.get(0);

      }

}
