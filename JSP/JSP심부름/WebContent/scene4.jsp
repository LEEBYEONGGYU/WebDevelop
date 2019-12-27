<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
<%
request.setCharacterEncoding("utf-8");
String selme3 = request.getParameter("sel3");
String chkss[] = request.getParameterValues("sel3");

int a, i=0;
for(a=0; a<4; a++){
	if(chkss==null){
		out.println("<script>alert('최소 하나는 선택해주세요'); history.back();</script>");
		break;
	}else{
		session.setAttribute("sel3",chkss);
	}
}
%>
<div class="scen">
	<div id="m_txt">
		<p>자, 지금까지 뭘 골랐는지 한 번 체크 해 봐</p>
	</div>
	<form action="sceneTest.jsp" method="post">
		<div id="sc4_ra">
			<ul>
				<li class="fl"><input type="radio" name="sel5" value="두부" />&nbsp;두부</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sel5" value="순두부" />&nbsp;순두부</li>
				<li class="fl"><input type="radio" name="sel6" value="초코우유" />&nbsp;초코우유</li>
				<li><input type="radio" name="sel6" value="바나나우유" />&nbsp;바나나 우유</li>
			</ul>
			<br />
			<ul>
				<li class="fl"><input type="checkbox" name="chkk" value="돼지고기" />&nbsp;돼지고기</li>
				<li>&nbsp;&nbsp;<input type="checkbox" name="chkk" value="닭고기" />&nbsp;닭고기</li>
				<li class="fl"><input type="checkbox" name="chkk" value="소고기" />&nbsp;소고기</li>
				<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="chkk" value="오리고기" />&nbsp;오리고기</li>
			</ul>
		</div>
		<div class="mini_img"><img src="imgs/<%=session.getAttribute("uimg") %>.png" /></div>
		<button type="submit" class="set_bt_ma">다음</button>	
	</form>
</div>
</body>
</html>