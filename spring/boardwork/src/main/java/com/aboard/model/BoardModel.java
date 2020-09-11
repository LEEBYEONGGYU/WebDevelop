package com.aboard.model;

public class BoardModel {
	private int idx;
	private String postid;
	private String title;
	private String memberid;
	private String content;
	//private String attach;
	private String indate;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public String getAttach() {
//		return attach;
//	}
//	public void setAttach(String attach) {
//		this.attach = attach;
//	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}

	
}
