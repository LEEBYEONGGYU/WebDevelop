<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.apache.commons.codec.digest.DigestUtils"%>
<%
String sha256hex = DigestUtils.sha256Hex("1234");
out.print(sha256hex+"<br>");
%>