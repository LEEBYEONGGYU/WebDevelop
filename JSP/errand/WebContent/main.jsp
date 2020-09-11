<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
	<div class="scen">
		<div id="m_txt">
			<p><%=session.getAttribute("uname")%>!</p>
			<p>
				오늘은 엄마 심부름 좀 해 주겠니?<br>
				몇 가지 장을 봐야 하니<br>
				잘 기억해<br>
			</p>
		</div>
		<div class="mini_img"><img src="imgs/<%=session.getAttribute("uimg") %>.png" /></div>
		<a href="scene1.jsp"><button type="button" class="set_bt_ma">다음</button></a>
	</div>
</body>
</html>