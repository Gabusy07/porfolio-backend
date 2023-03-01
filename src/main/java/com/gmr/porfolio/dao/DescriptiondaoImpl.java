package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import com.gmr.porfolio.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class DescriptiondaoImpl implements Descriptiondao {

    @PersistenceContext
    private EntityManager em;
    @Override
    @Transactional
    public ArrayList<Description> readDescription() {
        String query = "FROM Description"; // clase User consulta a hibernate
        ArrayList list = (ArrayList) em.createQuery(query).getResultList();
        return list;
    }

    @Override
    @Transactional
    public void replaceDescription( Description editedDesc) {
        String query = "DELETE FROM Description";
        Query q = em.createQuery(query);
        q.executeUpdate();
        System.out.println(q);
        Description desc=
        em.merge(new Description.Builder()
                .setTitle(editedDesc.getTitle())
                .setText(editedDesc.getText())
                .setPhoto(editedDesc.getPhoto())
                .setUrlPhoto(editedDesc.getUrlPhoto())
                .setLanguage(editedDesc.getLanguage()).build());
    }


    private boolean tableLen(){
        String query = "SELECT COUNT(*) FROM Description";
        Query q = em.createQuery(query);
        q.executeUpdate();
        return true;
    }



}
