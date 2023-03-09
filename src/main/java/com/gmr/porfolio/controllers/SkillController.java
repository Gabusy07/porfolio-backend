package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Skilldao;
import com.gmr.porfolio.models.Skill;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getAllSkills(@RequestHeader(value = "Authorization") String token){

        if (jwt.verifyToken(token)) {
            List skills = skilldao.getAll();
            return new ResponseEntity<>(skills, HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);

    }

    @PostMapping("/add")
    public ResponseEntity addSkill(@RequestBody Skill skill, @RequestHeader(value = "Authorization") String token){
        if (jwt.verifyToken(token)){
            skilldao.addSkill(skill);
            return new ResponseEntity("item added success", HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSkill(@PathVariable int id,
                            @RequestHeader(value = "Authorization") String token){

        if (jwt.verifyToken(token)) {
            skilldao.deleteSkill(id);
            return new ResponseEntity("item deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity updateSkill(@RequestBody Skill skill, @PathVariable("id") int id,
            @RequestHeader(value = "Authorization") String token){

        if (jwt.verifyToken(token)) {
            skilldao.editSkill(id, skill);
            return new ResponseEntity("item modified", HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);

    }


}
