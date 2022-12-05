package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class DescriptiondaoImpl implements Descriptiondao {

    @PersistenceContext
    private EntityManager em;
    @Override
    public ArrayList<Description> readDescription() {
        String query = "FROM Description"; // clase User consulta a hibernate
        ArrayList list = (ArrayList) em.createQuery(query).getResultList();
        return list;
    }

    @Override
    public void editDescription(int id, Description editedDesc) {
        Description desc = em.find(Description.class, id);
        if(desc != null){
            desc.setText(editedDesc.getText());
            desc.setTitle(editedDesc.getTitle());
            desc.setPhoto(editedDesc.getPhoto());
            desc.setUrlPhoto(editedDesc.getUrlPhoto());
            tableLen();
            em.merge(desc);
        }
        else{
            desc = new Description();
            desc.setText(editedDesc.getText());
            desc.setTitle(editedDesc.getTitle());
            desc.setPhoto(editedDesc.getPhoto());
            desc.setUrlPhoto(editedDesc.getUrlPhoto());
            tableLen();
            em.merge(desc);
        }

    }


    private boolean tableLen(){
        String query = "SELECT COUNT(*) FROM Description";
        Query len = em.createQuery(query);
        return true;
    }

}
