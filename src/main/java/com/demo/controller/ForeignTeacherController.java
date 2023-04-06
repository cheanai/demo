package com.demo.controller;

import com.demo.entity.ForeignTeacher;
import com.demo.service.ForeignTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class ForeignTeacherController {

    @Autowired
    public ForeignTeacherService serviceClass;

    @RequestMapping("/selectForeignTeacher")
    @ResponseBody
    public ForeignTeacher[] selectForeignTeacher(String department) {
        ForeignTeacher[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectAllForeignTeacher")
    @ResponseBody
    public ForeignTeacher[] selectAllForeignTeacher (){
        ForeignTeacher[] data = serviceClass.selectAll();

        return data;
    }

    @RequestMapping("/updateForeignTeacherById")
    @ResponseBody
    public void updateForeignTeacherById (int id,String state){
        serviceClass.updateForeignTeacherById(id,state);
    }

    @RequestMapping("/selectForeignTeacherByState")
    @ResponseBody
    public ForeignTeacher[] selectForeignTeacherByState(String state, String department) {
        ForeignTeacher[] data = serviceClass.selectByState(state, department);
        return data;
    }

    @RequestMapping("/selectForeignTeacherById")
    @ResponseBody
    public ForeignTeacher selectForeignTeacherById(int id) {
        ForeignTeacher data = serviceClass.selectById(id);
        return data;
    }

    @PostMapping("/insertForeignTeacher")
    @ResponseBody
    public void insertForeignTeacher(@RequestBody ForeignTeacher foreignTeacher) {
        serviceClass.insert(foreignTeacher.getName(), foreignTeacher.getSex(), foreignTeacher.getNationality(), foreignTeacher.getDepartment(), foreignTeacher.getTitle());
    }

    @PostMapping("/updateForeignTeacher")
    @ResponseBody
    public void updateForeignTeacher(@RequestBody ForeignTeacher foreignTeacher) {
        serviceClass.update(foreignTeacher.getId(), foreignTeacher.getName(), foreignTeacher.getSex(), foreignTeacher.getNationality(), foreignTeacher.getDepartment(), foreignTeacher.getTitle());
    }

    @RequestMapping("/selectForeignTeacherByName")
    @ResponseBody
    public ForeignTeacher[] selectForeignTeacherByName(String name, String department) {
        System.out.println(name);
        ForeignTeacher[] data = serviceClass.selectByName(name, department);
        return data;
    }

    @RequestMapping("/selectForeignTeacherByNameAndState")
    @ResponseBody
    public ForeignTeacher[] selectForeignTeacherByNameAndState(String name, String state) {
        ForeignTeacher[] data = serviceClass.selectForeignTeacherByNameAndState(name, state);
        System.out.println(data);
        return data;
    }


}
