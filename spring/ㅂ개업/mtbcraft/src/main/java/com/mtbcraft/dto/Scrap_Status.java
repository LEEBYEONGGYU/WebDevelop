package com.mtbcraft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scrap_Status {
	@Id			//명시적으로 ID를 선언하였습니다. 실제 데이어의 PK는 ss_rider와 ss_course입니다.
	@Column
	private int ss_num;
	@Column
	private String ss_rider;
	@Column
	private int ss_course;
	
	public int getSs_num() {
		return ss_num;
	}
	public void setSs_num(int ss_num) {
		this.ss_num = ss_num;
	}
	public String getSs_rider() {
		return ss_rider;
	}
	public void setSs_rider(String ss_rider) {
		this.ss_rider = ss_rider;
	}
	public int getSs_course() {
		return ss_course;
	}
	public void setSs_course(int ss_course) {
		this.ss_course = ss_course;
	}
}
