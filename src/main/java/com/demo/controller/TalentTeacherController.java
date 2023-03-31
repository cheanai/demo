package com.demo.controller;

import com.demo.entity.TalentTeacher;
import com.demo.service.TalentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class TalentTeacherController {

    @Autowired
    public TalentTeacherService serviceClass;

    @RequestMapping("/selectTalentTeacher")
    @ResponseBody
    public TalentTeacher[] selectTalentTeacher(String department){
        TalentTeacher[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectTalentTeacherByState")
    @ResponseBody
    public TalentTeacher[] selectTalentTeacherByState (String state , String department){
        System.out.println(state+"-"+department);
        TalentTeacher[] data = serviceClass.selectTalentTeacherByState(state,department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTalentTeacherById")
    @ResponseBody
    public TalentTeacher selectTalentTeacherById (int id){
        System.out.println(id);
        TalentTeacher data = serviceClass.selectTalentTeacherById(id);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertTalentTeacher")
    @ResponseBody
    public void insertTalentTeacher(@RequestBody TalentTeacher talentTeacher){
        serviceClass.insert(talentTeacher.getName(), talentTeacher.getSex(), talentTeacher.getDepartment(),
                talentTeacher.getTitle(), talentTeacher.getTalentTitle());
    }

    @PostMapping("/updateTalentTeacher")
    @ResponseBody
    public void updateTalentTeacher(@RequestBody TalentTeacher talentTeacher){
        System.out.println(talentTeacher);
        serviceClass.update(talentTeacher.getId(), talentTeacher.getName(), talentTeacher.getSex(),
                talentTeacher.getDepartment(), talentTeacher.getTitle(), talentTeacher.getTalentTitle());
    }

    @RequestMapping("/selectTalentTeacherByNameAndState")
    @ResponseBody
    public TalentTeacher[] selectTalentTeacherByNameAndState(String name, String state, String department) {
        System.out.println(name + "-" + state + "-" + department);
        TalentTeacher[] data = serviceClass.selectTalentTeacherByNameAndState(name, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTalentTeacherByName")
    @ResponseBody
    public TalentTeacher[] selectTalentTeacherByName(String name, String department){
        TalentTeacher[] data = serviceClass.selectByTeacherNameAndDepartment(name, department);
        System.out.println(data);
        return data;
    }
}
