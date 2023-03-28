package com.demo.dao;

import com.demo.entity.ApplyPhd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ApplyPhdDao {
    @Select("SELECT * FROM apply_phd where department = #{department}")
    ApplyPhd[] select(String department);

    @Select("SELECT * FROM apply_phd where state = #{state} and department = #{department}")
    ApplyPhd[] selectApplyPhdBystate(String state, String department);

    @Select("SELECT * FROM apply_phd where id = #{id}")
    ApplyPhd selectApplyPhdById(String id);

    @Select("SELECT * FROM apply_phd where name like CONCAT('%', #{name}, '%') and department = #{department}")
    ApplyPhd[] selectApplyPhdByName(String name, String department);

    @Select("SELECT * FROM apply_phd where state = #{state} and name like CONCAT('%', #{name}, '%') and department = #{department}")
    ApplyPhd[] selectApplyPhdByNameAndstate(String state, String name, String department);

    @Insert("INSERT INTO apply_phd (name, sex, major, university, department, date, state) " +
            "VALUES (#{name},#{sex},#{major},#{university},#{department},#{date},'未审核')")
    void insert(String name, String sex, String major, String university, String department, Date date, String state);

    @Update("UPDATE apply_phd SET name = #{name}, sex = #{sex}, major = #{major}, university = #{university}, " +
            "department = #{department}, date = #{date}, state = '未审核' WHERE id = #{id}")
    void update(int id, String name, String sex, String major, String university, String department, Date date);

}
