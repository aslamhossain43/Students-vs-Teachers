package com.renu.s_vs_t.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Role {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

  public Role(){}
  public Role(String name){
    this.name = name;
  }
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 
  
  
}