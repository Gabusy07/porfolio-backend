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
        String query = "FROM Skill"; // clase User consulta a hibernate
        ArrayList result = (ArrayList) em.createQuery(query).getResultList();
        return result;
    }

    @Override
    public void editSkill(Long id, Skill editedSkill) {

        Skill skill = em.find(Skill.class, id);
        skill.setName(editedSkill.getName());
        em.merge(skill);
        em.close();

    }

    @Override
    public void deleteSkill(Long id) {
        Skill skill =  em.find(Skill.class, id);
        em.remove(skill);
        em.close();

    }

    @Override
    public void addSkill(Skill skill) {
        em.merge(skill);
        em.close();

    }
}
