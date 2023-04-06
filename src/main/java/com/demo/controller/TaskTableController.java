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
}
