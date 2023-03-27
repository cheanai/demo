package com.demo.dao;

import com.demo.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserDao {
    @Select("select * from users where user_name = #{name} and password =#{pwd}")
    Users findUserByUserName(@Param("name") String name,@Param("pwd") String pwd);
}