package com.demo.dao;

import com.demo.entity.TalentTeacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentTeacherDao {
    @Select("SELECT * FROM talent_teacher WHERE department = #{department}")
    TalentTeacher[] select(String department);

    @Select("SELECT * FROM talent_teacher WHERE state = #{state} AND department = #{department}")
    TalentTeacher[] selectTalentTeacherByState(String state, String department);

    @Select("SELECT * FROM talent_teacher WHERE id = #{id}")
    TalentTeacher selectTalentTeacherById(int id);

    @Insert("INSERT INTO talent_teacher (name, sex, department, title, talent_title, state) " +
            "VALUES (#{name},#{sex},#{department},#{title},#{talentTitle},'未审核')")
    void insert(String name, String sex, String department, String title, String talentTitle);

    @Update("UPDATE talent_teacher SET name = #{name}, sex = #{sex}, department = #{department}, " +
            "title = #{title}, talent_title = #{talentTitle}, state = '未审核' WHERE id = #{id}")
    void update(int id, String name, String sex, String department, String title, String talentTitle);

    @Select("SELECT * FROM talent_teacher WHERE name like CONCAT('%', #{name}, '%') " +
            "AND state = #{state} AND department = #{department}")
    TalentTeacher[] selectTalentTeacherByNameAndState(String name, String state, String department);

    @Select("SELECT * FROM talent_teacher WHERE name like CONCAT('%', #{name}, '%') " +
            "AND department = #{department}")
    TalentTeacher[] selectByTeacherNameAndDepartment(String name, String department);
}
