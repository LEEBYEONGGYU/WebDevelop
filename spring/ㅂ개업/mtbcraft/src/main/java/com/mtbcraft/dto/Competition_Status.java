package com.mtbcraft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Competition_Status {
	@Id
	@Column
	private int cs_num;
	@Column
	private int cs_comp;
	@Column
	private int cs_club;
	@Column
	private int cs_score;
	public int getCs_num() {
		return cs_num;
	}
	public void setCs_num(int cs_num) {
		this.cs_num = cs_num;
	}
	public int getCs_comp() {
		return cs_comp;
	}
	public void setCs_comp(int cs_comp) {
		this.cs_comp = cs_comp;
	}
	public int getCs_club() {
		return cs_club;
	}
	public void setCs_club(int cs_club) {
		this.cs_club = cs_club;
	}
	public int getCs_score() {
		return cs_score;
	} 
	public void setCs_score(int cs_score) {
		this.cs_score = cs_score;
	}
	
	
}
