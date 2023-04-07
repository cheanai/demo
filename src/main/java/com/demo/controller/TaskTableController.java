package com.demo.controller;

import com.demo.entity.TaskTable;
import com.demo.entity.TeacherTraining;
import com.demo.service.TaskTableService;
import com.demo.service.TeacherTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@CrossOrigin
public class TaskTableController {

    @Autowired
    public TaskTableService serviceClass;

    @RequestMapping("/selectAllTaskTable")
    @ResponseBody
    public TaskTable[] selectAllTeacherTraining (){
        TaskTable[] data = serviceClass.selectAll();

        return data;
    }

    @RequestMapping("/selectTaskTableByCollegeAndState")
    @ResponseBody
    public TaskTable[] selectTaskTableByCollegeAndState(String college, String state) {
        TaskTable[] data = serviceClass.selectTaskTableByCollegeAndState(college, state);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/selectTaskTableByCollege")
    @ResponseBody
    public TaskTable[] selectTaskTableByCollege(String college) {
        TaskTable[] data = serviceClass.selectTaskTableByCollege(college);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/selectTaskTableByState")
    @ResponseBody
    public TaskTable[] selectTaskTableByState(String state) {
        TaskTable[] data = serviceClass.selectTaskTableByState(state);
        System.out.println(Arrays.toString(data));
        return data;
    }

    @RequestMapping("/updateTaskTableById")
    @ResponseBody
    public void updateApplyPhdById(int id,String state) {
        serviceClass.updateTaskTableById(id,state);
    }
}
