<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
<div class="scen">
	<div id="m_txt">
		<p>다음 둘 중에 마음에 드는 것으로 하나만<br>
		선택해서 사야 해!<br>
		</p>
	</div>
	<div id="sc1_radio">
		<form action="scene2.jsp" method="post">
			<ul id="sc1_radio">
				<li><input type="radio" name="sel" value="두부" required/><span class="ra_t">두부</span></li>
				<li><input type="radio" name="sel" value="순두부" required /><span class="ra_t">순두부</span></li>
			</ul>
			<div class="mini_img"><img src="imgs/<%=session.getAttribute("uimg") %>.png" /></div>
			<button type="submit" class="set_bt_ma">다음</button>
		</form>
	</div>
</div>
</body>
</html>