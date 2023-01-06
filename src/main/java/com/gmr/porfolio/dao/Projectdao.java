package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Project;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface Projectdao {
    public void addProject(Project p);
    public Project getProject(int id);
    public void editProject(int id, Project p);
    public void deleteProject(int id);
    List<Project> getAll();
}
