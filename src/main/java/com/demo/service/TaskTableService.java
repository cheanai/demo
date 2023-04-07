package com.demo.service;

import com.demo.dao.TaskTableDao;
import com.demo.entity.TaskTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskTableService {

    @Autowired
    TaskTableDao dao;

    @CacheEvict(value = "mycache-TaskTable", allEntries = true)
    @Transactional
    public void insert(String college, String secondaryIndicators, String tertiaryIndicators, int taskVolume, String date) {
        dao.insert(college,secondaryIndicators,tertiaryIndicators,taskVolume,date);
    }

    @Cacheable(value = "mycache-TaskTable")
    public TaskTable[] selectAll() {
        return dao.selectAll();
    }

    @Cacheable(value = "mycache-TaskTable")
    public TaskTable[] selectTaskTableByCollegeAndState(String college, String state) {
        return dao.selectTaskTableByCollegeAndState(college,state);
    }

    @Cacheable(value = "mycache-TaskTable")
    public TaskTable[] selectTaskTableByCollege(String college) {
        return dao.selectTaskTableByCollege(college);
    }

    @Cacheable(value = "mycache-TaskTable")
    public TaskTable[] selectTaskTableByState(String state) {
        return dao.selectTaskTableByState(state);
    }

    @CacheEvict(value = "mycache-TaskTable", allEntries = true)
    @Transactional
    public void updateTaskTableById(int id, String state) {
        dao.updateTaskTableById(id,state);
    }
}
