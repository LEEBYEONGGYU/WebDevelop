<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="template.css" />

<% String contentPage = request.getParameter("CONTENTPAGE"); %>

<header>
	<jsp:include page="top.jsp" flush="false" />
</header>
<div id="content">
	<section id="areaSub">
		<jsp:include page="left.jsp" flush="false" />
	</section>
	<section id="areaMain">
		<jsp:include page="<%=contentPage %>" flush="false" />
	</section>
</div>
<footer>
	<jsp:include page="bottom.jsp" flush="false" />
</footer>