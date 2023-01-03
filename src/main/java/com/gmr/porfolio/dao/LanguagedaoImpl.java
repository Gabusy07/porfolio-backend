package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Language;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional
public class LanguagedaoImpl implements Languagedao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public ArrayList<Language> getAll() {
        String query = "FROM Language"; // clase User consulta a hibernate
        ArrayList list = (ArrayList) em.createQuery(query).getResultList();
        return list;
    }

    @Override
    public void editLanguage(int id, Language editedLang) {
        Language lang = em.find(Language.class, id);
        lang.setName(editedLang.getName());
        lang.setProgressbar(editedLang.getProgressbar());
        lang.setDate(editedLang.getDate());
        lang.setWidth(editedLang.getWidth());
        em.merge(lang);


    }

    @Override
    public void deleteLanguage(int id) {
        Language lang = em.find(Language.class, id);
        em.remove(lang);

    }

    @Override
    public void addLanguage(Language lang) {
        em.persist(lang);
    }

}
