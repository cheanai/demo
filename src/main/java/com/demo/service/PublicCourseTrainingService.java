package com.demo.service;

import com.demo.dao.PublicCourseTrainingDao;
import com.demo.entity.PublicCourseTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class PublicCourseTrainingService {

    @Autowired
    PublicCourseTrainingDao dao;

    @Cacheable(value = "mycache-PublicCourseTraining")
    public PublicCourseTraining[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-PublicCourseTraining")
    public PublicCourseTraining[] selectPublicCourseTrainingByState(String state, String department) {
        return dao.selectPublicCourseTrainingByState(state, department);
    }

    @Cacheable(value = "mycache-PublicCourseTraining")
    public PublicCourseTraining selectPublicCourseTrainingById(int id) {
        return dao.selectPublicCourseTrainingById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-PublicCourseTraining", allEntries = true)
    public void insert(String teacherName, String trainingName, Date trainingTime, double trainingHours, String department) {
        dao.insert(teacherName, trainingName, trainingTime, trainingHours, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-PublicCourseTraining", allEntries = true)
    public void update(int id, String teacherName, String trainingName, Date trainingTime, double trainingHours, String department) {
        dao.update(id, teacherName, trainingName, trainingTime, trainingHours, department);
    }

    @Cacheable(value = "mycache-PublicCourseTraining")
    public PublicCourseTraining[] selectPublicCourseTrainingByNameAndState(String teacherName, String state, String department) {
        return dao.selectPublicCourseTrainingByNameAndState(teacherName, state, department);
    }

    @Cacheable(value = "mycache-PublicCourseTraining")
    public PublicCourseTraining[] selectByTeacherNameAndDepartment(String teacherName, String department) {
        return dao.selectByTeacherNameAndDepartment(teacherName, department);
    }
}
