package com.demo.service;

import com.demo.dao.AssociateProfessorDao;
import com.demo.entity.AssociateProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssociateProfessorService {

    @Autowired
    AssociateProfessorDao dao;

    @Cacheable(value = "mycache-AssociateProfessor")
    public AssociateProfessor[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-AssociateProfessor")
    public AssociateProfessor[] selectAssociateProfessorByState(String state, String department) {
        return dao.selectAssociateProfessorByState(state, department);
    }

    @Cacheable(value = "mycache-AssociateProfessor")
    public AssociateProfessor selectAssociateProfessorById(int id) {
        return dao.selectAssociateProfessorById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-AssociateProfessor", allEntries = true)
    public void insert(String name, String sex, String title, String department, String researchField) {
        dao.insert(name, sex, title, department, researchField);
    }

    @Transactional
    @CacheEvict(value = "mycache-AssociateProfessor", allEntries = true)
    public void update(int id, String name, String sex, String title, String department, String researchField) {
        dao.update(id, name, sex, title, department, researchField);
    }

    @Cacheable(value = "mycache-AssociateProfessor")
    public AssociateProfessor[] selectAssociateProfessorByNameAndState(String name, String state, String department) {
        return dao.selectAssociateProfessorByNameAndState(name, state, department);
    }

    @Cacheable(value = "mycache-AssociateProfessor")
    public AssociateProfessor[] selectAssociateProfessorByName(String name, String department) {
        return dao.selectAssociateProfessorByName(name, department);
    }

    @Cacheable(value = "mycache-AssociateProfessor")
    public AssociateProfessor[] selectAll() {
        return dao.selectAll();
    }

    @Transactional
    @CacheEvict(value = "mycache-AssociateProfessor",allEntries = true)
    public void updateAssociateProfessorById(int id, String state) {
        dao.updateAssociateProfessorById(id,state);
    }
}
