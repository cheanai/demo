package com.demo.service;

import com.demo.dao.IuserDao;
import com.demo.entity.EducationTrainingInfo;
import com.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    IuserDao IuserDao;

    public Users login(String userName ,String pwd){
        Users user = IuserDao.findUserByUserName(userName,pwd);
        return user;
    }
}
