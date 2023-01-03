package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Languagedao;
import com.gmr.porfolio.models.Language;
import com.gmr.porfolio.services.ProgressBarDetermine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@CrossOrigin(origins="${host}")
@RestController
@RequestMapping("/porfolio/languages")
public class LanguageController {

    @Autowired
    private Languagedao langdao;

    @GetMapping("/all")
    public ArrayList getAllLang(){
        ArrayList languagues = langdao.getAll();
        return new ArrayList (languagues);
    }

    @PostMapping("/add")
    public void addLanguage(@RequestBody Language lang) throws ParseException {

        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = lang.getDate();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        lang.setProgressbar((String)progressbarAndWidth.get(0));
        lang.setWidth((int)progressbarAndWidth.get(1));
        //llamada a dao
        langdao.addLanguage(lang);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteLanguage(@PathVariable int id){
        langdao.deleteLanguage(id);
    }

    @PatchMapping(value = "/update/{id}")
    public void updateLanguage(@RequestBody Language lang, @PathVariable("id") int id){

        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = lang.getDate();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        lang.setProgressbar((String)progressbarAndWidth.get(0));
        lang.setWidth((int)progressbarAndWidth.get(1));

        //llamada a dao

         langdao.editLanguage(id, lang);

    }

}
