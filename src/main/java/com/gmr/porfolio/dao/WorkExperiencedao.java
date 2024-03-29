package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.WorkExperience;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WorkExperiencedao {
    public void addExperience(WorkExperience wkExp);
    public WorkExperience getExperience(int id);
    public List<WorkExperience> getAllExperiences();
    public void editExperience(int id, WorkExperience wkExp);
    public void deleteExperience(int id);
}
