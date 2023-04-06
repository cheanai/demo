package com.demo.dao;

import com.demo.entity.Professor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDao {
    @Select("SELECT * FROM professor WHERE department = #{department}")
    Professor[] select(String department);

    @Select("SELECT * FROM professor WHERE state = #{state} AND department = #{department}")
    Professor[] selectProfessorByState(String state, String department);

    @Select("SELECT * FROM professor WHERE id = #{id}")
    Professor selectProfessorById(int id);

    @Insert("INSERT INTO professor (name, sex, title, department, research_field, state) " +
            "VALUES (#{name},#{sex},#{title},#{department},#{researchField},'未审核')")
    void insert(String name, String sex, String title, String department, String researchField);

    @Update("UPDATE professor SET name = #{name}, sex = #{sex}, title = #{title}, department = #{department}, " +
            "research_field = #{researchField}, state = '未审核' WHERE id = #{id}")
    void update(int id, String name, String sex, String title, String department, String researchField);

    @Select("SELECT * FROM professor WHERE name like CONCAT('%', #{name}, '%') AND state = #{state} AND department = #{department}")
    Professor[] selectProfessorByNameAndState(String name, String state, String department);

    @Select("SELECT * FROM professor WHERE name like CONCAT('%', #{name}, '%') AND department = #{department}")
    Professor[] selectProfessorByName(String name, String department);

    @Select("SELECT * FROM professor")
    Professor[] selectAll();

    @Update("UPDATE professor SET state = #{state} WHERE id = #{id}")
    void updateProfessorById(int id, String state);
}
