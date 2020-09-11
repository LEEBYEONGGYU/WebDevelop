package common;

import java.io.Serializable;


public class User implements Serializable{
	private String id, passwd, name, nickname, email;
	private int win, lose, high;
	private GameRoom gr;
	

	public User() {
	}

	//회원가입
	public User(String id, String passwd, String name, String nickname, String email) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public GameRoom getGr() {
		return gr;
	}
	public void setGr(GameRoom gr) {
		this.gr = gr;
	}
	
}
