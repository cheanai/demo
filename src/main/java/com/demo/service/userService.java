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

    public boolean updatePassword(String email, String newPassword) {
        try {
            IuserDao.updateByemail(email,newPassword);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean selectEmail(String emailAddress) {
        Users user = IuserDao.selectEmail(emailAddress);
        if (user!=null){
            return true;
        }else {
            return false;
        }
    }
}
