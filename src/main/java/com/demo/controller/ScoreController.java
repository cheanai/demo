package com.demo.controller;

import com.demo.entity.Score;
import com.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class ScoreController {

    @Autowired
    ScoreService service;

    // 查询所有学院得分信息
    @RequestMapping("/selectScore")
    @ResponseBody
    public Score[] getAllScores() {
        return service.getAllScores();
    }

    @RequestMapping("/selectTotalScore")
    @ResponseBody
    public double[] selectTotalScore() {
        return service.selectTotalScore();
    }
}
