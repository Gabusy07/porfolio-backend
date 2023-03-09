package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Projectdao;
import com.gmr.porfolio.models.Project;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="${host}", maxAge = 3600)

@RestController
@RequestMapping("/porfolio/project")
public class ProjectController {

    @Autowired
    private Projectdao projectdao;

    @Autowired
    private JWTutil jwt;

    @PostMapping("/add")
    public ResponseEntity addProject(@RequestBody Project p,
                           @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            projectdao.addProject(p);
            return new ResponseEntity("item added", HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    };

    @GetMapping("/data/{id}")
    public ResponseEntity getProjects(@PathVariable("id") int id, @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            return new ResponseEntity(projectdao.getProject(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    };

    @GetMapping("/all-data")
    public ResponseEntity getAllProjects(@RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            return new ResponseEntity(projectdao.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    };

    @PatchMapping("/update/{id}")
    public ResponseEntity updateProject(@RequestBody Project p,
                              @PathVariable int id,
                              @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            projectdao.editProject(id, p);
            return new ResponseEntity("item modified", HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    };

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable int id,
                              @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            projectdao.deleteProject(id);
            return new ResponseEntity("item deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("token not valid", HttpStatus.UNAUTHORIZED);
    };
}
