package com.datang.hrb.vo;

import java.sql.Date;

public class User {//只是数据和值对象所以和三层同级
 private String username;
 private String  password;
 private int age;
 private Date ts;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Date getTs() {
	return ts;
}
public void setTs(Date ts) {
	this.ts = ts;
}

}
 
 

