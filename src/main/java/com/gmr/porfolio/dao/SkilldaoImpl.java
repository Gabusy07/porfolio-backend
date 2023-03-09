package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SkilldaoImpl implements Skilldao {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Skill> getAll() {
        String query = "FROM Skill";
        return em.createQuery(query).getResultList();
    }

    @Override
    public void editSkill(int id, Skill editedSkill) {
        Skill skill = em.find(Skill.class, id);
        //skill.setName(editedSkill.getName());
        skill = new Skill.Builder().setId(skill.getId())
                .setName(editedSkill.getName())
                .setLanguage(editedSkill.getLanguage())
                        .build();
        em.merge(skill);

    }

    @Override
    public void deleteSkill(int id) {
        Skill skill =  em.find(Skill.class, id);
        em.remove(skill);


    }

    @Override
    public void addSkill(Skill skill) {
        em.persist(skill);

    }
}
