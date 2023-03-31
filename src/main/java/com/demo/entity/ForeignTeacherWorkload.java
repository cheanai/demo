package com.demo.entity;

import lombok.Data;

@Data
public class ForeignTeacherWorkload {

  private int id;
  private String teacherName;
  private String courseName;
  private int courseHours;
  private String courseType;
  private String state;
  private String department;


}
