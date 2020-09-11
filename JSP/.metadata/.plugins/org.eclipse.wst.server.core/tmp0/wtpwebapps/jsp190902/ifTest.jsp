<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--전송받은 데이터의 한글 깨짐 방지 --%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>if-else문 예제 - 좋아하는 색 선택</h2>
<%--입력한 값을 얻어내서 처리 --%>
<%//ifTestForm.jsp의 10,14라인의 파라미터 변수 name과 color의 값을 얻어냄 
	String name=request.getParameter("name");
	String color = request.getParameter("color");
	String selectColor="";//지역 변수 초기화
	//if문을 사용해서 color파라미터 변수로부터 얻어낸 값을 가지고
	//selectColor변수에 넣을 값 설정
	if(color.equals("blue")){//두개의 문자열이 같은지 비교
		selectColor="파랑색";
	}else if(color.equals("green")){
		selectColor="초록색";
	}else if(color.equals("red")){
		selectColor="빨강색";
	}else{
		selectColor="기타색";
	}
%>
<%-- 결과 출력 --%>
<%=name %>님이 선택한 색은<%=selectColor %>입니다<p>
선택한 색 : <br>
<img src="<%=color+".jpg"%>" border="0">

	
</body>
</html>