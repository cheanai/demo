package com.demo.service;

import com.demo.dao.ApplyPhdDao;
import com.demo.entity.ApplyPhd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ApplyPhdService {

    @Autowired
    ApplyPhdDao dao;

    public ApplyPhd[] select(String department) {
        return dao.select(department);
    }

    public ApplyPhd[] selectApplyPhdBystate(String state, String department) {
        return dao.selectApplyPhdBystate(state, department);
    }

    public ApplyPhd selectApplyPhdById(String id) {
        return dao.selectApplyPhdById(id);
    }

    public ApplyPhd[] selectApplyPhdByName(String name, String department) {
        return dao.selectApplyPhdByName(name, department);
    }

    public ApplyPhd[] selectApplyPhdByNameAndstate(String state, String name, String department) {
        return dao.selectApplyPhdByNameAndstate(state, name, department);
    }

    public void insert(String name, String sex, String major, String university, String department, Date date, String state) {
        dao.insert(name, sex, major, university, department, date, state);
    }

    public void update(int id, String name, String sex, String major, String university, String department, Date date) {
        dao.update(id, name, sex, major, university, department, date);
    }
}
