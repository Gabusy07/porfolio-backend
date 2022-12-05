package com.gmr.porfolio.dao;


import com.gmr.porfolio.models.Language;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface Languagedao {

    ArrayList<Language> getAll();

    void editLanguage(int id, Language editedLang);

    void deleteLanguage(int id);

    void addLanguage(Language lang);


}
