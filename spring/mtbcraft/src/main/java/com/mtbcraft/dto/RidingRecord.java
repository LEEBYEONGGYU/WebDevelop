package com.mtbcraft.dto;


import java.sql.Timestamp;
import java.util.Date;

public class RidingRecord {

	private int rr_num;

	private String rr_rider;
	private Timestamp rr_date;
	
	public String getRr_date() {
		String str = String.valueOf(rr_date); 
		int index = str.indexOf(".");
		String result = str.substring(0,index);
		return result;
	}
	public void setRr_date(Timestamp rr_date) {
		this.rr_date = rr_date;
	}
	
	private int rr_distance;
	private int rr_topspeed;
	private int rr_avgspeed;
	private int rr_high;
	private String rr_gpx;
	private int rr_open;
	private int rr_breaktime;
	private int rr_time;
	private String rr_area;
	
	public int getRr_num() {
		return rr_num;
	}
	public void setRr_num(int rr_num) {
		this.rr_num = rr_num;
	}
	public String getRr_rider() {
		return rr_rider;
	}
	public void setRr_rider(String rr_rider) {
		this.rr_rider = rr_rider;
	}
	public int getRr_distance() {
		return rr_distance;
	}
	public void setRr_distance(int rr_distance) {
		this.rr_distance = rr_distance;
	}
	public int getRr_topspeed() {
		return rr_topspeed;
	}
	public void setRr_topspeed(int rr_topspeed) {
		this.rr_topspeed = rr_topspeed;
	}
	public int getRr_avgspeed() {
		return rr_avgspeed;
	}
	public void setRr_avgspeed(int rr_avgspeed) {
		this.rr_avgspeed = rr_avgspeed;
	}
	public int getRr_high() {
		return rr_high;
	}
	public void setRr_high(int rr_high) {
		this.rr_high = rr_high;
	}
	public String getRr_gpx() {
		return rr_gpx;
	}
	public void setRr_gpx(String rr_gpx) {
		this.rr_gpx = rr_gpx;
	}
	public int getRr_open() {
		return rr_open;
	}
	public void setRr_open(int rr_open) {
		this.rr_open = rr_open;
	}
	public int getRr_breaktime() {
		return rr_breaktime;
	}
	public void setRr_breaktime(int rr_breaktime) {
		this.rr_breaktime = rr_breaktime;
	}
	public int getRr_time() {
		return rr_time;
	}
	public void setRr_time(int rr_time) {
		this.rr_time = rr_time;
	}
	public String getRr_area() {
		return rr_area;
	}
	public void setRr_area(String rr_area) {
		this.rr_area = rr_area;
	}
	
	


}
	
