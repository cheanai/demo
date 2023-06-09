package com.demo.dao;

import com.demo.entity.EducationTrainingInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface IEducationTrainingInfo {

    @Select("SELECT * FROM education_training_info where department = #{department}")
    EducationTrainingInfo[] findAllEducationTrainingInfo(String department);

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

    @Update("UPDATE education_training_info SET title = #{title}, type = #{type}, location = #{location},time = #{time},department = #{department},state = '未审核' WHERE id = #{id}")
    void update(@Param("id") int id, @Param("title") String title, @Param("type") String type, @Param("location") String location, @Param("time") Date time, @Param("department") String department);

    @Select("SELECT * FROM education_training_info")
    EducationTrainingInfo[] selectAll();

    @Update("UPDATE education_training_info SET state = #{state} WHERE id = #{id}")
    void updateEducationTrainingInfoById(int id, String state);
}
