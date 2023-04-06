package com.demo.service;

import com.demo.dao.ForeignTeacherWorkloadDao;
import com.demo.entity.ForeignTeacherWorkload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForeignTeacherWorkloadService {
    @Autowired
    private ForeignTeacherWorkloadDao dao;

    @Cacheable(value = "mycache-ForeignTeacherWorkload")
    public ForeignTeacherWorkload[] selectByTeacherNameAndDepartment(String teacherName, String department) {
        return dao.selectByTeacherNameAndDepartment(teacherName, department);
    }

    @Cacheable(value = "mycache-ForeignTeacherWorkload")
    public ForeignTeacherWorkload[] select(String department) {
        return dao.select(department);
    }

    @Transactional
    @CacheEvict(value = "mycache-ForeignTeacherWorkload", allEntries = true)
    public void insert(String teacherName, String courseName, int courseHours, String courseType, String department) {
        dao.insert(teacherName, courseName, courseHours, courseType, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-ForeignTeacherWorkload", allEntries = true)
    public void update(int id, String teacherName, String courseName, int courseHours, String courseType, String department) {
        dao.update(id, teacherName, courseName, courseHours, courseType, department);
    }

    @Cacheable(value = "mycache-ForeignTeacherWorkload")
    public ForeignTeacherWorkload selectById(int id) {
        return dao.selectById(id);
    }

    @Cacheable(value = "mycache-ForeignTeacherWorkload")
    public ForeignTeacherWorkload[] selectByTeacherNameAndState(String teacherName, String state, String department) {
        return dao.selectByTeacherNameAndState(teacherName, state, department);
    }

    @Cacheable(value = "mycache-ForeignTeacherWorkload")
    public ForeignTeacherWorkload[] selectByStateAndDepartment(String state, String department) {
        return dao.selectByStateAndDepartment(state, department);
    }

    @Cacheable(value = "mycache-ForeignTeacherWorkload")
    public ForeignTeacherWorkload[] selectAll() {
        return dao.selectAll();
    }

    @Transactional
    @CacheEvict(value = "mycache-ForeignTeacherWorkload",allEntries = true)
    public void updateForeignTeacherWorkloadById(int id, String state) {
        dao.updateForeignTeacherWorkloadById(id,state);
    }
}
