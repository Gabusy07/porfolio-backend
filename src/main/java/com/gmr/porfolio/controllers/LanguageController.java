package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Languagedao;
import com.gmr.porfolio.models.Language;
import com.gmr.porfolio.services.ProgressBarDetermine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/languages")
public class LanguageController {

    @Autowired
    private Languagedao langdao;

    @GetMapping("/all")
    public ResponseEntity<ArrayList> getAllLang(){
        ArrayList languagues = langdao.getAll();
        return new ResponseEntity<ArrayList>(languagues, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addLanguage(@RequestBody Language lang) throws ParseException {

        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = lang.getDate_start();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        lang.setProgressbar((String)progressbarAndWidth.get(0));
        lang.setWidth((int)progressbarAndWidth.get(1));
        //llamada a dao
        return langdao.addLanguage(lang);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLanguage(@PathVariable Long id){
        return langdao.deleteLanguage(id);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity updateLanguage(@RequestBody Language lang, @PathVariable("id") Long id){

        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = lang.getDate_start();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        lang.setProgressbar((String)progressbarAndWidth.get(0));
        lang.setWidth((int)progressbarAndWidth.get(1));

        //llamada a dao

        return langdao.editLanguage(id, lang);

    }

}
