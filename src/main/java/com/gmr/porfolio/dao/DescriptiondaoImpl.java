package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;

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
        Description desc=
        em.merge( Description.builder()
                .title(editedDesc.getTitle())
                .text(editedDesc.getText())
                .photo(editedDesc.getPhoto())
                .urlPhoto(editedDesc.getUrlPhoto())
                .language(editedDesc.getLanguage()).build());
    }


    private boolean tableLen(){
        String query = "SELECT COUNT(*) FROM Description";
        Query q = em.createQuery(query);
        q.executeUpdate();
        return true;
    }



}
