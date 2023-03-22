package com.demo.service;

import com.demo.dao.IuserDao;
import com.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceClass {

    @Autowired
    IuserDao IuserDao;

    public boolean login(String userName ,String pwd){
        Users user = IuserDao.findUserByUserName(userName);
        System.out.println(user);
        return false;
    }
}
