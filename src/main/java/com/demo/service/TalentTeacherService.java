package com.demo.service;

import com.demo.dao.TalentTeacherDao;
import com.demo.entity.TalentTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TalentTeacherService {

    @Autowired
    private TalentTeacherDao dao;

    @Cacheable(value = "mycache-TalentTeacher")
    public TalentTeacher[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-TalentTeacher")
    public TalentTeacher[] selectTalentTeacherByState(String state, String department) {
        return dao.selectTalentTeacherByState(state, department);
    }

    @Cacheable(value = "mycache-TalentTeacher")
    public TalentTeacher selectTalentTeacherById(int id) {
        return dao.selectTalentTeacherById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-TalentTeacher", allEntries = true)
    public void insert(String name, String sex, String department, String title, String talentTitle) {
        dao.insert(name, sex, department, title, talentTitle);
    }

    @Transactional
    @CacheEvict(value = "mycache-TalentTeacher", allEntries = true)
    public void update(int id, String name, String sex, String department, String title, String talentTitle) {
        dao.update(id, name, sex, department, title, talentTitle);
    }

    @Cacheable(value = "mycache-TalentTeacher")
    public TalentTeacher[] selectTalentTeacherByNameAndState(String name, String state, String department) {
        return dao.selectTalentTeacherByNameAndState(name, state, department);
    }

    @Cacheable(value = "mycache-TalentTeacher")
    public TalentTeacher[] selectByTeacherNameAndDepartment(String name, String department) {
        return dao.selectByTeacherNameAndDepartment(name, department);
    }
}
