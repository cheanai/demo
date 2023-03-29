package com.demo.entity;


import lombok.Data;

@Data
public class PublicCourseTraining {

  private int id;
  private String teacherName;
  private String trainingName;
  private java.sql.Date trainingTime;
  private double trainingHours;
  private String state;
  private String department;


}
