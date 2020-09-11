package com.aboard.board.domain;

public class Board {
	private int idx;
	private String postid;
	private String title;
	private String memberid;
	private String contents;
	private String boDate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBoDate() {
		return boDate;
	}
	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}
	
	
}
