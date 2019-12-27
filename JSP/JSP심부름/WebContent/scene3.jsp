<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
<%
request.setCharacterEncoding("utf-8");
String selme2 = request.getParameter("sel2");
session.setAttribute("sel2",selme2);
%>
<div class="scen">
	<div id="m_txt">
		<p>다음 둘 중에 마음에 드는 것을 모두 사 오렴</p>
	</div>
	<div id="sc1_radio">
		<form action="scene4.jsp" method="post">
			<input type="checkbox" name="sel3" value="돼지고기" />&nbsp;돼지고기
			&nbsp;&nbsp;<input type="checkbox" name="sel3" value="닭고기" />&nbsp;닭고기
			<br />
			<input type="checkbox" name="sel3" value="소고기" />&nbsp;소고기
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="sel3" value="오리고기" />&nbsp;오리고기
			<div class="mini_img"><img src="imgs/<%=session.getAttribute("uimg") %>.png" /></div>
			<button type="submit" class="set_bt_ma">다음</button>
		</form>
	</div>
</div>
</body>
</html>