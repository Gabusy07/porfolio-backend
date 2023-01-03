package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
        p.setTitle(editedProject.getTitle());
        p.setImage(editedProject.getImage());
        p.setLinkProject(editedProject.getLinkProject());
        em.merge(p);
    }

    @Override
    public void deleteProject(int id) {
        Project p = em.find(Project.class, id);
        em.remove(p);
    }
}
