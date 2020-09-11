package com.mtbcraft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
	@Id
	@Column
	private int c_num;
	@Column
	private int c_distance;
	@Column
	private int c_level;
	@Column
	private String c_area;
	@Column
	private String c_gpx;
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public int getC_distance() {
		return c_distance;
	}
	public void setC_distance(int c_distance) {
		this.c_distance = c_distance;
	}
	public int getC_level() {
		return c_level;
	}
	public void setC_level(int c_level) {
		this.c_level = c_level;
	}
	public String getC_area() {
		return c_area;
	}
	public void setC_area(String c_area) {
		this.c_area = c_area;
	}
	public String getC_gpx() {
		return c_gpx;
	}
	public void setC_gpx(String c_gpx) {
		this.c_gpx = c_gpx;
	}
	
	
	
	
}
