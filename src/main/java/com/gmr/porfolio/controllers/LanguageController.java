package com.gmr.porfolio.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gmr.porfolio.dao.Languagedao;
import com.gmr.porfolio.models.Language;
import com.gmr.porfolio.models.LanguagueJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/languages")
public class LanguageController {

    @Autowired
    private Languagedao langdao;

    @GetMapping("/data")
    public ResponseEntity<List<Language>> getAllLang(){
        List languagues = langdao.getAll();
        return ResponseEntity.ok(languagues);
    }

    @PostMapping("/add")
    public String addLanguage(@RequestBody LanguagueJson lang) throws ParseException {

        Language l = new Language();
        l.setName(lang.getName());
        l.setProgressbar(lang.getProgressbar());
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date date = parser.parse(lang.getDate_start());
        l.setDate_start(date);
        System.out.println(date);
        //langdao.addLanguage(l);
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLanguage(@PathVariable Long id){
        langdao.deleteLanguage(id);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<List<Language>> updateLanguage(@RequestBody Language lang, @PathVariable("id") Long id){
        langdao.editLanguage(id, lang);
        return getAllLang();

    }
}
