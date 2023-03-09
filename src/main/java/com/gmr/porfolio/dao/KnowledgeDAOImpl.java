package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Knowledge;
import com.gmr.porfolio.services.ProgressBarDetermine;
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
        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = editedKnw.getDate();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        System.out.println(progressbarAndWidth);

        String pb = (String) progressbarAndWidth.get(0);
        int width = (int) progressbarAndWidth.get(1);
        System.out.println(width+3);
        Knowledge knowledge = em.find(Knowledge.class, id);
        knowledge = new Knowledge.Builder().setId(knowledge.getId())
                        .setName(editedKnw.getName())
                        .setDate(editedKnw.getDate())
                       .setProgressbar(pb)
                       .setWidth(width).build();
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
