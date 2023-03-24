package com.demo.entity;

import lombok.Data;

@Data
public class EducationTrainingInfo {

  private long id;
  private String title;
  private java.sql.Date time;
  private String location;
  private String department;
  private String type;
  private String state;


}
