package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Skilldao;
import com.gmr.porfolio.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/porfolio/*/skills")
public class SkillController {
    @Autowired
    private Skilldao skilldao;

    @GetMapping("/data")
    public ResponseEntity<List<Skill>> getAllSkills(){
        List skills = skilldao.getAll();
        return ResponseEntity.ok(skills);
    }

    @PostMapping("/add")
    public String addSkill(@RequestBody Skill skill){
        skilldao.addSkill(skill);
        return "success";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkill(@PathVariable Long id){
        skilldao.deleteSkill(id);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<List<Skill>> updateSkill(@RequestBody Skill skill, @PathVariable("id") Long id){
        skilldao.editSkill(id, skill);
        return getAllSkills();

    }
}
