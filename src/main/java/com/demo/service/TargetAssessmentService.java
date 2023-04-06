package com.demo.service;

import com.demo.dao.TargetAssessmentDao;
import com.demo.entity.TargetAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TargetAssessmentService {

    @Autowired
    TargetAssessmentDao dao;
    @Autowired
    TaskTableService dao1;

    @Cacheable(value = "mycache-TargetAssessment")
    public TargetAssessment[] select() {
        return dao.select();
    }

    @CacheEvict(value = "mycache-TargetAssessment", allEntries = true)
    @Transactional
    public void insert(String college, String secondaryIndicators, String tertiaryIndicators, int taskVolume, String date) {
        dao1.insert(college,secondaryIndicators,tertiaryIndicators,taskVolume,date);
        String Indicators = "";
        switch (tertiaryIndicators) {
            case  "宣传教育培养" : Indicators ="education_training";break;
            case  "引进或培养博士" : Indicators ="introduction_training_doctors";break;
            case  "报考博士数" : Indicators ="doctoral_applicants";break;
            case  "教师交流培训" : Indicators ="teacher_exchange_training";break;
            case  "访学单科进修" : Indicators ="visiting_study";break;
            case  "公需课培训" : Indicators ="public_class_training";break;
            case  "双师型教师" : Indicators ="dual_teachers";break;
            case  "新增教授" : Indicators ="new_professors";break;
            case  "新增副教授" : Indicators ="new_associate_professor";break;
            case  "新增厅局级称号" : Indicators ="new_titles";break;
            case  "人才称号申报" : Indicators ="talent_title_declaration";break;
            case  "聘请外教外文授课" : Indicators ="hire_foreign_teachers";break;
            case  "外教工作量" : Indicators ="foreign_teacher_workload";break;
            default: Indicators=null;
        }
        dao.update(college,Indicators,taskVolume,date);
    }

    @Cacheable(value = "mycache-TargetAssessment")
    public TargetAssessment[] selectTargetAssessmentByCollege(String college) {
        return dao.selectTargetAssessmentByCollege(college);
    }

    @Cacheable(value = "mycache-TargetAssessment")
    public TargetAssessment[] selectTargetAssessmentByCollegeAndState(String college, String state) {
        return dao.selectTargetAssessmentByCollegeAndState(college, state);
    }

    @Cacheable(value = "mycache-TargetAssessment")
    public TargetAssessment[] selectTargetAssessmentByState(String state) {
        return dao.selectTargetAssessmentByState(state);
    }

    @Cacheable(value = "mycache-TargetAssessment")
    public TargetAssessment selectTargetAssessmentById(int id) {
        return dao.selectTargetAssessmentById(id);
    }

}
