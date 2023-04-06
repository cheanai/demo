package com.demo.dao;

import com.demo.entity.TargetAssessment;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetAssessmentDao {

    @Select("SELECT * FROM target_assessment")
    TargetAssessment[] select();

    @Update("UPDATE target_assessment SET ${tertiaryIndicators} = #{taskVolume}, date = #{date} WHERE college = #{college}")
    void update(String college, String tertiaryIndicators, int taskVolume, String date);

    @Select("SELECT * FROM target_assessment WHERE college like CONCAT('%', #{college}, '%')")
    TargetAssessment[] selectTargetAssessmentByCollege(String college);

    @Select("SELECT * FROM target_assessment WHERE college like CONCAT('%', #{college}, '%') AND state = #{state}")
    TargetAssessment[] selectTargetAssessmentByCollegeAndState(String college, String state);

    @Select("SELECT * FROM target_assessment WHERE state = #{state}")
    TargetAssessment[] selectTargetAssessmentByState(String state);

    @Select("SELECT * FROM target_assessment WHERE id = #{id}")
    TargetAssessment selectTargetAssessmentById(int id);

}
