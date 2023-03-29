package com.demo.service;

import com.demo.dao.StudyAbroadDao;
import com.demo.entity.StudyAbroad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class StudyAbroadService {

    @Autowired
    StudyAbroadDao dao;

    @Cacheable(value = "mycache-StudyAbroad")
    public StudyAbroad[] select(String department) {
        System.out.println("---------------------------");
        return dao.selectStudyAbroad(department);
    }
    @Cacheable(value = "mycache-StudyAbroad")
    public StudyAbroad[] selectStudyAbroadByState(String state, String department) {
        return dao.selectStudyAbroadByState(state, department);
    }

    @Cacheable(value = "mycache-StudyAbroad")
    public StudyAbroad selectStudyAbroadById(String id) {
        return dao.selectStudyAbroadById(id);
    }

    @Cacheable(value = "mycache-StudyAbroad")
    public StudyAbroad[] selectStudyAbroadByTeacherName(String teacherName, String department) {
        return dao.selectStudyAbroadByTeacherName(teacherName, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-StudyAbroad",allEntries = true)
    public void insert(String teacherName, String destination, Date startDate, String studyContent, String department) {
        dao.insertStudyAbroad(teacherName, destination, startDate, studyContent, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-StudyAbroad",allEntries = true)
    public void update(int id, String teacherName, String destination, Date startDate, String studyContent, String department) {
        dao.updateStudyAbroad(id, teacherName, destination, startDate, studyContent, department);
    }

    @Cacheable(value = "mycache-StudyAbroad")
    public StudyAbroad[] selectStudyAbroadByNameAndState(String teacherName, String state, String department) {
        return dao.selectStudyAbroadByNameAndState(teacherName,state, department);
    }
}
