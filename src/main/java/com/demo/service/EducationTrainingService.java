package com.demo.service;

import com.demo.dao.IEducationTrainingInfo;
import com.demo.entity.EducationTrainingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EducationTrainingService {

    @Autowired
    IEducationTrainingInfo educationTrainingInfo;

    @Cacheable(value = "mycache-EducationTrainingInfo")
    public EducationTrainingInfo[] select(String department) {
        EducationTrainingInfo[] educationTrainingInfos = educationTrainingInfo.findAllEducationTrainingInfo(department);
        return educationTrainingInfos;
    }

    @Cacheable(value = "mycache-EducationTrainingInfo")
    public EducationTrainingInfo[] selectEducationTrainingByState(String state , String department) {
        EducationTrainingInfo[] educationTrainingInfos = educationTrainingInfo.findEducationTrainingInfoByState(state,department);
        return educationTrainingInfos;
    }

    @CacheEvict(value = "mycache-EducationTrainingInfo",allEntries = true)
    @Transactional
    public void insert(String title, String type, String location, Date time,String department){
        educationTrainingInfo.insert(title,type,location,time,department);
    }

    @CacheEvict(value = "mycache-EducationTrainingInfo",allEntries = true)
    @Transactional
    public void update(int id ,String title, String type, String location, Date time,String department){
        educationTrainingInfo.update(id,title,type,location,time,department);
    }

    @Cacheable(value = "mycache-EducationTrainingInfo")
    public EducationTrainingInfo[] selectEducationTrainingByTitle(String title, String department) {
        EducationTrainingInfo[] educationTrainingInfos = educationTrainingInfo.findEducationTrainingInfoByTitle(title,department);
        return educationTrainingInfos;
    }

    @Cacheable(value = "mycache-EducationTrainingInfo")
    public EducationTrainingInfo[] selectEducationTrainingByTitleAndState(String state, String title, String department) {
        EducationTrainingInfo[] educationTrainingInfos = educationTrainingInfo.findEducationTrainingInfoByTitleAndState(state,title,department);
        return educationTrainingInfos;
    }

    @Cacheable(value = "mycache-EducationTrainingInfo")
    public EducationTrainingInfo selectEducationTrainingById(String id) {
        EducationTrainingInfo educationTraining = educationTrainingInfo.findEducationTrainingInfoById(id);
        return educationTraining;
    }
}
