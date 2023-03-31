package com.demo.controller;

import com.demo.entity.AssociateProfessor;
import com.demo.service.AssociateProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@CrossOrigin
public class AssociateProfessorController {

    @Autowired
    public AssociateProfessorService serviceClass;

    @RequestMapping("/selectAssociateProfessor")
    @ResponseBody
    public AssociateProfessor[] selectAssociateProfessor(String department){
        System.out.println(department);
        AssociateProfessor[] data = serviceClass.select(department);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/selectAssociateProfessorByState")
    @ResponseBody
    public AssociateProfessor[] selectAssociateProfessorByState (String state , String department){
        System.out.println(state+"-"+department);
        AssociateProfessor[] data = serviceClass.selectAssociateProfessorByState(state,department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectAssociateProfessorById")
    @ResponseBody
    public AssociateProfessor selectAssociateProfessorById (int id){
        System.out.println(id);
        AssociateProfessor data = serviceClass.selectAssociateProfessorById(id);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertAssociateProfessor")
    @ResponseBody
    public void insertAssociateProfessor(@RequestBody AssociateProfessor AssociateProfessor){
        serviceClass.insert(AssociateProfessor.getName(), AssociateProfessor.getSex(), AssociateProfessor.getTitle(), AssociateProfessor.getDepartment(), AssociateProfessor.getResearchField());
    }

    @PostMapping("/updateAssociateProfessor")
    @ResponseBody
    public void updateAssociateProfessor(@RequestBody AssociateProfessor AssociateProfessor){
        System.out.println(AssociateProfessor);
        serviceClass.update(AssociateProfessor.getId(), AssociateProfessor.getName(), AssociateProfessor.getSex(), AssociateProfessor.getTitle(), AssociateProfessor.getDepartment(), AssociateProfessor.getResearchField());
    }

    @RequestMapping("/selectAssociateProfessorByNameAndState")
    @ResponseBody
    public AssociateProfessor[] selectAssociateProfessorByNameAndState(String name, String state, String department) {
        System.out.println(name + "-" + state + "-" + department);
        AssociateProfessor[] data = serviceClass.selectAssociateProfessorByNameAndState(name, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectAssociateProfessorByName")
    @ResponseBody
    public AssociateProfessor[] selectAssociateProfessorByName(String name, String department) {
        AssociateProfessor[] data = serviceClass.selectAssociateProfessorByName(name, department);
        System.out.println(data);
        return data;
    }

}
