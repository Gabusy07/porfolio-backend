package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Languagedao;
import com.gmr.porfolio.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/*/language")
public class LanguageController {

    @Autowired
    private Languagedao langdao;

    @GetMapping("/data")
    public ResponseEntity<List<Language>> getAllLang(){
        List languagues = langdao.getAll();
        return ResponseEntity.ok(languagues);
    }

    @PostMapping("/add")
    public String addLanguage(@RequestBody Language lang){
        langdao.addLanguage(lang);
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
