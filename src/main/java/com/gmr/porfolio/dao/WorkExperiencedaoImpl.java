package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.WorkExperience;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WorkExperiencedaoImpl implements WorkExperiencedao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addExperience(WorkExperience wkExp) {
        em.persist(wkExp);
    }

    @Override
    public WorkExperience getExperience(int id) {
        return em.find(WorkExperience.class, id);
    }

    @Override
    public List getAllExperiences() {
        String query = "FROM WorkExperience";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void editExperience(int id, WorkExperience wkExp) {
        WorkExperience exp = em.find(WorkExperience.class, id);
        WorkExperience newExp = new WorkExperience.Builder().setId(exp.getId()).setTitle(wkExp.getTitle()).setPlace(wkExp.getPlace())
                .setDescription(wkExp.getDescription()).setLang(wkExp.getLanguage()).build();
        //exp.setTitle(wkExp.getTitle());
        //exp.setDescription(wkExp.getDescription());
        //exp.setPlace(wkExp.getPlace());
        em.merge(newExp);
    }

    @Override
    public void deleteExperience(int id) {
        WorkExperience exp = em.find(WorkExperience.class, id);
        em.remove(exp);
    }
}
