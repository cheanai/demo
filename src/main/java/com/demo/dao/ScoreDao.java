package com.demo.dao;

import com.demo.entity.Score;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ScoreDao {

    @Select("SELECT * FROM score")
    Score[] select();

    @Select("SELECT total_score FROM score")
    double[] selectTotalScore();

    @Select("SELECT ${secondaryIndicators},${target},total_score FROM score where col = #{department}")
    Map<String, Double> selectInfo(String department, String secondaryIndicators, String target);

    @Update("UPDATE score SET ${target}=#{score}, ${curryScore}=#{i1}, total_score=#{i2} WHERE  col=#{department}")
    void update(String department, String target, double score, String curryScore, double i1, double i2);
}
