package com.demo.dao;

import com.demo.entity.TaskTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTableDao {

    @Insert("INSERT INTO task_table(college, secondaryIndicators, tertiaryIndicators, taskVolume, date) " +
            "VALUES (#{college}, #{secondaryIndicators}, #{tertiaryIndicators}, #{taskVolume}, #{date})")
    void insert(@Param("college") String college,
                @Param("secondaryIndicators") String secondaryIndicators,
                @Param("tertiaryIndicators") String tertiaryIndicators,
                @Param("taskVolume") int taskVolume,
                @Param("date") String date);

    @Select("SELECT * FROM task_table")
    TaskTable[] selectAll();
}
