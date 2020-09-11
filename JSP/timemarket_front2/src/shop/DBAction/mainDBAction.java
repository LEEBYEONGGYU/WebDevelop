package shop.DBAction;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.DBbean.DBBean;

import com.oreilly.servlet.MultipartRequest;
public class mainDBAction {
	private static mainDBAction instance = new mainDBAction();
	private mainDBAction() {}
	public static mainDBAction getInstance() {
		return instance;
	}
	
	
	public void productlist(){
}
}
