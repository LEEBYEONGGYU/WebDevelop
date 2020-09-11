<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp"%>
<%
	request.setCharacterEncoding("utf-8");
	String proname = request.getParameter("product"); //상품명
	String price = request.getParameter("price"); //가격
		
	ArrayList<String> list; //가격에 대한 ArrayList
	ArrayList<String> list2; //가격에 대한 ArrayList
	if(session.getAttribute("prolist")==null){
		 	//아무런 데이터가 없으면 array list할당
		 	list = new ArrayList<String>();
		 }else{
		 	//저장된 데이터가 있으면
		 	list = (ArrayList<String>) session.getAttribute("prolist");
		 }

		if(session.getAttribute("price")==null){
		 	//아무런 데이터가 없으면 array list2할당
		 	list2 = new ArrayList<String>();
		 }else{
		 	//저장된 데이터가 있으면
		 	list2 = (ArrayList<String>) session.getAttribute("price");
		 }
		list.add(proname);
		 session.setAttribute("prolist",list);
		list2.add(price);
		session.setAttribute("price",list2);
	%>
<table class="list-table">
      <thead>
          <tr>
              <th width="150">제품이름</th>
              <th width="100">가격</th>
              <th width="150">이미지</th>
              <th width="70">수량</th>
              <th width="70">추가</th>
            </tr>
        </thead>
        <tbody>
         <%
         	int i=0;
         	for(i=0; i<list.size(); i++){
         %>
			<tr>
        	<form action="basket_del.jsp" method="post">
        		<input type="hidden" name="num<%=i %>" />
	    		<td width="150" ><input type="hidden" value="" name="product" /><%=list.get(i) %></td>
	    		<td width="100"><input type="hidden" value="" name="price" /><%=list2.get(i) %></td>
	            <td width="150"><input type="hidden" value="1" name="img" /><img src="imgs/.jpg" alt="sony" title="sony" width="180" /></td>
	            <th width="70">1</th>
	            <td width="70"><input type="submit" value="삭제" name="chk" /></td>
          </form>
        </tr>
        <% } %>
       </tbody>
      </table>
</body>
</html>