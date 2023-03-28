package com.demo.entity;

import lombok.Data;

@Data
public class TeacherTraining {

  private int id;
  private String teacherName;
  private String trainingType;
  private String trainingTopic;
  private java.sql.Date trainingStartTime;
  private String state;
  private String department;

}
