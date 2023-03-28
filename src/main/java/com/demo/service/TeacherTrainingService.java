package com.demo.service;

import com.demo.dao.TeacherTrainingDao;
import com.demo.entity.TeacherTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TeacherTrainingService {

    @Autowired
    TeacherTrainingDao dao;

    public TeacherTraining[] select(String department) {
        return dao.select(department);
    }

    public TeacherTraining[] selectTeacherTrainingByState(String state, String department) {
        return dao.selectTeacherTrainingByState(state, department);
    }

    public TeacherTraining selectTeacherTrainingById(String id) {
        return dao.selectTeacherTrainingById(id);
    }

    public void insert(String teacherName, String trainingType, String trainingTopic, Date trainingStartTime, String department) {
        dao.insert(teacherName, trainingType, trainingTopic, trainingStartTime, department);
    }

    public void update(int id, String teacherName, String trainingType, String trainingTopic, Date trainingStartTime, String department) {
        dao.update(id, teacherName, trainingType, trainingTopic, trainingStartTime, department);
    }

    public TeacherTraining[] selectTeacherTrainingByName(String TeacherName, String department) {
        return dao.selectTeacherTrainingByName(TeacherName, department);
    }

    public TeacherTraining[] selectTeacherTrainingByNameAndState(String state, String TeacherName, String department) {
        return dao.selectTeacherTrainingByNameAndState(state, TeacherName, department);
    }
}
