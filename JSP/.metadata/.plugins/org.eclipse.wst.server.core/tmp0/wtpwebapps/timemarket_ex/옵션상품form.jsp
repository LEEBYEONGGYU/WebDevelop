<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="db.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#board_area {
	width: 900px;
	position: relative;	
}
.list-table {
	margin-top: 40px;
	position: relative;
	
}
.list-table thead th{
	height:40px;
	border-top:2px solid #09C;
	border-bottom:1px solid #CCC;
	font-weight: bold;
	font-size: 17px;
}
.list-table tbody td{
	text-align:center;
	padding:10px 0;
	border-bottom:1px solid	 #CCC; height:20px;
	font-size: 14px 
}
</style>
<body>



<table class="list-table">
<thead>
<tr>
	<th>상품코드</th>
	<th>제조사명</th>
	<th>상품명</th>
	<th>입고명</th>
	<th>재고수량</th>
	<th>가격</th>
	<th width="180">입고일자</th>

	</tr>
</thead>
<tbody>
<% 
try {
	
	sql = "select * from 일반상품 order by 상품코드 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
	String 상품코드;
	String 제조사명;
	String 상품명;
	String 상품;
	String 입고명;
	int 재고수량;
	int 가격;
	String 입고일자;

		while(rs.next()){
			상품코드= rs.getString("상품코드");
			제조사명= rs.getString("제조사명");
			상품명= rs.getString("상품명");
			입고명= rs.getString("입고명");
			재고수량= rs.getInt("재고수량");
			가격=rs.getInt("가격");
			입고일자= rs.getString("입고일자");

		
%>

	<tr>
		<td><%=상품코드 %></td>
		<td><%=제조사명 %><input type="hidden" name="bas_jname" value="<%=제조사명 %>" /> </td>
		<td><%=상품명 %><input type="hidden" name="bas_name" value="<%=상품명 %>" /></td>
		<td><%=입고명 %><input type="hidden" name="bas_inname" value="<%=입고명 %>" /></td>
		<td><%=재고수량 %></td>
		<td><%=가격 %></td>
		<td><%=입고일자 %></td>
</tbody>

<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}


%>
</table>

<br /><br />
<form action="옵션상품_ok.jsp" method="post">
	상품코드<input type="text" name="co_code" /><br />
	옵션상품명<input type="text" name="co_name" /><br />
	옵션종류<input type="text" name="op_jor" /></br />
	옵션수량<input type="text" name="op_count" /><br />
	가격<input type="text" name="op_price" /><br />
	전송<input type="submit"/>
</form>
</body>
</html>