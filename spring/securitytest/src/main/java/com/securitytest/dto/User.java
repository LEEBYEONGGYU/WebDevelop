package com.securitytest.dto;

public class User {
private String userId;
private String userName;
private String email;
private String password;

public User() { }

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public User(String id, String name, String email, String password) {
this.userId=id;
this.userName=name;
this.email=email;
this.password=password;
}
}