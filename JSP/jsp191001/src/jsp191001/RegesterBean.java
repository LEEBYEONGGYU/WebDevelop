package jsp191001;

import java.sql.Timestamp;
public class RegesterBean {
	//프로퍼티
	private String idt; //아이디
	private String passwd; //비밀번호
	private String name; //이름
	private Timestamp reg_date; //가입일
	
	public String getIdt() {
		return idt;
	}
	public void setIdt(String idt) {
		this.idt = idt;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
}
