package com.demo.controller;

import com.demo.entity.StudyAbroad;
import com.demo.service.StudyAbroadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@CrossOrigin
public class StudyAbroadController {
    @Autowired
    public StudyAbroadService serviceClass;

    @RequestMapping("/selectStudyAbroad")
    @ResponseBody
    public StudyAbroad[] selectStudyAbroad(String department){
        StudyAbroad[] data = serviceClass.select(department);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/selectAllStudyAbroad")
    @ResponseBody
    public StudyAbroad[] selectAllStudyAbroad (){
        StudyAbroad[] data = serviceClass.selectAll();

        return data;
    }

    @RequestMapping("/updateStudyAbroadById")
    @ResponseBody
    public void updateStudyAbroadById (int id,String state){
        serviceClass.updateStudyAbroadById(id,state);
    }

    @RequestMapping("/selectStudyAbroadByState")
    @ResponseBody
    public StudyAbroad[] selectStudyAbroadByState(String state, String department){
        System.out.println(state+"-"+department);
        StudyAbroad[] data = serviceClass.selectStudyAbroadByState(state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectStudyAbroadById")
    @ResponseBody
    public StudyAbroad selectStudyAbroadById(String id){
        System.out.println(id);
        StudyAbroad data = serviceClass.selectStudyAbroadById(id);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectStudyAbroadByTeacherName")
    @ResponseBody
    public StudyAbroad[] selectStudyAbroadByTeacherName(String teacherName, String department){
        System.out.println(teacherName+"-"+department);
        StudyAbroad[] data = serviceClass.selectStudyAbroadByTeacherName(teacherName, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectStudyAbroadByNameAndState")
    @ResponseBody
    public StudyAbroad[] selectStudyAbroadByNameAndState(String teacherName,String state, String department){
        System.out.println(teacherName+"-"+state+"-"+department);
        StudyAbroad[] data = serviceClass.selectStudyAbroadByNameAndState(teacherName,state, department);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertStudyAbroad")
    @ResponseBody
    public void insertStudyAbroad(@RequestBody StudyAbroad studyAbroad){
        serviceClass.insert(studyAbroad.getTeacherName(),studyAbroad.getDestination(),studyAbroad.getStartDate(),studyAbroad.getStudyContent(),studyAbroad.getDepartment());
    }

    @PostMapping("/updateStudyAbroad")
    @ResponseBody
    public void updateStudyAbroad(@RequestBody StudyAbroad studyAbroad){
        System.out.println(studyAbroad);
        serviceClass.update(studyAbroad.getId(),studyAbroad.getTeacherName(),studyAbroad.getDestination(),studyAbroad.getStartDate(),studyAbroad.getStudyContent(),studyAbroad.getDepartment());
    }

}
