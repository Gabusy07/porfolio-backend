package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Description;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        em.close();
        return list;
    }

    @Override
    public void editDescription(Long id, Description editedDesc) {
        Description desc = em.find(Description.class, id);
        desc.setText(editedDesc.getText());
        desc.setTitle(editedDesc.getTitle());
        desc.setPhoto(editedDesc.getPhoto());
        em.merge(desc);
        em.close();
    }

    @Override
    public void deleteDescription(Long id) {
        Description desc = em.find(Description.class, id);
        em.remove(desc);
        em.close();

    }

    @Override
    public void addDescription(Description desc) {
        em.merge(desc);
        em.close();
    }
}
