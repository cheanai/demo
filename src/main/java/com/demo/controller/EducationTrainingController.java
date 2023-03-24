package com.demo.controller;

import com.demo.entity.EducationTrainingInfo;
import com.demo.service.EducationTrainingService;
import com.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@CrossOrigin
public class EducationTrainingController {

    @Autowired
    public EducationTrainingService serviceClass;

    @RequestMapping("/selectEducationTraining")
    @ResponseBody
    public EducationTrainingInfo[] login (){
        EducationTrainingInfo[] state = serviceClass.select();
        System.out.println(state);
        return state;
    }

    @PostMapping("/insertEducationTraining")
    @ResponseBody
    public void insertEducationTraining(@RequestBody EducationTrainingInfo educationTraining){
        serviceClass.insert(educationTraining.getTitle(),educationTraining.getType(),educationTraining.getLocation(),educationTraining.getTime(),educationTraining.getDepartment());
    }
}
