package com.demo.controller;

import com.demo.entity.BilingualTeacher;
import com.demo.service.BilingualTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@CrossOrigin
public class BilingualTeacherController {

    @Autowired
    private BilingualTeacherService serviceClass;

    @RequestMapping("/selectBilingualTeacher")
    @ResponseBody
    public BilingualTeacher[] selectBilingualTeacher(String department){
        BilingualTeacher[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectALlBilingualTeacher")
    @ResponseBody
    public BilingualTeacher[] selectAllBilingualTeacher(){
        System.out.println("---------");
        BilingualTeacher[] data = serviceClass.selectAll();
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/updateBilingualTeacherById")
    @ResponseBody
    public void updateBilingualTeacherById(int id,String state){
        serviceClass.updateBilingualTeacherById(id,state);
    }

    @RequestMapping("/selectBilingualTeacherByState")
    @ResponseBody
    public BilingualTeacher[] selectBilingualTeacherByState (String state , String department){
        System.out.println(state+"-"+department);
        BilingualTeacher[] data = serviceClass.selectByStateAndDepartment(state,department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectBilingualTeacherById")
    @ResponseBody
    public BilingualTeacher selectBilingualTeacherById (int id){
        System.out.println(id);
        BilingualTeacher data = serviceClass.selectById(id);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertBilingualTeacher")
    @ResponseBody
    public void insertBilingualTeacher(@RequestBody BilingualTeacher bilingualTeacher){
        serviceClass.insert(bilingualTeacher.getName(),bilingualTeacher.getSex(),bilingualTeacher.getEducation(),
                bilingualTeacher.getTeachingSubject(),bilingualTeacher.getCertificate(),bilingualTeacher.getDepartment());
    }

    @PostMapping("/updateBilingualTeacher")
    @ResponseBody
    public void updateBilingualTeacher(@RequestBody BilingualTeacher bilingualTeacher){
        System.out.println(bilingualTeacher);
        serviceClass.update(bilingualTeacher.getId(),bilingualTeacher.getName(),bilingualTeacher.getSex(),bilingualTeacher.getEducation(),
                bilingualTeacher.getTeachingSubject(),bilingualTeacher.getCertificate(),bilingualTeacher.getDepartment(),
                bilingualTeacher.getState());
    }

    @RequestMapping("/selectBilingualTeacherByNameAndState")
    @ResponseBody
    public BilingualTeacher[] selectBilingualTeacherByNameAndState(String name, String state, String department) {
        System.out.println(name + "-" + state + "-" + department);
        BilingualTeacher[] data = serviceClass.selectByNameAndStateAndDepartment(name, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectBilingualTeacherByName")
    @ResponseBody
    public BilingualTeacher[] selectBilingualTeacherByName(String name, String department){
        BilingualTeacher[] data = serviceClass.selectByNameAndDepartment(name, department);
        System.out.println(data);
        return data;
    }

}
