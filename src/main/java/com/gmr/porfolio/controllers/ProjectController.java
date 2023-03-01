package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.Projectdao;
import com.gmr.porfolio.models.Project;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="${host}", maxAge = 3600)

@RestController
@RequestMapping("/porfolio/project")
public class ProjectController {

    @Autowired
    private Projectdao projectdao;

    @Autowired
    private JWTutil jwt;

    @PostMapping("/add")
    public void addProject(@RequestBody Project p,
                           @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            projectdao.addProject(p);
        }
    };

    @GetMapping("/data/{id}")
    public Project getProjects(@PathVariable("id") int id, @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            return projectdao.getProject(id);
        }
        return null;
    };

    @GetMapping("/all-data")
    public List<Project> getAllProjects(@RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            return projectdao.getAll();
        }
        return null;
    };

    @PatchMapping("/update/{id}")
    public void updateProject(@RequestBody Project p,
                              @PathVariable int id,
                              @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            projectdao.editProject(id, p);
        }
    };

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable int id,
                              @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            projectdao.deleteProject(id);
        }
    };
}
