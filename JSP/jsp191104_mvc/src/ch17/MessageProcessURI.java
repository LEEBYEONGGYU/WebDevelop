package ch17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcessURI implements CommandProcess{

	@Override
	public String requestPro(
		HttpServletRequest request,	HttpServletResponse response) 
		throws Throwable{
		request.setAttribute("message", "��û URI�� ��ɾ ����");
        return "/ch17/process.jsp";
	}
}