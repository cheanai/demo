package com.demo.controller;

import com.demo.entity.ApplyPhd;
import com.demo.service.ApplyPhdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class ApplyPhdController {

    @Autowired
    public ApplyPhdService serviceClass;

    @RequestMapping("/selectApplyPhd")
    @ResponseBody
    public ApplyPhd[] login(String department) {
        ApplyPhd[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectApplyPhdByState")
    @ResponseBody
    public ApplyPhd[] selectApplyPhdBystate(String state, String department) {
        System.out.println(state + "-" + department);
        ApplyPhd[] data = serviceClass.selectApplyPhdBystate(state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectApplyPhdById")
    @ResponseBody
    public ApplyPhd selectApplyPhdById(String id) {
        System.out.println(id);
        ApplyPhd data = serviceClass.selectApplyPhdById(id);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectApplyPhdByName")
    @ResponseBody
    public ApplyPhd[] selectApplyPhdByName(String name, String department) {
        System.out.println(name + "-" + department);
        ApplyPhd[] data = serviceClass.selectApplyPhdByName(name, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectApplyPhdByNameAndState")
    @ResponseBody
    public ApplyPhd[] selectApplyPhdByNameAndstate(String state, String name, String department) {
        System.out.println(state + "-" + name + "-" + department);
        ApplyPhd[] data = serviceClass.selectApplyPhdByNameAndstate(state, name, department);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertApplyPhd")
    @ResponseBody
    public void insertApplyPhd(@RequestBody ApplyPhd applyPhd) {
        System.out.println(applyPhd);
        serviceClass.insert(applyPhd.getName(), applyPhd.getSex(), applyPhd.getMajor(), applyPhd.getUniversity(), applyPhd.getDepartment(), applyPhd.getDate(), applyPhd.getState());
    }

    @PostMapping("/updateApplyPhd")
    @ResponseBody
    public void updateApplyPhd(@RequestBody ApplyPhd applyPhd) {
        System.out.println(applyPhd);
        serviceClass.update(applyPhd.getId(), applyPhd.getName(), applyPhd.getSex(), applyPhd.getMajor(), applyPhd.getUniversity(), applyPhd.getDepartment(), applyPhd.getDate());
    }
}
