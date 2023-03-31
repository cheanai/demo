package com.demo.controller;

import com.demo.entity.TalentTeacher;
import com.demo.entity.TalentTitleApplication;
import com.demo.service.TalentTitleApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class TalentTitleApplicationController {

    @Autowired
    public TalentTitleApplicationService serviceClass;

    @RequestMapping("/selectTalentTitleApplication")
    @ResponseBody
    public TalentTitleApplication[] selectTalentTitleApplication(String department){
        TalentTitleApplication[] data = serviceClass.select(department);
        return data;
    }

    @RequestMapping("/selectTalentTitleApplicationByState")
    @ResponseBody
    public TalentTitleApplication[] selectTalentTitleApplicationByState (String state , String department){
        System.out.println(state+"-"+department);
        TalentTitleApplication[] data = serviceClass.selectTalentTitleApplicationByState(state,department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTalentTitleApplicationById")
    @ResponseBody
    public TalentTitleApplication selectTalentTitleApplicationById (int id){
        System.out.println(id);
        TalentTitleApplication data = serviceClass.selectTalentTitleApplicationById(id);
        System.out.println(data);
        return data;
    }

    @PostMapping("/insertTalentTitleApplication")
    @ResponseBody
    public void insertTalentTitleApplication(@RequestBody TalentTitleApplication talentTitleApplication){
        serviceClass.insert(talentTitleApplication.getName(),talentTitleApplication.getSex(),talentTitleApplication.getTitle(),
                talentTitleApplication.getDate(),talentTitleApplication.getCategory(),talentTitleApplication.getUnit(),talentTitleApplication.getDepartment());
    }

    @PostMapping("/updateTalentTitleApplication")
    @ResponseBody
    public void updateTalentTitleApplication(@RequestBody TalentTitleApplication talentTitleApplication){
        System.out.println(talentTitleApplication);
        serviceClass.update(talentTitleApplication.getId(),talentTitleApplication.getName(),talentTitleApplication.getSex(),talentTitleApplication.getTitle(),
                talentTitleApplication.getDate(),talentTitleApplication.getCategory(),talentTitleApplication.getUnit(),talentTitleApplication.getState(),talentTitleApplication.getDepartment());
    }

    @RequestMapping("/selectTalentTitleApplicationByNameAndState")
    @ResponseBody
    public TalentTitleApplication[] selectTalentTitleApplicationByNameAndState(String name, String state, String department) {
        System.out.println(name + "-" + state + "-" + department);
        TalentTitleApplication[] data = serviceClass.selectTalentTitleApplicationByNameAndState(name, state, department);
        System.out.println(data);
        return data;
    }

    @RequestMapping("/selectTalentTitleApplicationByName")
    @ResponseBody
    public TalentTitleApplication[] selectTalentTitleApplicationByName(String name, String department) {
        TalentTitleApplication[] data = serviceClass.selectTalentTitleApplicationByName(name, department);
        return data;
    }

}
