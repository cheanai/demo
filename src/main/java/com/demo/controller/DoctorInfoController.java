package com.demo.controller;

import com.demo.entity.DoctorInfo;
import com.demo.service.DoctorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class DoctorInfoController {

    @Autowired
    public DoctorInfoService serviceClass;

    @RequestMapping("/selectDoctorInfo")
    @ResponseBody
    public DoctorInfo[] login (String department){
        DoctorInfo[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectDoctorInfoByState")
    @ResponseBody
    public DoctorInfo[] selectDoctorInfoByState (String state , String department){
        System.out.println(state+"-"+department);
        DoctorInfo[] data = serviceClass.selectDoctorInfoByState(state,department);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/selectDoctorInfoById")
    @ResponseBody
    public DoctorInfo selectDoctorInfoByState (String id){
        System.out.println(id);
        DoctorInfo data = serviceClass.selectDoctorInfoById(id);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectDoctorInfoByName")
    @ResponseBody
    public DoctorInfo[] selectDoctorInfoByName (String name , String department){
        System.out.println(name+"-"+department);
        DoctorInfo[] data = serviceClass.selectDoctorInfoByName(name,department);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/selectDoctorInfoByNameAndState")
    @ResponseBody
    public DoctorInfo[] selectDoctorInfoByNameAndState (String state, String name , String department){
        System.out.println(state+"-"+name+"-"+department);
        DoctorInfo[] data = serviceClass.selectDoctorInfoByNameAndState(state,name,department);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertDoctorInfo")
    @ResponseBody
    public void insertDoctorInfo(@RequestBody DoctorInfo DoctorInfo){
        serviceClass.insert(DoctorInfo.getName(),DoctorInfo.getSex(),DoctorInfo.getNationality(),DoctorInfo.getGradschool(),DoctorInfo.getDepartment());
    }

    @PostMapping("/updateDoctorInfo")
    @ResponseBody
    public void updateDoctorInfo(@RequestBody DoctorInfo DoctorInfo){
        System.out.println(DoctorInfo);
        serviceClass.update(DoctorInfo.getId(),DoctorInfo.getName(),DoctorInfo.getSex(),DoctorInfo.getNationality(),DoctorInfo.getGradschool(),DoctorInfo.getDepartment());
    }
}
