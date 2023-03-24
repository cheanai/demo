package com.demo.dao;

import com.demo.entity.EducationTrainingInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IEducationTrainingInfo {

    @Select("SELECT * FROM education_training_info")
    EducationTrainingInfo[] findAllEducationTrainingInfo();

    @Insert("INSERT INTO education_training_info (Title, Time, Location, department, Type) VALUES (#{title},#{time},#{location},#{department},#{type})")
    void insert(String title, String type, String location, Date time,String department);
}
