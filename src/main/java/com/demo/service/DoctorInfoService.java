package com.demo.service;

import com.demo.dao.DoctorInfoDao;
import com.demo.entity.DoctorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorInfoService {

    @Autowired
    DoctorInfoDao dao;
    @Cacheable(value = "mycache-DoctorInfo")
    public DoctorInfo[] select(String department) {
        DoctorInfo[] doctorInfo = dao.findAllDoctorInfo(department);
        return doctorInfo;
    }

    @Cacheable(value = "mycache-DoctorInfo")
    public DoctorInfo[] selectDoctorInfoByState(String state, String department) {
        DoctorInfo[] doctorInfo = dao.selectDoctorInfoByState(state,department);
        return doctorInfo;
    }

    @Cacheable(value = "mycache-DoctorInfo")
    public DoctorInfo selectDoctorInfoById(String id) {
        DoctorInfo doctorInfo = dao.selectDoctorInfoById(id);
        return doctorInfo;
    }

    @Cacheable(value = "mycache-DoctorInfo")
    public DoctorInfo[] selectDoctorInfoByNameAndState(String state, String name, String department) {
        DoctorInfo[] doctorInfo = dao.selectDoctorInfoByNameAndState(state,name,department);
        return doctorInfo;
    }

    @CacheEvict(allEntries = true,value = "mycache-DoctorInfo")
    @Transactional
    public void insert(String name, String sex, String nationality, String gradschool, String department) {
        dao.insert(name,sex,nationality,gradschool,department);
    }

    @CacheEvict(allEntries = true,value = "mycache-DoctorInfo")
    @Transactional
    public void update(int id, String name, String sex, String nationality, String gradschool, String department) {
        dao.update(id,name,sex,nationality,gradschool,department);
    }

    @Cacheable(value = "mycache-DoctorInfo")
    public DoctorInfo[] selectDoctorInfoByName(String name, String department) {
        DoctorInfo[] doctorInfo = dao.selectDoctorInfoByName(name,department);
        return doctorInfo;
    }

    @Cacheable(value = "mycache-DoctorInfo")
    public DoctorInfo[] selectAll() {
        return dao.selectAll();
    }

    @Transactional
    @CacheEvict(value = "mycache-DoctorInfo",allEntries = true)
    public void updateDoctorInfoById(int id, String state) {
        dao.updateDoctorInfoById(id,state);
    }
}
