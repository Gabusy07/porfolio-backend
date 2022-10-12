package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Language;
import com.gmr.porfolio.models.Skill;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface Skilldao {

    List<Skill> getAll();

    void editSkill(Long id, Skill editedSkill);

    void deleteSkill(Long id);

    void addSkill(Skill skill);

}
