package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Project;
import com.gmr.porfolio.models.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class ProjectdaoImpl implements Projectdao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addProject(Project p) {
        em.persist(p);
    }

    @Override
    public Project getProject(int id) {
        return em.find(Project.class, id);
    }

    @Override
    public void editProject(int id, Project editedProject) {
        Project p = em.find(Project.class, id);
        //p.setTitle(editedProject.getTitle());
       // p.setImage(editedProject.getImage());
        //p.setLinkProject(editedProject.getLinkProject());
        p = new Project.Builder().setId(p.getId()).setTitle(p.getTitle())
                        .setDescription(p.getDescription())
                        .setLanguage(p.getLanguage())
                        .setImage(p.getImage())
                        .setLinkProject(p.getLinkProject())
                                        .build();
        em.merge(p);
    }

    @Override
    public void deleteProject(int id) {
        Project p = em.find(Project.class, id);
        em.remove(p);
    }

    @Override
    public List<Project> getAll() {
        String query= "FROM Project";
        return (ArrayList) em.createQuery(query).getResultList();
    }
}
