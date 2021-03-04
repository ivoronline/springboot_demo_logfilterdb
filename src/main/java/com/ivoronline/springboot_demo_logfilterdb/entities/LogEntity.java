package com.ivoronline.springboot_demo_logfilterdb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  protocol;
  public String  serverName;
  public Integer serverPort;
  public String  username;
  public Integer status;

}
