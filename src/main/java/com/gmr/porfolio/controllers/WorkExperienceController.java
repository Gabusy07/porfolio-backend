package com.gmr.porfolio.controllers;

import com.gmr.porfolio.dao.WorkExperiencedao;
import com.gmr.porfolio.models.WorkExperience;
import com.gmr.porfolio.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="${host}", maxAge = 3600)

@RestController
@RequestMapping("/porfolio/workExperience")
public class WorkExperienceController {

    @Autowired
    private WorkExperiencedao wkExpDao;

    @Autowired
    JWTutil jwt;

    @PostMapping("/add")
    public void addExperience(@RequestBody WorkExperience wkExp,
                              @RequestHeader(value = "Authorization") String token)
    {
        if(jwt.verifyToken(token)){
            wkExpDao.addExperience(wkExp);
        }
    };
    @GetMapping("/data/{id}")
    public WorkExperience getExperience(@PathVariable("id") int id,
            @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            return wkExpDao.getExperience(id);
        }
        return null;
    };
    @PatchMapping("/update/{id}")
    public void updateExperience(@PathVariable int id,
                                 @RequestBody WorkExperience wkExp,
                                 @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            wkExpDao.editExperience(id, wkExp);
        }

    };

    @GetMapping("/get-all")
    public List<WorkExperience> getAllWorkExp(@RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            return wkExpDao.getAllExperiences();
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteExperience(@PathVariable int id,
                                 @RequestHeader(value = "Authorization") String token){
        if(jwt.verifyToken(token)){
            wkExpDao.deleteExperience(id);
        }
    };
}
