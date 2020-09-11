<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="qaidx" value="${ndx}" />
<script>alert("문의글이 수정되었습니다"); location.href="bo_read.do?idx=${qaidx}";</script>