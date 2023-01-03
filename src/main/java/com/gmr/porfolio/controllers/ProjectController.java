package com.gmr.porfolio.controllers;

import com.gmr.porfolio.models.Project;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="${host}", maxAge = 3600)

@RestController
@RequestMapping("/porfolio/project")
public class ProjectController {

    @PostMapping("/add")
    public void addProject(@RequestBody Project p,
                           @RequestHeader(value = "Authorization") String token){};

    @GetMapping("/data")
    public Project getProjects(@RequestHeader(value = "Authorization") String token){
        return null;
    };

    @PatchMapping("/update({id}")
    public void updateProject(@RequestBody Project p,
                              @PathVariable int id,
                              @RequestHeader(value = "Authorization") String token){};

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable int id,
                              @RequestHeader(value = "Authorization") String token){};
}
