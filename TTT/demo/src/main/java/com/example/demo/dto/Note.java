package com.example.demo.dto;

import java.sql.Timestamp;

public class Note {
	int idx;
	String recv_id;
	String send_id;
	String title;
	String content;
	String file;
	Timestamp send_date;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getRecv_id() {
		return recv_id;
	}
	public void setRecv_id(String recv_id) {
		this.recv_id = recv_id;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Timestamp getSend_date() {
		return send_date;
	}
	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}
	@Override
	public String toString() {
		return "Note [idx=" + idx + ", recv_id=" + recv_id + ", send_id=" + send_id + ", title=" + title + ", content="
				+ content + ", file=" + file + ", send_date=" + send_date + "]";
	}
	
	
}
