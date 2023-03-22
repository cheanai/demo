package com.demo.controller;

import com.demo.service.serviceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class controller {

    @Autowired
    public serviceClass serviceClass;

    @RequestMapping("/login")
    @ResponseBody
    public boolean login (String userName ,String pwd ){
        boolean state = serviceClass.login(userName,pwd);
        System.out.println(state);
        return state;
    }
}
