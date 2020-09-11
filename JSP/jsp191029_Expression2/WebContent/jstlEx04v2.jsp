<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] arr = {"a","b","c","d","e"};
		session.setAttribute("arr",arr);

	
	%>
	<c:forEach var="item" items="${sessionScope.arr }" varStatus="status" begin="0" end="4" step="2" >
		<p><c:if test="${status.first }">first! </c:if>
		<c:if test="${status.last }">last!</c:if>
		 ${item }
		  ${status.index }, ${status.count}
	</p> </c:forEach>
</body>
</html>


<c:forEach var="item" items="${sessionScope.items}">
	<c:if test="${not empty sessionScope.userid }">
		<input type="checkbox" name="${item.id }" id="${item.id}" >
	</c:if>
	<img src="${item.thumbnail }">
	${item.name },${item.price } <br />
</c:forEach>

앞페이지랑 출력하는 페이지랑 출력약속 잘 맞추기 세션에다가 담을 것이냐 리퀘스트에 담을 것이냐 
