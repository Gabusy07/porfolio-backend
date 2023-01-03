package com.gmr.porfolio.controllers;

import com.gmr.porfolio.models.WorkExperience;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="${host}", maxAge = 3600)

@RestController
@RequestMapping("/porfolio/workExperience")
public class WorkExperienceController {

    @PostMapping("/add")
    public void addExperience(@RequestBody WorkExperience wkExp,
                              @RequestHeader(value = "Authorization") String token){

    };
    @GetMapping("/data}")
    public WorkExperience getExperience(@RequestHeader(value = "Authorization") String token){
        return null;
    };
    @PatchMapping("/update/{id}")
    public void updateExperience(@PathVariable int id,
                                 @RequestBody WorkExperience wkExp,
                                 @RequestHeader(value = "Authorization") String token){

    };
    @DeleteMapping("/delete/{id}")
    public void deleteExperience(@PathVariable int id,
                                 @RequestHeader(value = "Authorization") String token){};
}
