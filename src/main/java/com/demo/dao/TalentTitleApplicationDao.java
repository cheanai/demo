package com.demo.dao;

import com.demo.entity.TalentTitleApplication;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface TalentTitleApplicationDao {
    @Select("SELECT * FROM talent_title_application WHERE department = #{department}")
    TalentTitleApplication[] select(String department);

    @Select("SELECT * FROM talent_title_application WHERE state = #{state} AND department = #{department}")
    TalentTitleApplication[] selectTalentTitleApplicationByState(String state, String department);

    @Select("SELECT * FROM talent_title_application WHERE id = #{id}")
    TalentTitleApplication selectTalentTitleApplicationById(int id);

    @Insert("INSERT INTO talent_title_application (name, sex, title, date, category, unit, state, department) " +
            "VALUES (#{name},#{sex},#{title},#{date},#{category},#{unit},'未审核',#{department})")
    void insert(String name, String sex, String title, Date date, String category, String unit, String department);

    @Update("UPDATE talent_title_application SET name = #{name}, sex = #{sex}, title = #{title}, " +
            "date = #{date}, category = #{category}, unit = #{unit}, state = '未审核', department = #{department} " +
            "WHERE id = #{id}")
    void update(int id, String name, String sex, String title, Date date, String category, String unit, String department);

    @Select("SELECT * FROM talent_title_application WHERE name like CONCAT('%', #{name}, '%') " +
            "AND state = #{state} AND department = #{department}")
    TalentTitleApplication[] selectTalentTitleApplicationByNameAndState(String name, String state, String department);

    @Select("SELECT * FROM talent_title_application WHERE name like CONCAT('%', #{name}, '%') " +
            "AND department = #{department}")
    TalentTitleApplication[] selectTalentTitleApplicationByName(String name, String department);
}
