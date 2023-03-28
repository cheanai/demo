package com.demo.service;

import com.demo.dao.DoctorInfoDao;
import com.demo.entity.DoctorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorInfoService {

    @Autowired
    DoctorInfoDao dao;
    public DoctorInfo[] select(String department) {
        DoctorInfo[] doctorInfo = dao.findAllDoctorInfo(department);
        return doctorInfo;
    }

    public DoctorInfo[] selectDoctorInfoByState(String state, String department) {
        DoctorInfo[] doctorInfo = dao.selectDoctorInfoByState(state,department);
        return doctorInfo;
    }

    public DoctorInfo selectDoctorInfoById(String id) {
        DoctorInfo doctorInfo = dao.selectDoctorInfoById(id);
        return doctorInfo;
    }

    public DoctorInfo[] selectDoctorInfoByNameAndState(String state, String name, String department) {
        DoctorInfo[] doctorInfo = dao.selectDoctorInfoByNameAndState(state,name,department);
        return doctorInfo;
    }

    @Transactional
    public void insert(String name, String sex, String nationality, String gradschool, String department) {
        dao.insert(name,sex,nationality,gradschool,department);
    }

    @Transactional
    public void update(int id, String name, String sex, String nationality, String gradschool, String department) {
        dao.update(id,name,sex,nationality,gradschool,department);
    }

    public DoctorInfo[] selectDoctorInfoByName(String name, String department) {
        DoctorInfo[] doctorInfo = dao.selectDoctorInfoByName(name,department);
        return doctorInfo;
    }
}
