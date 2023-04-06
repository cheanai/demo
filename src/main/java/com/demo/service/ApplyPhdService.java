package com.demo.service;

import com.demo.dao.ApplyPhdDao;
import com.demo.entity.ApplyPhd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class ApplyPhdService {

    @Autowired
    ApplyPhdDao dao;

    @Cacheable(value = "mycache-ApplyPhd")
    public ApplyPhd[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-ApplyPhd")
    public ApplyPhd[] selectApplyPhdBystate(String state, String department) {
        return dao.selectApplyPhdBystate(state, department);
    }

    @Cacheable(value = "mycache-ApplyPhd")
    public ApplyPhd selectApplyPhdById(String id) {
        return dao.selectApplyPhdById(id);
    }

    @Cacheable(value = "mycache-ApplyPhd")
    public ApplyPhd[] selectApplyPhdByName(String name, String department) {
        return dao.selectApplyPhdByName(name, department);
    }

    @Cacheable(value = "mycache-ApplyPhd")
    public ApplyPhd[] selectApplyPhdByNameAndstate(String state, String name, String department) {
        return dao.selectApplyPhdByNameAndstate(state, name, department);
    }

    @Transactional
    @CacheEvict(value = "mycache-ApplyPhd",allEntries = true)
    public void insert(String name, String sex, String major, String university, String department, Date date, String state) {
        dao.insert(name, sex, major, university, department, date, state);
    }

    @Transactional
    @CacheEvict(value = "mycache-ApplyPhd",allEntries = true)
    public void update(int id, String name, String sex, String major, String university, String department, Date date) {
        dao.update(id, name, sex, major, university, department, date);
    }

    @Cacheable(value = "mycache-ApplyPhd")
    public ApplyPhd[] selectAll() {
        return dao.selectAll();
    }

    @Transactional
    @CacheEvict(value = "mycache-ApplyPhd",allEntries = true)
    public void updateApplyPhdById(int id, String state) {
        dao.updateApplyPhdById(id,state);
    }
}
