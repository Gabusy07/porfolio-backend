package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Admin_user;
import com.gmr.porfolio.models.Encrypt;
import com.gmr.porfolio.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class AdmindaoImpl implements Admindao{

    @Autowired
    Userdao userdao;
    @PersistenceContext
    private EntityManager em;
    @Override
    public void editAdmin(Long id, Admin_user editedAdmin) {
        Admin_user a = em.find(Admin_user.class, id);
        a.setName(editedAdmin.getName());
        a.setLastname(editedAdmin.getLastname());
        a.setNickname(editedAdmin.getNickname());
        a.setEmail(editedAdmin.getEmail());
        a.setPassword(editedAdmin.getPassword());
        em.merge(a);
        em.close();


    }

    @Override
    public void deleteAdmin(Long id) {
        Admin_user a = em.find(Admin_user.class, id);
        em.remove(a);
        em.close();

    }

    @Override
    public void addAdmin(Admin_user a) throws SQLException{
        Long id_user = null;
        User u= new User();
        u.setName(a.getName());
        u.setLastname(a.getLastname());
        u.setNickname(a.getNickname());
        u.setEmail(a.getEmail());
        u.setPassword(a.getPassword());

        //agrega a DDBB user al admin_user
        userdao.addUser(u);

        try {
            User user = userdao.getUserDataByEmail(u);
            id_user = user.getId();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        if (id_user != null){
            a.setUser_id(id_user);
            em.merge(a);

        }

        em.close();

    }

    @Override
    public Admin_user getAdminData(Admin_user a) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String query = "FROM User WHERE email= :email";
        final List list = em.createQuery(query).setParameter("email", a.getEmail()).getResultList();
        if (list.isEmpty()){
            em.close();
            return null;
        }

        Admin_user admin = (Admin_user) list.get(0);
        String hashedPass = admin.getPassword();
        if (Encrypt.validatePassword(a.getPassword(), hashedPass)) {
            em.close();
            return admin;
        }
        em.close();
        return null;
    }

}