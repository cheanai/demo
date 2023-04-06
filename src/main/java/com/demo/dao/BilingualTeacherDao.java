package com.demo.dao;

import com.demo.entity.BilingualTeacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface BilingualTeacherDao {
    @Select("SELECT * FROM bilingual_teacher WHERE department = #{department}")
    BilingualTeacher[] select(String department);

    @Select("SELECT * FROM bilingual_teacher WHERE state = #{state} AND department = #{department}")
    BilingualTeacher[] selectByStateAndDepartment(String state, String department);

    @Select("SELECT * FROM bilingual_teacher WHERE id = #{id}")
    BilingualTeacher selectById(int id);

    @Insert("INSERT INTO bilingual_teacher (name, sex, education, teaching_subject, certificate, department) " +
            "VALUES (#{name}, #{sex}, #{education}, #{teachingSubject}, #{certificate}, #{department})")
    void insert(String name, String sex, String education, String teachingSubject, String certificate, String department);

    @Update("UPDATE bilingual_teacher SET name = #{name}, sex = #{sex}, education = #{education}, " +
            "teaching_subject = #{teachingSubject}, certificate = #{certificate}, department = #{department}, " +
            "state = '未审核'  WHERE id = #{id}")
    void update(int id, String name, String sex, String education, String teachingSubject, String certificate, String department, String state);

    @Select("SELECT * FROM bilingual_teacher WHERE name like CONCAT('%', #{name}, '%') " +
            "AND state = #{state} AND department = #{department}")
    BilingualTeacher[] selectByNameAndStateAndDepartment(String name, String state, String department);

    @Select("SELECT * FROM bilingual_teacher WHERE name like CONCAT('%', #{name}, '%') " +
            "AND department = #{department}")
    BilingualTeacher[] selectByNameAndDepartment(String name, String department);

    @Select("SELECT * FROM bilingual_teacher")
    BilingualTeacher[] selectAll();

    @Update("UPDATE bilingual_teacher SET state = #{state} WHERE id = #{id}")
    void updateBilingualTeacherById(int id, String state);
}
