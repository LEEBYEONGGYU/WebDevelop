<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<% request.setCharacterEncoding("utf-8"); %>
<div class="scen">
		<div id="m_txt">
			<p><%=session.getAttribute("uname")%>!</p>
<% 
if(session.getAttribute("tf").equals("true")){
%>
	<p>정말 잘했어.<br>
	그럼 부탁할게!<br>
	<% }else{ %>
	<p>아직은 좀 더 연습이 필요한 것 같구나.<br>
	엄마랑 같이 가자!<br></p>
<% 
	
	} %>
</div>
<div class="mini_img"><img src="imgs/<%=session.getAttribute("uimg") %>.png" /></div>
</div>
</body>
</html>