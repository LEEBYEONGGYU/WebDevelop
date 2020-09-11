package com.mtbcraft.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rider")
public class Login  {
	@Id
	@Column(name="r_id")
   private String userId;
	@Column(name="r_pw")
   private String userPw;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


   
   
}