<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
String sel5 = request.getParameter("sel5");
String sel6 = request.getParameter("sel6");
String[] chkk = request.getParameterValues("chkk");
String[] chk = (String[])session.getAttribute("sel3");
String tr = "";
int a, i=0, cnt=0;

/* scene3에서 체크박스가 하나도 선택이 안되어있으면 경고창과 함께 다시 뒤로 돌아간다
그리고 break문으로 4개 모두 선택을 안해도 break로 걸어서 한번만 경고창을 띄운다 */
for(a=0; a<4; a++){
	if(chkk==null){
		out.println("<script>alert('최소 하나는 선택해주세요'); history.back();</script>");
		break;
	}
}
// try catch로 예외처리를 if문으로 세션값과 request로 받아온값들이 일치한지 검사하고 모두 같으면 cnt변수에 1저장
try {
	if(session.getAttribute("sel").equals(sel5)){
		if(session.getAttribute("sel2").equals(sel6)){
			if(chk.length==chkk.length){
				for(i=0; i<chk.length;i++){
					if(chk[i].equals(chkk[i])){
						cnt=1;
					}
				}
			}
		}
	}
} catch(Exception e){
	tr = "false";
	session.setAttribute("tf",tr);
	response.sendRedirect("ending.jsp");
}

//cnt가 1이면 true 아니면 false 그리고 ending.jsp로 이동
if(cnt==1){
	tr = "true";
	session.setAttribute("tf",tr);
	response.sendRedirect("ending.jsp");
}else{
	tr = "false";
	session.setAttribute("tf",tr);
	response.sendRedirect("ending.jsp");
}
%>