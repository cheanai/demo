package com.demo.entity;

import lombok.Data;

@Data
public class ApplyPhd {

  private int id;
  private String name;
  private String sex;
  private String major;
  private String university;
  private String department;
  private java.sql.Date date;
  private String state;

}
