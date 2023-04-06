package com.demo.service;

import com.demo.dao.TeacherTrainingDao;
import com.demo.entity.TeacherTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class TeacherTrainingService {

    @Autowired
    TeacherTrainingDao dao;

    @Cacheable(value = "mycache-TeacherTraining")
    public TeacherTraining[] select(String department) {
        System.out.println("--------------------------------");
        return dao.select(department);
    }

    @Cacheable(value = "mycache-TeacherTraining")
    public TeacherTraining[] selectTeacherTrainingByState(String state, String department) {
        return dao.selectTeacherTrainingByState(state, department);
    }

    @Cacheable(value = "mycache-TeacherTraining")
    public TeacherTraining selectTeacherTrainingById(String id) {
        return dao.selectTeacherTrainingById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-TeacherTraining",allEntries = true)
    public void insert(String teacherName, String trainingType, String trainingTopic, Date trainingStartTime, String department) {
        dao.insert(teacherName, trainingType, trainingTopic, trainingStartTime, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-TeacherTraining",allEntries = true)
    public void update(int id, String teacherName, String trainingType, String trainingTopic, Date trainingStartTime, String department) {
        dao.update(id, teacherName, trainingType, trainingTopic, trainingStartTime, department);
    }

    @Cacheable(value = "mycache-TeacherTraining")
    public TeacherTraining[] selectTeacherTrainingByName(String TeacherName, String department) {
        return dao.selectTeacherTrainingByName(TeacherName, department);
    }

    @Cacheable(value = "mycache-TeacherTraining")
    public TeacherTraining[] selectTeacherTrainingByNameAndState(String state, String TeacherName, String department) {
        return dao.selectTeacherTrainingByNameAndState(state, TeacherName, department);
    }

    @Cacheable(value = "mycache-TeacherTraining")
    public TeacherTraining[] selectAll() {
        return dao.selectAll();
    }

    @Transactional
    @CacheEvict(value = "mycache-TeacherTraining",allEntries = true)
    public void updateTeacherTrainingById(int id, String state) {
        dao.updateTeacherTrainingById(id,state);
    }
}
