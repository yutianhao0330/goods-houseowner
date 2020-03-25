package com.thyu.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private Integer userId;
	@NotEmpty(message="用户名不能为空!")
	private String userName;
	//长度6到12位已经包含了非空的条件，所以此处注释省略
	//@NotEmpty(message="密码不能为空!")
	@Size(min=6,max=12,message="长度应为6-到12位!")
	private String userPassword;
	public User() {
		super();
	}
	public User(Integer userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
}
