package com.demo.controller;

import com.demo.entity.ForeignTeacherWorkload;
import com.demo.service.ForeignTeacherWorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class ForeignTeacherWorkloadController {

    @Autowired
    private ForeignTeacherWorkloadService serviceClass;

    @RequestMapping("/selectForeignTeacherWorkloadByTeacherName")
    @ResponseBody
    public ForeignTeacherWorkload[] selectForeignTeacherWorkloadByTeacherName(String teacherName, String department){
        System.out.println(teacherName);
        ForeignTeacherWorkload[] data = serviceClass.selectByTeacherNameAndDepartment(teacherName, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectForeignTeacherWorkload")
    @ResponseBody
    public ForeignTeacherWorkload[] selectForeignTeacherWorkload(String department){
        ForeignTeacherWorkload[] data = serviceClass.select(department);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertForeignTeacherWorkload")
    @ResponseBody
    public void insertForeignTeacherWorkload(@RequestBody ForeignTeacherWorkload foreignTeacherWorkload){
        serviceClass.insert(foreignTeacherWorkload.getTeacherName(),foreignTeacherWorkload.getCourseName(),foreignTeacherWorkload.getCourseHours(),foreignTeacherWorkload.getCourseType(),foreignTeacherWorkload.getDepartment());
    }

    @PostMapping("/updateForeignTeacherWorkload")
    @ResponseBody
    public void updateForeignTeacherWorkload(@RequestBody ForeignTeacherWorkload foreignTeacherWorkload){
        System.out.println(foreignTeacherWorkload);
        serviceClass.update(foreignTeacherWorkload.getId(),foreignTeacherWorkload.getTeacherName(),foreignTeacherWorkload.getCourseName(),foreignTeacherWorkload.getCourseHours(),foreignTeacherWorkload.getCourseType(),foreignTeacherWorkload.getDepartment());
    }

    @RequestMapping("/selectForeignTeacherWorkloadById")
    @ResponseBody
    public ForeignTeacherWorkload selectForeignTeacherWorkloadById(int id){
        System.out.println(id);
        ForeignTeacherWorkload data = serviceClass.selectById(id);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectForeignTeacherWorkloadByTeacherNameAndState")
    @ResponseBody
    public ForeignTeacherWorkload[] selectForeignTeacherWorkloadByTeacherNameAndState(String teacherName, String state, String department){
        System.out.println(teacherName + "-" + state + "-" + department);
        ForeignTeacherWorkload[] data = serviceClass.selectByTeacherNameAndState(teacherName, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectForeignTeacherWorkloadByState")
    @ResponseBody
    public ForeignTeacherWorkload[] selectForeignTeacherWorkloadByState(String state, String department){
        System.out.println(state + "-" + department);
        ForeignTeacherWorkload[] data = serviceClass.selectByStateAndDepartment(state, department);
        System.out.println(data);
        return data;
    }

}
