package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Project> editProject(int id, Project editedProject) {
        Project p = em.find(Project.class, id);
        p = new Project.Builder().setId(p.getId()).setTitle(editedProject.getTitle())
                        .setDescription(editedProject.getDescription())
                        .setLanguage(editedProject.getLanguage())
                        .setImage(editedProject.getImage())
                        .setLinkProject(editedProject.getLinkProject())
                        .setEnabled(editedProject.getEnabled())
                                        .build();
        return Optional.of(em.merge(p));
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
