package com.demo.dao;

import com.demo.entity.StudyAbroad;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface StudyAbroadDao {
    @Select("SELECT * FROM study_abroad WHERE department = #{department}")
    StudyAbroad[] selectStudyAbroad(String department);

    @Select("SELECT * FROM study_abroad WHERE state = #{state} AND department = #{department}")
    StudyAbroad[] selectStudyAbroadByState(String state, String department);

    @Select("SELECT * FROM study_abroad WHERE id = #{id}")
    StudyAbroad selectStudyAbroadById(String id);

    @Select("SELECT * FROM study_abroad WHERE teacher_name like CONCAT('%', #{teacherName}, '%') AND department = #{department}")
    StudyAbroad[] selectStudyAbroadByTeacherName(String teacherName, String department);

    @Insert("INSERT INTO study_abroad (teacher_name, destination, start_date, study_content, department, state) " +
            "VALUES (#{teacherName},#{destination},#{startDate},#{studyContent},#{department},'未审核')")
    void insertStudyAbroad(String teacherName, String destination, Date startDate, String studyContent, String department);

    @Update("UPDATE study_abroad SET teacher_name = #{teacherName}, destination = #{destination}, " +
            "start_date = #{startDate}, study_content = #{studyContent}, department = #{department}, " +
            "state = '未审核' WHERE id = #{id}")
    void updateStudyAbroad(int id, String teacherName, String destination, Date startDate, String studyContent, String department);

    @Select("SELECT * FROM study_abroad WHERE teacher_name like CONCAT('%', #{teacherName}, '%') " +
            "AND state = #{state} AND department = #{department}")
    StudyAbroad[] selectStudyAbroadByNameAndState(String teacherName, String state, String department);

    @Select("SELECT * FROM study_abroad")
    StudyAbroad[] selectAll();

    @Update("UPDATE study_abroad SET state = #{state} WHERE id = #{id}")
    void updateStudyAbroadById(int id, String state);
}
