package com.gmr.porfolio.dao;

import com.gmr.porfolio.models.Language;
import com.gmr.porfolio.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public void editLanguage(Long id, Language editedLang) {
        Language lang = em.find(Language.class, id);
        lang.setName(editedLang.getName());
        lang.setProgressbar(editedLang.getProgressbar());
        lang.setDate_start(editedLang.getDate_start());
        lang.setWidth(editedLang.getWidth());
        em.merge(lang);
        em.close();

    }

    @Override
    public void deleteLanguage(Long id) {

            Language lang = em.find(Language.class, id);
            em.remove(lang);
            em.close();


    }

    @Override
    public void addLanguage(Language lang) {
        em.merge(lang);
        em.close();

    }

}
