package com.demo.dao;

import com.demo.entity.EducationTrainingInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IEducationTrainingInfo {

    @Select("SELECT * FROM education_training_info")
    EducationTrainingInfo[] findAllEducationTrainingInfo();

    @Select("SELECT * FROM education_training_info where state = #{state} and department = #{department}")
    EducationTrainingInfo[] findEducationTrainingInfoByState(@Param("state") String state,@Param("department") String department);

    @Insert("INSERT INTO education_training_info (Title, Time, Location, department, Type) VALUES (#{title},#{time},#{location},#{department},#{type})")
    void insert(String title, String type, String location, Date time,String department);

    @Select("SELECT * FROM education_training_info where title like CONCAT('%', #{title}, '%') and department = #{department}")
    EducationTrainingInfo[] findEducationTrainingInfoByTitle(@Param("title") String title,@Param("department") String department);

    @Select("SELECT * FROM education_training_info where title like CONCAT('%', #{title}, '%') and state = #{state} and department = #{department}")
    EducationTrainingInfo[] findEducationTrainingInfoByTitleAndState(@Param("state") String state,@Param("title") String title,@Param("department") String department);

    @Select("SELECT * FROM education_training_info where id = #{id}")
    EducationTrainingInfo findEducationTrainingInfoById(String id);
}
