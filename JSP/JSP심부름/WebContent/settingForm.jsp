<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="header.jsp"%>
	<div class="scen">
	<form action="setting.jsp" method="post">
		<div id="setf_name">
			이름 <input type="text" name="uname" placeholder="이름" required />
		</div>
		<div id="setform_ch">
			캐릭터<br />
			<input type="radio" name="chra" value="boy"/><img src="imgs/boy.png" alt="boy" name="boy" />
			<input type="radio" name="chra" value="girl"/><img src="imgs/girl.png" alt="girl" name="girl" />
		</div>
		<input type="submit" value="확인" class="set_bt" />
		</form>
	</div>
</body>
</html>