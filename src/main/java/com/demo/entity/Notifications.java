package com.demo.entity;

import lombok.Data;

@Data
public class Notifications {

  private int id;
  private String title;
  private java.sql.Date publishDate;
  private String publisher;
  private String content;

}
