package com.demo.dao;

import com.demo.entity.AssociateProfessor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateProfessorDao {
    @Select("SELECT * FROM associate_professor WHERE department = #{department}")
    AssociateProfessor[] select(String department);

    @Select("SELECT * FROM associate_professor WHERE state = #{state} AND department = #{department}")
    AssociateProfessor[] selectAssociateProfessorByState(String state, String department);

    @Select("SELECT * FROM associate_professor WHERE id = #{id}")
    AssociateProfessor selectAssociateProfessorById(int id);

    @Insert("INSERT INTO associate_professor (name, sex, title, department, research_field, state) " +
            "VALUES (#{name},#{sex},#{title},#{department},#{researchField},'未审核')")
    void insert(String name, String sex, String title, String department, String researchField);

    @Update("UPDATE associate_professor SET name = #{name}, sex = #{sex}, title = #{title}, department = #{department}, " +
            "research_field = #{researchField}, state = '未审核' WHERE id = #{id}")
    void update(int id, String name, String sex, String title, String department, String researchField);

    @Select("SELECT * FROM associate_professor WHERE name like CONCAT('%', #{name}, '%') AND state = #{state} AND department = #{department}")
    AssociateProfessor[] selectAssociateProfessorByNameAndState(String name, String state, String department);

    @Select("SELECT * FROM associate_professor WHERE name like CONCAT('%', #{name}, '%') AND department = #{department}")
    AssociateProfessor[] selectAssociateProfessorByName(String name, String department);

    @Select("SELECT * FROM associate_professor")
    AssociateProfessor[] selectAll();

    @Update("UPDATE associate_professor SET state = #{state} WHERE id = #{id}")
    void updateAssociateProfessorById(int id, String state);
}
