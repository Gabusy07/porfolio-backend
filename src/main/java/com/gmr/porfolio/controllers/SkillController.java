package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Skilldao;
import com.gmr.porfolio.models.Skill;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins="${host}")
@RestController
@RequestMapping("/porfolio/*/skills")
public class SkillController {
    @Autowired
    private Skilldao skilldao;

    @Autowired
    private JWTutil jwt;

    @GetMapping("/data")
    public List<Skill> getAllSkills(@RequestHeader(value = "Authorization") String token){

        if (jwt.verifyToken(token)) {
            List skills = skilldao.getAll();
            return skills;
        }
        return null;

    }

    @PostMapping("/add")
    public void addSkill(@RequestBody Skill skill, @RequestHeader(value = "Authorization") String token){
            skilldao.addSkill(skill);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkill(@PathVariable int id,
                            @RequestHeader(value = "Authorization") String token){

        if (jwt.verifyToken(token)) {
            skilldao.deleteSkill(id);
        }
    }

    @PatchMapping(value = "/update/{id}")
    public void updateSkill(@RequestBody Skill skill, @PathVariable("id") int id,
            @RequestHeader(value = "Authorization") String token){

        if (jwt.verifyToken(token)) {
            skilldao.editSkill(id, skill);
        }

    }


}
