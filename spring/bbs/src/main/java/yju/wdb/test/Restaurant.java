package yju.wdb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
	@Autowired
	private Chef chef;
	
	public String toString() {
		return "This is a fantastic restaurant";
	}

	public Chef getChef() {
		return chef;
	}
}
