package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Knowledge;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional
public class KnowledgeDAOImpl implements KnowledgeDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public ArrayList<Knowledge> getAll() {
        String query = "FROM Knowledge"; // clase User consulta a hibernate
        ArrayList list = (ArrayList) em.createQuery(query).getResultList();
        return list;
    }

    @Override
    public void editKnowledge(int id, Knowledge editedKnw) {
        Knowledge knowledge = em.find(Knowledge.class, id);
        //knowledge.setName(editedKnw.getName());
        //knowledge.setProgressbar(editedKnw.getProgressbar());
        //knowledge.setDate(editedKnw.getDate());
        //knowledge.setWidth(editedKnw.getWidth());
        knowledge = new Knowledge.Builder().setId(knowledge.getId())
                        .setName(knowledge.getName())
                        .setDate(knowledge.getDate())
                       .setProgressbar(knowledge.getProgressbar())
                       .setWidth(knowledge.getWidth()).build();
        em.merge(knowledge);


    }

    @Override
    public void deleteKnowledge(int id) {
        Knowledge knw = em.find(Knowledge.class, id);
        em.remove(knw);

    }

    @Override
    public void addKnowledge(Knowledge knw) {
        em.persist(knw);
    }

}
