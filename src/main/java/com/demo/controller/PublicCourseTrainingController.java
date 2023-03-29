package com.demo.controller;

import com.demo.entity.PublicCourseTraining;
import com.demo.service.PublicCourseTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class PublicCourseTrainingController {

    @Autowired
    public PublicCourseTrainingService serviceClass;

    @RequestMapping("/selectPublicCourseTraining")
    @ResponseBody
    public PublicCourseTraining[] selectPublicCourseTraining(String department){
        PublicCourseTraining[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectPublicCourseTrainingByState")
    @ResponseBody
    public PublicCourseTraining[] selectPublicCourseTrainingByState (String state , String department){
        System.out.println(state+"-"+department);
        PublicCourseTraining[] data = serviceClass.selectPublicCourseTrainingByState(state,department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectPublicCourseTrainingById")
    @ResponseBody
    public PublicCourseTraining selectPublicCourseTrainingById (int id){
        System.out.println(id);
        PublicCourseTraining data = serviceClass.selectPublicCourseTrainingById(id);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertPublicCourseTraining")
    @ResponseBody
    public void insertPublicCourseTraining(@RequestBody PublicCourseTraining publicCourseTraining){
        serviceClass.insert(publicCourseTraining.getTeacherName(),publicCourseTraining.getTrainingName(),publicCourseTraining.getTrainingTime(),publicCourseTraining.getTrainingHours(),publicCourseTraining.getDepartment());
    }

    @PostMapping("/updatePublicCourseTraining")
    @ResponseBody
    public void updatePublicCourseTraining(@RequestBody PublicCourseTraining publicCourseTraining){
        System.out.println(publicCourseTraining);
        serviceClass.update(publicCourseTraining.getId(),publicCourseTraining.getTeacherName(),publicCourseTraining.getTrainingName(),publicCourseTraining.getTrainingTime(),publicCourseTraining.getTrainingHours(),publicCourseTraining.getDepartment());
    }

    @RequestMapping("/selectPublicCourseTrainingByNameAndState")
    @ResponseBody
    public PublicCourseTraining[] selectPublicCourseTrainingByNameAndState(String teacherName, String state, String department) {
        System.out.println(teacherName + "-" + state + "-" + department);
        PublicCourseTraining[] data = serviceClass.selectPublicCourseTrainingByNameAndState(teacherName, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectPublicCourseTrainingByTeacherName")
    @ResponseBody
    public PublicCourseTraining[] selectPublicCourseTrainingByTeacher(String teacherName, String department){
        PublicCourseTraining[] data = serviceClass.selectByTeacherNameAndDepartment(teacherName, department);
        System.out.println(data);
        return data;
    }

}
