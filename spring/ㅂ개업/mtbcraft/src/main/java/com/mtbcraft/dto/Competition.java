package com.mtbcraft.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Competition {
@Id
@Column
private int comp_num;
@Column
private int comp_course;
@Column
private int comp_badge;
@Column
private String comp_name;
@Column
private String comp_period;
@Column
private String comp_content;
@Column
private String comp_image;
public int getComp_num() {
	return comp_num;
}
public void setComp_num(int comp_num) {
	this.comp_num = comp_num;
}
public int getComp_course() {
	return comp_course;
}
public void setComp_course(int comp_course) {
	this.comp_course = comp_course;
}
public int getComp_badge() {
	return comp_badge;
}
public void setComp_badge(int comp_badge) {
	this.comp_badge = comp_badge;
}
public String getComp_name() {
	return comp_name;
}
public void setComp_name(String comp_name) {
	this.comp_name = comp_name;
}
public String getComp_period() {
	return comp_period;
}
public void setComp_period(String comp_period) {
	this.comp_period = comp_period;
}
public String getComp_content() {
	return comp_content;
}
public void setComp_content(String comp_content) {
	this.comp_content = comp_content;
}
public String getComp_image() {
	return comp_image;
}
public void setComp_image(String comp_image) {
	this.comp_image = comp_image;
}
}
