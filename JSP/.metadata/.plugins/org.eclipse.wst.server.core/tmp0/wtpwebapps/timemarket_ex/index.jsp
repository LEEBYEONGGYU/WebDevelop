<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="db.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
</head>
<body>
<h1>타임마켓 테스트 페이지</h1>
<h4>드릅게 어렵네</h4>

<!----------상품----------->
<h3>상품</h3>
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
	<th width="180">마감일자</th>
	<th>상세정보</th>
	<th>수량</th>
	<th>장바구니</th>
	<th>남은시간</th>
	</tr>
</thead>
<tbody>
<% 
session.setAttribute("userid","uid");
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
	String 마감일자;
	String 상세정보;
		while(rs.next()){
			상품코드= rs.getString("상품코드");
			제조사명= rs.getString("제조사명");
			상품명= rs.getString("상품명");
			입고명= rs.getString("입고명");
			재고수량= rs.getInt("재고수량");
			가격=rs.getInt("가격");
			입고일자= rs.getString("입고일자");
			마감일자= rs.getString("마감일자");
			상세정보= rs.getString("상세정보");
		
%>

<form action="장바구니_ok.jsp" method="post">
	<tr>
		<td><%=상품코드 %></td>
		
		<td><%=제조사명 %><input type="hidden" name="bas_jname" value="<%=제조사명 %>" /> </td>
		<td><%=상품명 %><input type="hidden" name="bas_name" value="<%=상품명 %>" /></td>
		<td><%=입고명 %><input type="hidden" name="bas_inname" value="<%=입고명 %>" /></td>
		<td><%=재고수량 %></td>
		<td><%=가격 %><input type="hidden" name="bas_price" value="<%=가격 %>" /></td>
		<td><%=입고일자 %></td>
		<td><%=마감일자 %></td>
		
		<td><%=상세정보 %><input type="hidden" name="bas_jname" value="<%=상세정보 %>" /></td>
		<td><input type="text" name="bas_count" placeholder="수량" size="5" /></td>
		<td><input type="submit" value="담기"/></td>
	</tr>
	</form>
</tbody>

<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}


%>
</table>
<a href="상품form.jsp"><button>작성</button></a>

<!----------옵션상품----------->
<h3>옵션상품</h3>
<table class="list-table">
<thead>
<tr>
	<th>상품코드</th>
	<th>옵션상품명</th>
	<th>옵션종류</th>
	<th>옵션수량</th>
	<th>가격</th>
	</tr>
</thead>

<tbody>
<% 
try {
	
	sql = "select * from 옵션상품 order by 상품코드 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 상품코드= rs.getString("상품코드");
			String 옵션상품명= rs.getString("옵션상품명");
			String 옵션종류= rs.getString("옵션종류");
			String 옵션수량= rs.getString("옵션수량");
			String 가격= rs.getString("가격");
		
%>
	<tr>
		<td><%=상품코드 %></td>
		<td><%=옵션상품명 %></td>
		<td><%=옵션종류 %></td>
		<td><%=옵션수량 %></td>
		<td><%=가격 %></td>
	</tr>
	<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}


%>
</tbody>
</table>
<a href="옵션상품form.jsp"><button>작성</button></a>

<!----------장바구니----------->
<h3>장바구니</h3>
<table class="list-table">
<thead>
<tr>
	<th>장바구니번호</th>
	<th>사용자아이디</th>
	<th>상품명</th>
	<th>가격</th>
	<th>수량</th>
	<th>구매</th>
	</tr>
	
</thead>
<tbody>
<% 
try {
	
	sql = "select * from 장바구니 order by 장바구니번호 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 장바구니번호= rs.getString("장바구니번호");
			String 사용자아이디= rs.getString("사용자아이디");
			String 상품명= rs.getString("상품명");
			String 가격= rs.getString("가격");
			String 수량= rs.getString("수량");
%>
<form action="구매form.jsp" method="post">
	<tr>
	
		<td><%=장바구니번호 %></td>
		<td><%=사용자아이디 %></td>
		<td><%=상품명 %><input type="hidden" name="pro_name" value="<%=상품명 %>" /></td>
		<td><%=가격 %><input type="hidden" name="pro_price" value="<%=가격 %>" /></td>
		<td><%=수량 %><input type="hidden" name="pro_price" value="<%=수량 %>" /></td>
		<td><input type="submit" value="구매" /></td>
	
</tr>
</form>
	<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}


%>
</tbody>
</table>

<!----------구매----------->
<h3>구매</h3>
<table class="list-table">
<thead>

<tr>
	<th>구매번호</th>
	<th>구매아이디</th>
	<th>구매상품명</th>
	<th>구매방법</th>
	<th>구매금액</th>
	<th>배송지주소</th>
	<th>배송지전화번호</th>
	<th>배송방법</th>
	</tr>
	
</thead>
<tbody>
	<% 
try {
	
	sql = "select * from 구매 order by 구매번호 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 구매번호= rs.getString("구매번호");
			String 구매아이디= rs.getString("구매아이디");
			String 구매상품명= rs.getString("구매상품명");
			String 구매방법= rs.getString("구매방법");
			String 구매금액= rs.getString("구매금액");
			String 배송지주소= rs.getString("배송지주소");
			String 배송지전화번호= rs.getString("배송지전화번호");
			String 배송방법= rs.getString("배송방법");
%>
	<tr>
		<td><%=구매번호 %></td>
		<td><%=구매아이디 %></td>
		<td><%=구매상품명 %></td>
		<td><%=구매방법 %></td>
		<td><%=구매금액 %></td>
		<td><%=배송지주소 %></td>
		<td><%=배송지전화번호 %></td>
		<td><%=배송방법 %></td>
	</tr>
	<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}


%>
</tbody>
</table>

<!----------판매----------->
<h3>판매</h3>
<table class="list-table">
<thead>
<tr>
	<th>판매자아이디</th>
	<th>구매자아이디</th>
	<th>상품코드</th>
	<th>날짜</th>
	<th>상품명</th>
	<th>가격</th>

	</tr>
</thead>
<tbody>
	<% 
try {
	
	sql = "select * from 판매 order by 날짜 desc ";
	psmt = con.prepareStatement(sql);
	//psmt.setString(1,"userid");
	rs = psmt.executeQuery();
		while(rs.next()){
			String 판매자아이디= rs.getString("판매자아이디");
			String 구매자아이디= rs.getString("구매자아이디");
			String 상품코드= rs.getString("상품코드");
			String 날짜= rs.getString("날짜");
			String 상품명= rs.getString("상품명");
			String 가격= rs.getString("가격");
%>
	<tr>
		<td><%=판매자아이디 %></td>
		<td><%=구매자아이디 %></td>
		<td><%=상품코드 %></td>
		<td><%=날짜 %></td>
		<td><%=상품명 %></td>
		<td><%=가격 %></td>
	</tr>
	<% 
		}
}catch(Exception e1) {
	e1.printStackTrace();
}
%>
</tbody>
</table>
</body>
</html>