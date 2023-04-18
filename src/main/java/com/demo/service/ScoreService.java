package com.demo.service;

import com.demo.dao.ScoreDao;
import com.demo.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    ScoreDao dao;

    public Score[] getAllScores() {
        return dao.select();
    }

    public double[] selectTotalScore() {
        return dao.selectTotalScore();
    }
}
