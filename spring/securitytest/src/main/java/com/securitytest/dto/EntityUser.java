package com.securitytest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rider")
public class EntityUser {
@Id
@Column(name = "r_id")
private String userId;

@Column(name = "r_pw")
private String password;

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}


public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

}