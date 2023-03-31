package com.demo.service;

import com.demo.dao.TalentTitleApplicationDao;
import com.demo.entity.TalentTitleApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class TalentTitleApplicationService {

    @Autowired
    private TalentTitleApplicationDao dao;

    @Cacheable(value = "mycache-TalentTitleApplication")
    public TalentTitleApplication[] select(String department) {
        return dao.select(department);
    }

    @Cacheable(value = "mycache-TalentTitleApplication")
    public TalentTitleApplication[] selectTalentTitleApplicationByState(String state, String department) {
        return dao.selectTalentTitleApplicationByState(state, department);
    }

    @Cacheable(value = "mycache-TalentTitleApplication")
    public TalentTitleApplication selectTalentTitleApplicationById(int id) {
        return dao.selectTalentTitleApplicationById(id);
    }

    @Transactional
    @CacheEvict(value = "mycache-TalentTitleApplication", allEntries = true)
    public void insert(String name, String sex, String title, Date date, String category, String unit, String department) {
        dao.insert(name, sex, title, date, category, unit,department);
    }

    @Transactional
    @CacheEvict(value = "mycache-TalentTitleApplication", allEntries = true)
    public void update(int id, String name, String sex, String title, Date date, String category, String unit, String state, String department) {
        dao.update(id, name, sex, title, date, category, unit,department);
    }

    @Cacheable(value = "mycache-TalentTitleApplication")
    public TalentTitleApplication[] selectTalentTitleApplicationByNameAndState(String name, String state, String department) {
        return dao.selectTalentTitleApplicationByNameAndState(name, state, department);
    }

    @Cacheable(value = "mycache-TalentTitleApplication")
    public TalentTitleApplication[] selectTalentTitleApplicationByName(String name, String department) {
        return dao.selectTalentTitleApplicationByName(name, department);
    }
}
