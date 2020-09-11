<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="상품_ok.jsp" method="post">
	상품코드<input type="text" name="c_code" /><br />
	제조사명<input type="text" name="c_name" /><br />
	상품명<input type="text" name="p_name" /><br />
	입고명<input type="text" name="in_name" /><br />
	재고수량<input type="text" name="j_su" /><br />
	가격<input type="text" name="j_price" /><br />
	상세정보<input type="text" name="manu_info" /><br />
	<input type="submit" value="등록하기" />
</form>
</body>
</html>