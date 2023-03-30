package com.demo.service;

import com.demo.dao.BilingualTeacherDao;
import com.demo.entity.BilingualTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BilingualTeacherService {

    @Autowired
    BilingualTeacherDao dao;

    @Cacheable(value = "mycache-BilingualTeacher")
    public BilingualTeacher[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-BilingualTeacher")
    public BilingualTeacher[] selectByStateAndDepartment(String state, String department) {
        return dao.selectByStateAndDepartment(state, department);
    }

    @Cacheable(value = "mycache-BilingualTeacher")
    public BilingualTeacher selectById(int id) {
        return dao.selectById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-BilingualTeacher", allEntries = true)
    public void insert(String name, String sex, String education, String teachingSubject, String certificate, String department) {
        dao.insert(name, sex, education, teachingSubject, certificate, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-BilingualTeacher", allEntries = true)
    public void update(int id, String name, String sex, String education, String teachingSubject, String certificate, String department, String state) {
        dao.update(id, name, sex, education, teachingSubject, certificate, department,state);
    }

    @Cacheable(value = "mycache-BilingualTeacher")
    public BilingualTeacher[] selectByNameAndStateAndDepartment(String name, String state, String department) {
        return dao.selectByNameAndStateAndDepartment(name, state, department);
    }

    @Cacheable(value = "mycache-BilingualTeacher")
    public BilingualTeacher[] selectByNameAndDepartment(String name, String department) {
        return dao.selectByNameAndDepartment(name, department);
    }
}
