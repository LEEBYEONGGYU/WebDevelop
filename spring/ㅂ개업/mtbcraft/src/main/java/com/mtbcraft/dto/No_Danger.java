package com.mtbcraft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NO_DANGER")
public class No_Danger {
	@Id
	@Column
	private int nd_num;
	@Column
	private String nd_rider;
	@Column
	private String nd_image;
	@Column
	private String nd_content;
	public int getNd_num() {
		return nd_num;
	}
	public void setNd_num(int nd_num) {
		this.nd_num = nd_num;
	}
	public String getNd_rider() {
		return nd_rider;
	}
	public void setNd_rider(String nd_rider) {
		this.nd_rider = nd_rider;
	}
	public String getNd_image() {
		return nd_image;
	}
	public void setNd_image(String nd_image) {
		this.nd_image = nd_image;
	}
	public String getNd_content() {
		return nd_content;
	}
	public void setNd_content(String nd_content) {
		this.nd_content = nd_content;
	}
	

}
