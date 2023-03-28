package com.demo.dao;

import com.demo.entity.TeacherTraining;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface TeacherTrainingDao {
    @Select("SELECT * FROM teacher_training WHERE department = #{department}")
    TeacherTraining[] select(String department);

    @Select("SELECT * FROM teacher_training WHERE state = #{state} AND department = #{department}")
    TeacherTraining[] selectTeacherTrainingByState(String state, String department);

    @Select("SELECT * FROM teacher_training WHERE id = #{id}")
    TeacherTraining selectTeacherTrainingById(String id);

    @Insert("INSERT INTO teacher_training (teacher_name, training_type, training_topic, training_start_time, department, state) " +
            "VALUES (#{teacherName},#{trainingType},#{trainingTopic},#{trainingStartTime},#{department},'未审核')")
    void insert(String teacherName, String trainingType, String trainingTopic, Date trainingStartTime, String department);

    @Update("UPDATE teacher_training SET teacher_name = #{teacherName}, training_type = #{trainingType}, " +
            "training_topic = #{trainingTopic}, training_start_time = #{trainingStartTime}, department = #{department}, " +
            "state = '未审核' WHERE id = #{id}")
    void update(int id, String teacherName, String trainingType, String trainingTopic, Date trainingStartTime, String department);

    @Select("SELECT * FROM teacher_training WHERE teacher_name like CONCAT('%', #{teacherName}, '%') AND department = #{department}")
    TeacherTraining[] selectTeacherTrainingByName(String teacherName, String department);

    @Select("SELECT * FROM teacher_training WHERE state = #{state} AND teacher_name like CONCAT('%', #{teacherName}, '%') " +
            "AND department = #{department}")
    TeacherTraining[] selectTeacherTrainingByNameAndState(String state, String teacherName, String department);
}
