package com.example.demo.dto;

import java.sql.Timestamp;

public class Board {
	int idx;
	String title;
	String name;
	String content;
	String put_file;
	Timestamp put_date;
	int hit;
	int lock_post;
	int like_jun;
	int like_per;
	String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLike_jun() {
		return like_jun;
	}
	public void setLike_jun(int like_jun) {
		this.like_jun = like_jun;
	}
	public int getLike_per() {
		return like_per;
	}
	public void setLike_per(int like_per) {
		this.like_per = like_per;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPut_file() {
		return put_file;
	}
	public void setPut_file(String put_file) {
		this.put_file = put_file;
	}
	public String getPut_date() {
		String str = String.valueOf(put_date); 
		int index = str.indexOf(".");
		String result = str.substring(0,index);
		return result;
	}
	public void setPut_date(Timestamp put_date) {
		this.put_date = put_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getLock_post() {
		return lock_post;
	}
	public void setLock_post(int lock_post) {
		this.lock_post = lock_post;
	}
	
	
	
}
