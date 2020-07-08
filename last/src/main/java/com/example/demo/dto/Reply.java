package com.example.demo.dto;

import java.sql.Timestamp;

public class Reply {
	int idx;
	int bo_num;
	String name;
	String password;
	String title;
	String contents;
	Timestamp put_date;
	int depth;
	int depth2;
	int ro_idx;
	
	
	public int getRo_idx() {
		return ro_idx;
	}
	public void setRo_idx(int ro_idx) {
		this.ro_idx = ro_idx;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getDepth2() {
		return depth2;
	}
	public void setDepth2(int depth2) {
		this.depth2 = depth2;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getBo_num() {
		return bo_num;
	}
	public void setBo_num(int bo_num) {
		this.bo_num = bo_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
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
}
