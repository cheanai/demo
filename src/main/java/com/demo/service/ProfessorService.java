package com.demo.service;

import com.demo.dao.ProfessorDao;
import com.demo.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorDao dao;

    @Cacheable(value = "mycache-Professor")
    public Professor[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-Professor")
    public Professor[] selectProfessorByState(String state, String department) {
        return dao.selectProfessorByState(state, department);
    }

    @Cacheable(value = "mycache-Professor")
    public Professor selectProfessorById(int id) {
        return dao.selectProfessorById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-Professor", allEntries = true)
    public void insert(String name, String sex, String title, String department, String researchField) {
        dao.insert(name, sex, title, department, researchField);
    }

    @Transactional
    @CacheEvict(value = "mycache-Professor", allEntries = true)
    public void update(int id, String name, String sex, String title, String department, String researchField) {
        dao.update(id, name, sex, title, department, researchField);
    }

    @Cacheable(value = "mycache-Professor")
    public Professor[] selectProfessorByNameAndState(String name, String state, String department) {
        return dao.selectProfessorByNameAndState(name, state, department);
    }

    @Cacheable(value = "mycache-Professor")
    public Professor[] selectProfessorByName(String name, String department) {
        return dao.selectProfessorByName(name, department);
    }
}
