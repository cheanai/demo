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
    public EducationTrainingInfo[] login (String department){
        EducationTrainingInfo[] data = serviceClass.select(department);

        return data;
    }
    @RequestMapping("/selectEducationTrainingByState")
    @ResponseBody
    public EducationTrainingInfo[] selectEducationTrainingByState (String state , String department){
        System.out.println(state+"-"+department);
        EducationTrainingInfo[] data = serviceClass.selectEducationTrainingByState(state,department);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/selectEducationTrainingById")
    @ResponseBody
    public EducationTrainingInfo selectEducationTrainingByState (String id){
        System.out.println(id);
        EducationTrainingInfo data = serviceClass.selectEducationTrainingById(id);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectEducationTrainingByTitle")
    @ResponseBody
    public EducationTrainingInfo[] selectEducationTrainingByTitle (String title , String department){
        System.out.println(title+"-"+department);
        EducationTrainingInfo[] data = serviceClass.selectEducationTrainingByTitle(title,department);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/selectEducationTrainingByTitleAndState")
    @ResponseBody
    public EducationTrainingInfo[] selectEducationTrainingByTitleAndState (String state, String title , String department){
        System.out.println(state+"-"+title+"-"+department);
        EducationTrainingInfo[] data = serviceClass.selectEducationTrainingByTitleAndState(state,title,department);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertEducationTraining")
    @ResponseBody
    public void insertEducationTraining(@RequestBody EducationTrainingInfo educationTraining){
        System.out.println(educationTraining);
        serviceClass.insert(educationTraining.getTitle(),educationTraining.getType(),educationTraining.getLocation(),educationTraining.getTime(),educationTraining.getDepartment());
    }

    @PostMapping("/updateEducationTraining")
    @ResponseBody
    public void updateEducationTraining(@RequestBody EducationTrainingInfo educationTraining){
        System.out.println(educationTraining);
        serviceClass.update(educationTraining.getId(),educationTraining.getTitle(),educationTraining.getType(),educationTraining.getLocation(),educationTraining.getTime(),educationTraining.getDepartment());
    }
}
