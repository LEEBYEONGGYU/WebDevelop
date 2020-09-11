package sample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.ThrowNode;

public interface commandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable; 
}
