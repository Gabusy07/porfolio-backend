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

    ResponseEntity editLanguage(Long id, Language editedLang);

    ResponseEntity deleteLanguage(Long id);

    ResponseEntity addLanguage(Language lang);




}
