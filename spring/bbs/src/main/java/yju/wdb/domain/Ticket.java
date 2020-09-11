package yju.wdb.domain;

public class Ticket {
	private int tno;
	private String owner;
	private String grade;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return "tno["+tno+"], owner["+owner+"],grade["+grade+"]";
	}
	
}
