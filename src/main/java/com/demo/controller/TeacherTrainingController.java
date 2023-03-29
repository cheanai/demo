package com.demo.controller;

import com.demo.entity.TeacherTraining;
import com.demo.service.TeacherTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@CrossOrigin
public class TeacherTrainingController {
    @Autowired
    public TeacherTrainingService serviceClass;

    @RequestMapping("/selectTeacherTraining")
    @ResponseBody
    public TeacherTraining[] selectTeacherTraining (String department){
        TeacherTraining[] data = serviceClass.select(department);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/selectTeacherTrainingByState")
    @ResponseBody
    public TeacherTraining[] selectTeacherTrainingByState (String state , String department){
        System.out.println(state+"-"+department);
        TeacherTraining[] data = serviceClass.selectTeacherTrainingByState(state,department);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/selectTeacherTrainingById")
    @ResponseBody
    public TeacherTraining selectTeacherTrainingById (String id){
        System.out.println(id);
        TeacherTraining data = serviceClass.selectTeacherTrainingById(id);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTeacherTrainingByName")
    @ResponseBody
    public TeacherTraining[] selectTeacherTrainingByName (String teacherName , String department){
        System.out.println(teacherName+"-"+department);
        TeacherTraining[] data = serviceClass.selectTeacherTrainingByName(teacherName,department);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/selectTeacherTrainingByNameAndState")
    @ResponseBody
    public TeacherTraining[] selectTeacherTrainingByNameAndState (String state, String teacherName , String department){
        System.out.println(state+"-"+teacherName+"-"+department);
        TeacherTraining[] data = serviceClass.selectTeacherTrainingByNameAndState(state,teacherName,department);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertTeacherTraining")
    @ResponseBody
    public void insertTeacherTraining(@RequestBody TeacherTraining TeacherTraining){
        serviceClass.insert(TeacherTraining.getTeacherName(),TeacherTraining.getTrainingType(),TeacherTraining.getTrainingTopic(),TeacherTraining.getTrainingStartTime(),TeacherTraining.getDepartment());
    }

    @PostMapping("/updateTeacherTraining")
    @ResponseBody
    public void updateTeacherTraining(@RequestBody TeacherTraining TeacherTraining){
        System.out.println(TeacherTraining);
        serviceClass.update(TeacherTraining.getId(),TeacherTraining.getTeacherName(),TeacherTraining.getTrainingType(),TeacherTraining.getTrainingTopic(),TeacherTraining.getTrainingStartTime(),TeacherTraining.getDepartment());
    }

}
