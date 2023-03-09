package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Project;
import java.util.List;
import java.util.Optional;


public interface Projectdao {
    public void addProject(Project p);
    public Project getProject(int id);
    public Optional<Project> editProject(int id, Project p);
    public void deleteProject(int id);
    List<Project> getAll();
}
