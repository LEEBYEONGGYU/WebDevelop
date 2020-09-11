<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<style>
	#result {
		width:200px;
		height:200px;
		border:5px double #6699FF;
	}
</style>
<script>
	$(document).ready(function(){
		$("#b1").click(function(){
			$.post("process.jsp",{
				name:$("#name").val(),
				stus:$("#stus").val()
			},	
			function(data,status){
				if(status = "success")
					$("#result").html(data)
			});
		});
	});
</script>
</head>
<body>
	
	<button id="b1">결과</button>
	<input type="text" id="name" name="name"><br>
	<input type="text" id="stus" name="stus">
	<div id="result"></div>
</body>
</html>