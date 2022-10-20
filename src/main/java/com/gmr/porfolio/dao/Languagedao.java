package com.gmr.porfolio.dao;


import com.gmr.porfolio.models.Language;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface Languagedao {

    ArrayList<Language> getAll();

    void editLanguage(Long id, Language editedLang);

    void deleteLanguage(Long id);

    void addLanguage(Language lang);







}
