package com.demo.controller;

import com.demo.entity.EducationTrainingInfo;
import com.demo.entity.Users;
import com.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class userController {

    @Autowired
    public userService serviceClass;

    @RequestMapping("/login")
    @ResponseBody
    public Users login (String userName ,String pwd ){
        Users state = serviceClass.login(userName,pwd);
        System.out.println(state);
        return state;
    }


}
