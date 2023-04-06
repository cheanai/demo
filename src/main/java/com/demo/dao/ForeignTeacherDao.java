package com.demo.dao;

import com.demo.entity.ForeignTeacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignTeacherDao {

    @Select("SELECT * FROM foreign_teacher WHERE department = #{department}")
    ForeignTeacher[] select(String department);

    @Select("SELECT * FROM foreign_teacher WHERE state = #{state} AND department = #{department}")
    ForeignTeacher[] selectByState(String state, String department);

    @Select("SELECT * FROM foreign_teacher WHERE id = #{id}")
    ForeignTeacher selectById(int id);

    @Insert("INSERT INTO foreign_teacher(name, sex, nationality, department, title, state) VALUES(#{name}, #{sex}, #{nationality}, #{department}, #{title}, '未审核')")
    void insert(@Param("name") String name, @Param("sex") String sex, @Param("nationality") String nationality, @Param("department") String department, @Param("title") String title);

    @Update("UPDATE foreign_teacher SET name = #{name}, sex = #{sex}, nationality = #{nationality}, department = #{department}, title = #{title} WHERE id = #{id}, state = '未审核'")
    void update(@Param("id") int id, @Param("name") String name, @Param("sex") String sex, @Param("nationality") String nationality, @Param("department") String department, @Param("title") String title);

    @Select("SELECT * FROM foreign_teacher WHERE name like CONCAT('%', #{name}, '%') AND department = #{department}")
    ForeignTeacher[] selectByName(@Param("name") String name, @Param("department") String department);

    @Select("SELECT * FROM foreign_teacher WHERE name like CONCAT('%', #{name}, '%') AND state = #{state}")
    ForeignTeacher[] selectForeignTeacherByNameAndState(@Param("name") String name, @Param("state") String state);

    @Select("SELECT * FROM foreign_teacher")
    ForeignTeacher[] selectAll();

    @Update("UPDATE foreign_teacher SET state = #{state} WHERE id = #{id}")
    void updateForeignTeacherById(int id, String state);
}

