package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.*;

@Repository
@Transactional
public class UserdaoImpl implements Userdao {


    //Connection connector = DriverManager.getConnection("jdbc:mysql://localhost:3306/porfolio", "root", "S0011245633kap");

    @PersistenceContext
    EntityManager em;
    public UserdaoImpl() throws SQLException {
    }

    @Override
    public void editUser(Long id) {

    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void addUser(User u) throws SQLException {


        /*
        String SQL = "INSERT INTO user(id, name, lastname, nickname, email, password) "
                + "VALUES(?,?,?,?,?,?)";

        PreparedStatement pstmt = connector.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS); {

            pstmt.setLong(1, u.getId());
            pstmt.setString(2, u.getName());
            pstmt.setString(3, u.getLastname());
            pstmt.setString(4, u.getNickname());
            pstmt.setString(5, u.getEmail());
            pstmt.setString(6, u.getPassword());


        };

        pstmt.executeUpdate();*/





        System.out.println("llega");
        em.merge(u); //agregando a DDBB

        //connector.close();
    }

    @Override
    public User getUserData(Long id) {
        return null;


    }

}
