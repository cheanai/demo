package com.demo.service;

import com.demo.dao.IEducationTrainingInfo;
import com.demo.entity.EducationTrainingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EducationTrainingService {

    @Autowired
    IEducationTrainingInfo educationTrainingInfo;

    public EducationTrainingInfo[] select() {
        EducationTrainingInfo[] educationTrainingInfos = educationTrainingInfo.findAllEducationTrainingInfo();
        return educationTrainingInfos;
    }

    @Transactional
    public void insert(String title, String type, String location, Date time,String department){
        educationTrainingInfo.insert(title,type,location,time,department);
    }
}
