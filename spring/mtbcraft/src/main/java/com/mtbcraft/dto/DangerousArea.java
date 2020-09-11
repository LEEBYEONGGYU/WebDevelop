package com.mtbcraft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DANGEROUS_AREA")
public class DangerousArea {
	@Id
	@Column
	private int da_num;
	@Column
	private String da_rider;
	@Column
	private String da_latitude;
	@Column
	private String da_longitude;
	@Column
	private String da_addr;
	@Column
	private String da_image;
	@Column
	private String da_status;
	@Column
	private String da_content;
	
	public int getDa_num() {
		return da_num;
	}
	public void setDa_num(int da_num) {
		this.da_num = da_num;
	}
	public String getDa_rider() {
		return da_rider;
	}
	public void setDa_rider(String da_rider) {
		this.da_rider = da_rider;
	}
	public String getDa_latitude() {
		return da_latitude;
	}
	public void setDa_latitude(String da_latitude) {
		this.da_latitude = da_latitude;
	}
	public String getDa_longitude() {
		return da_longitude;
	}
	public void setDa_longitude(String da_longitude) {
		this.da_longitude = da_longitude;
	}
	public String getDa_addr() {
		return da_addr;
	}
	public void setDa_addr(String da_addr) {
		this.da_addr = da_addr;
	}
	public String getDa_image() {
		return da_image;
	}
	public void setDa_image(String da_image) {
		this.da_image = da_image;
	}
	public String getDa_status() {
		return da_status;
	}
	public void setDa_status(String da_status) {
		this.da_status = da_status;
	}
	public String getDa_content() {
		return da_content;
	}
	public void setDa_content(String da_content) {
		this.da_content = da_content;
	}
	@Override
	public String toString() {
		return da_num+"/"+da_rider+"/"+da_latitude+"/"+da_longitude+"/"+da_addr+"/"+da_content+"/"+da_image;
	}
	
}
