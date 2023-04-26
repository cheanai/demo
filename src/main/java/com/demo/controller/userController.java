package com.demo.controller;

import com.demo.entity.EducationTrainingInfo;
import com.demo.entity.Users;
import com.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@Controller
public class userController {

    @Autowired
    public userService serviceClass;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/login")
    @ResponseBody
    public Users login (String userName ,String pwd ){
        Users state = serviceClass.login(userName,pwd);
        System.out.println(state);
        return state;
    }

    @RequestMapping("/sendResetPasswordEmail")
    @ResponseBody
    public String sendResetPasswordEmail(String emailAddress) {
        try {
            boolean isExist = serviceClass.selectEmail(emailAddress);
            if (!isExist){
                return "a";
            }
            Random random = new Random();
            String randomCode = String.format("%04d", random.nextInt(10000));
            System.out.println(randomCode);
            // 存储验证码到 Redis
            ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
            valueOps.set(emailAddress, randomCode, 5, TimeUnit.MINUTES); // 5 分钟过期
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("lc1308749008@126.com");
            message.setTo(emailAddress);
            message.setSubject("重置密码验证码");
            message.setText("您的验证码是：\n" + randomCode);

            mailSender.send(message);
            return "b";
        } catch (Exception e) {
            e.printStackTrace();
            return "c";
        }
    }

    @RequestMapping("/verifyResetCode")
    @ResponseBody
    public boolean verifyResetCode(String emailAddress, String code) {
        try {
            String storedCode = stringRedisTemplate.opsForValue().get(emailAddress);
            return code != null && code.equals(storedCode);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public boolean updatePassword(String email, String newPassword) {
        System.out.println(email+newPassword);
        try {
            return serviceClass.updatePassword(email, newPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
