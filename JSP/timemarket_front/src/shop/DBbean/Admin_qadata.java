package shop.DBbean;

public class Admin_qadata {
	private String a_idx; //질문 글번호
	private String a_title; //답변 제목
	private String a_text; //답변 내용
	
	public String getA_idx() {
		return a_idx;
	}
	public String getA_title() {
		return a_title;
	}
	public String getA_text() {
		return a_text;
	}
	public String setA_idx(String a_idx) {
		return this.a_idx = a_idx;
	}
	public String setA_title(String a_title) {
		return this.a_title = a_title;
	}
	public String setA_text(String a_text) {
		return this.a_text = a_text;
	}

}
