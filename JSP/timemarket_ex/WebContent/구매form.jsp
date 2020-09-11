<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); 

String 구매상품명 = request.getParameter("pro_name");
String 구매금액 = request.getParameter("pro_price");
%>
<form action="구매_ok.jsp" method="post">
	
	구매아이디<input type="text" name="gu_id" value="usd" /><br />
	구매상품명<input type="text" name="gu_pname" value="<%=구매상품명  %>" /><br />
	구매방법<input type="text" name="gu_if" /><br />
	구매금액<input type="text" name="gu_price" value="<%=구매금액 %>" /><br />
	배송지주소<input type="text" name="gu_adress" /><br />
	배송지전화번호<input type="text" name="gu_phone" /><br />
	배송금액<input type="text" name="gu_bprice" /><br />
	배송방법<input type="text" name="ba_of" /><br />
	<input type="submit" value="전송 " />
</form>
</body>
</html>