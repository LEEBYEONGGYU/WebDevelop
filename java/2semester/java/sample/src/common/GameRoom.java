package common;

import java.io.Serializable;
import java.util.ArrayList;

public class GameRoom implements Serializable{
	private int seq;
	private String rName;
	private ArrayList<User> users= new ArrayList<>();
	
	public GameRoom(User user, int seq, String rName) {
		users.add(user);
		this.seq=seq;
		this.rName=rName;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public void addUser(User user) {
		this.users.add(user);
	}
	public void removeUser(User user) {
		this.users.remove(user);
	}
}
