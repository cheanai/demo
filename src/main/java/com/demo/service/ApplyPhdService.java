package com.demo.service;

import com.demo.dao.ApplyPhdDao;
import com.demo.dao.ScoreDao;
import com.demo.dao.TaskTableDao;
import com.demo.entity.ApplyPhd;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.sql.Date;
import java.util.Arrays;
import java.util.Map;

@Service
public class ApplyPhdService {

    @Autowired
    ApplyPhdDao dao;
    @Autowired
    TaskTableDao dao1;
    @Autowired
    ScoreDao dao2;

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
        String department = dao.selectDepartment(id);
        double i = dao1.selectTaskTableByTarget("报考博士数",department);
        ApplyPhd[] applyPhds = dao.selectApplyPhdBystate("已通过", department);
        Map<String,Double> selectInfo = dao2.selectInfo(department, "train_int_score", "doctoral_applicants");
        System.out.println(selectInfo.toString());
        double score = (applyPhds.length / i)*5 ;
        System.out.println(applyPhds.length +"-"+ i +"-"+(applyPhds.length / i) +"-"+score);
        double i1 = score - selectInfo.get("doctoral_applicants");
        double i2 = selectInfo.get("train_int_score")+i1;
        double i3 = selectInfo.get("total_score")+i1;
        dao2.update(department,"doctoral_applicants",score,"train_int_score",i2,i3);
    }
}
