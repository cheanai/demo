package com.demo.dao;

import com.demo.entity.DoctorInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorInfoDao {
    @Select("SELECT * FROM doctor_info where department = #{department}")
    DoctorInfo[] findAllDoctorInfo(String department);

    @Insert("INSERT INTO doctor_info (name, sex, nationality, department, gradschool) VALUES (#{name},#{sex},#{nationality},#{department},#{gradschool})")
    void insert(String name, String sex, String nationality, String gradschool, String department);

    @Update("UPDATE doctor_info SET name = #{name}, sex = #{sex}, nationality = #{nationality},gradschool = #{gradschool},department = #{department},state = '未审核' WHERE id = #{id}")
    void update(int id, String name, String sex, String nationality, String gradschool, String department);

    @Select("SELECT * FROM doctor_info where state = #{state} and department = #{department}")
    DoctorInfo[] selectDoctorInfoByState(String state, String department);

    @Select("SELECT * FROM doctor_info where id = #{id}")
    DoctorInfo selectDoctorInfoById(String id);

    @Select("SELECT * FROM doctor_info where name like CONCAT('%', #{name}, '%') and state = #{state} and department = #{department}")
    DoctorInfo[] selectDoctorInfoByNameAndState(String state, String name, String department);

    @Select("SELECT * FROM doctor_info where name like CONCAT('%', #{name}, '%') and department = #{department}")
    DoctorInfo[] selectDoctorInfoByName(String name, String department);
}
