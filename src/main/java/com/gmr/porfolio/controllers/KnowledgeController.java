package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.KnowledgeDAO;
import com.gmr.porfolio.models.Knowledge;
import com.gmr.porfolio.services.ProgressBarDetermine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@CrossOrigin(origins="${host}")
@RestController
@RequestMapping("/porfolio/knowledges")
public class KnowledgeController {

    @Autowired
    private KnowledgeDAO knwdao;

    @GetMapping("/all")
    public ArrayList getAllLang(){
        ArrayList knowledges = knwdao.getAll();
        return new ArrayList (knowledges);
    }

    @PostMapping("/add")
    public void addKnowledge(@RequestBody Knowledge knw) throws ParseException {
        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = knw.getDate();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        Knowledge newKnw = new Knowledge.Builder().setId(knw.getId()).setName(knw.getName())
                        .setDate(knw.getDate()).setProgressbar((String) progressbarAndWidth.get(0))
                        .setWidth((Integer) progressbarAndWidth.get(1)).build();
        //knw.setProgressbar((String)progressbarAndWidth.get(0));
        //knw.setWidth((int)progressbarAndWidth.get(1));
        //llamada a dao
        knwdao.addKnowledge(newKnw);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteKnowledge(@PathVariable int id){
        knwdao.deleteKnowledge(id);
    }

    @PatchMapping(value = "/update/{id}")
    public void updateKnowledge(@RequestBody Knowledge knw, @PathVariable("id") int id){

        //recoge la fecha y opera con ella para devolver el tipo de progressbar y width para la DDBB
        String date = knw.getDate();
        ArrayList progressbarAndWidth = new ProgressBarDetermine().getProgressbarType(date);
        //knw.setProgressbar((String)progressbarAndWidth.get(0));
        //knw.setWidth((int)progressbarAndWidth.get(1));
        //llamada a dao
         knwdao.editKnowledge(id, knw);

    }

}
