package com.mtbcraft.dto;

import java.sql.Timestamp;


public class Board {

	private int b_num;

	private String b_rider;

	private int b_area;
	
	private String b_title;
	
	private String b_content;
	
	private Timestamp b_day;
	
	private String b_file;
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_rider() {
		return b_rider;
	}
	public void setB_rider(String b_rider) {
		this.b_rider = b_rider;
	}
	public int getB_area() {
		return b_area;
	}
	public void setB_area(int b_area) {
		this.b_area = b_area;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Timestamp getB_day() {
		return b_day;
	}
	public void setB_day(Timestamp b_day) {
		this.b_day = b_day;
	}
	public String getB_file() {
		return b_file;
	}
	public void setB_file(String b_file) {
		this.b_file = b_file;
	}
}
