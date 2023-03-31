package com.demo.service;

import com.demo.dao.ForeignTeacherDao;
import com.demo.entity.ForeignTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ForeignTeacherService {

    @Autowired
    private ForeignTeacherDao dao;

    @Cacheable(value = "mycache-ForeignTeacher")
    public ForeignTeacher[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-ForeignTeacher")
    public ForeignTeacher[] selectByState(String state, String department) {
        return dao.selectByState(state, department);
    }

    @Cacheable(value = "mycache-ForeignTeacher")
    public ForeignTeacher selectById(int id) {
        return dao.selectById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-ForeignTeacher", allEntries = true)
    public void insert(String name, String sex, String nationality, String department, String title) {
        dao.insert(name, sex, nationality, department, title);
    }

    @Transactional
    @CacheEvict(value = "mycache-ForeignTeacher", allEntries = true)
    public void update(int id, String name, String sex, String nationality, String department, String title) {
        dao.update(id, name, sex, nationality, department, title);
    }

    @Cacheable(value = "mycache-ForeignTeacher")
    public ForeignTeacher[] selectByName(String name, String department) {
        return dao.selectByName(name, department);
    }

    @Cacheable(value = "mycache-ForeignTeacher")
    public ForeignTeacher[] selectForeignTeacherByNameAndState(String name, String state) {
        return dao.selectForeignTeacherByNameAndState(name, state);
    }
}
