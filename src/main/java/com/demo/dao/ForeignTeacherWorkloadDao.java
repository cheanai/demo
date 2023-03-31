package com.demo.dao;

import com.demo.entity.ForeignTeacherWorkload;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignTeacherWorkloadDao {
    @Select("SELECT * FROM foreign_teacher_workload WHERE teacher_name like CONCAT('%', #{teacherName}, '%') AND department = #{department}")
    ForeignTeacherWorkload[] selectByTeacherNameAndDepartment(@Param("teacherName") String teacherName, @Param("department") String department);

    @Select("SELECT * FROM foreign_teacher_workload WHERE department = #{department}")
    ForeignTeacherWorkload[] select(@Param("department") String department);

    @Insert("INSERT INTO foreign_teacher_workload (teacher_name, course_name, course_hours, course_type, department) VALUES (#{teacherName}, #{courseName}, #{courseHours}, #{courseType}, #{department})")
    void insert(@Param("teacherName") String teacherName, @Param("courseName") String courseName, @Param("courseHours") int courseHours, @Param("courseType") String courseType, @Param("department") String department);

    @Update("UPDATE foreign_teacher_workload SET teacher_name = #{teacherName}, course_name = #{courseName}, course_hours = #{courseHours}, course_type = #{courseType}, department = #{department}, state = '未审核'  WHERE id = #{id}")
    void update(@Param("id") int id, @Param("teacherName") String teacherName, @Param("courseName") String courseName, @Param("courseHours") int courseHours, @Param("courseType") String courseType, @Param("department") String department);

    @Select("SELECT * FROM foreign_teacher_workload WHERE id = #{id}")
    ForeignTeacherWorkload selectById(@Param("id") int id);

    @Select("SELECT * FROM foreign_teacher_workload WHERE teacher_name like CONCAT('%', #{teacherName}, '%') AND state = #{state} AND department = #{department}")
    ForeignTeacherWorkload[] selectByTeacherNameAndState(@Param("teacherName") String teacherName, @Param("state") String state, @Param("department") String department);

    @Select("SELECT * FROM foreign_teacher_workload WHERE state = #{state} AND department = #{department}")
    ForeignTeacherWorkload[] selectByStateAndDepartment(@Param("state") String state, @Param("department") String department);
}
