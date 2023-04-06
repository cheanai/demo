package com.demo.controller;

import com.demo.entity.ApplyPhd;
import com.demo.entity.TargetAssessment;
import com.demo.service.TargetAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class TargetAssessmentController {

    @Autowired
    public TargetAssessmentService serviceClass;

    @RequestMapping("/selectTargetAssessment")
    @ResponseBody
    public TargetAssessment[] login() {
        TargetAssessment[] data = serviceClass.select();
        return data;
    }
    @RequestMapping("/insertTargetAssessment")
    @ResponseBody
    public void insertTargetAssessment(String college,String secondaryIndicators,String tertiaryIndicators,int taskVolume,String date) {
        System.out.println(college+"---"+secondaryIndicators+"---"+tertiaryIndicators+"---"+taskVolume+"---"+date);
        serviceClass.insert(college,secondaryIndicators,tertiaryIndicators,taskVolume,date);
    }

    @RequestMapping("/selectTargetAssessmentByCollege")
    @ResponseBody
    public TargetAssessment[] selectTargetAssessmentByCollege(String college) {
        TargetAssessment[] data = serviceClass.selectTargetAssessmentByCollege(college);
        return data;
    }

    @RequestMapping("/selectTargetAssessmentByCollegeAndState")
    @ResponseBody
    public TargetAssessment[] selectTargetAssessmentByCollegeAndState(String college, String state) {
        System.out.println(college + "-" + state);
        TargetAssessment[] data = serviceClass.selectTargetAssessmentByCollegeAndState(college, state);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTargetAssessmentByState")
    @ResponseBody
    public TargetAssessment[] selectTargetAssessmentByState (String state){
        System.out.println(state);
        TargetAssessment[] data = serviceClass.selectTargetAssessmentByState(state);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTargetAssessmentById")
    @ResponseBody
    public TargetAssessment selectTargetAssessmentById (int id){
        System.out.println(id);
        TargetAssessment data = serviceClass.selectTargetAssessmentById(id);
        System.out.println(data);
        return data;
    }
}
