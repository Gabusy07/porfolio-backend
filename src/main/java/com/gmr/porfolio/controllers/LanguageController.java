package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Languagedao;
import com.gmr.porfolio.models.Language;
import com.gmr.porfolio.services.ProgressBarDetermine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

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
    public String addLanguage(@RequestBody Language lang) throws ParseException {

        //recoge la fecha y opera con ella para devolver el tipo de progressbar para la DDBB
        String date = lang.getDate_start();
        lang.setProgressbar(new ProgressBarDetermine().getProgressbarType(date));
        //llamada a dao
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
