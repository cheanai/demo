package com.demo.entity;

import lombok.Data;

@Data
public class Users {

  private long userId;
  private String userName;
  private String name;
  private String email;
  private String phoneNumber;
  private String password;
  private String userType;
  private String department;

}
