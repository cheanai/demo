package com.demo.dao;

import com.demo.entity.PublicCourseTraining;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface PublicCourseTrainingDao {
    @Select("SELECT * FROM public_course_training WHERE department = #{department}")
    PublicCourseTraining[] select(String department);

    @Select("SELECT * FROM public_course_training WHERE state = #{state} AND department = #{department}")
    PublicCourseTraining[] selectPublicCourseTrainingByState(String state, String department);

    @Select("SELECT * FROM public_course_training WHERE id = #{id}")
    PublicCourseTraining selectPublicCourseTrainingById(int id);

    @Insert("INSERT INTO public_course_training (teacher_name, training_name, training_time, training_hours, department) " +
            "VALUES (#{teacherName},#{trainingName},#{trainingTime},#{trainingHours},#{department})")
    void insert(String teacherName, String trainingName, Date trainingTime, double trainingHours, String department);

    @Update("UPDATE public_course_training SET teacher_name = #{teacherName}, training_name = #{trainingName}, " +
            "training_time = #{trainingTime}, training_hours = #{trainingHours}, department = #{department} " +
            "WHERE id = #{id}")
    void update(int id, String teacherName, String trainingName, Date trainingTime, double trainingHours, String department);

    @Select("SELECT * FROM public_course_training WHERE teacher_name like CONCAT('%', #{teacherName}, '%') " +
            "AND state = #{state} AND department = #{department}")
    PublicCourseTraining[] selectPublicCourseTrainingByNameAndState(String teacherName, String state, String department);

    @Select("SELECT * FROM public_course_training WHERE teacher_name like CONCAT('%', #{teacherName}, '%') " +
            "AND department = #{department}")
    PublicCourseTraining[] selectByTeacherNameAndDepartment(String teacherName, String department);
}
