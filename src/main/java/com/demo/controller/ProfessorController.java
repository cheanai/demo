package com.demo.controller;

import com.demo.entity.Professor;
import com.demo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@CrossOrigin
public class ProfessorController {

    @Autowired
    public ProfessorService serviceClass;

    @RequestMapping("/selectProfessor")
    @ResponseBody
    public Professor[] selectProfessor(String department){
        System.out.println(department);
        Professor[] data = serviceClass.select(department);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/selectProfessorByState")
    @ResponseBody
    public Professor[] selectProfessorByState (String state , String department){
        System.out.println(state+"-"+department);
        Professor[] data = serviceClass.selectProfessorByState(state,department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectProfessorById")
    @ResponseBody
    public Professor selectProfessorById (int id){
        System.out.println(id);
        Professor data = serviceClass.selectProfessorById(id);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertProfessor")
    @ResponseBody
    public void insertProfessor(@RequestBody Professor professor){
        serviceClass.insert(professor.getName(), professor.getSex(), professor.getTitle(), professor.getDepartment(), professor.getResearchField());
    }

    @PostMapping("/updateProfessor")
    @ResponseBody
    public void updateProfessor(@RequestBody Professor professor){
        System.out.println(professor);
        serviceClass.update(professor.getId(), professor.getName(), professor.getSex(), professor.getTitle(), professor.getDepartment(), professor.getResearchField());
    }

    @RequestMapping("/selectProfessorByNameAndState")
    @ResponseBody
    public Professor[] selectProfessorByNameAndState(String name, String state, String department) {
        System.out.println(name + "-" + state + "-" + department);
        Professor[] data = serviceClass.selectProfessorByNameAndState(name, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectProfessorByName")
    @ResponseBody
    public Professor[] selectProfessorByName(String name, String department) {
        Professor[] data = serviceClass.selectProfessorByName(name, department);
        System.out.println(data);
        return data;
    }

}
