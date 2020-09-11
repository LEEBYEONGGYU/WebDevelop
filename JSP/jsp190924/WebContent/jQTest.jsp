<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div#displayArea {
	width:200px;
	height:200px;
	border:5px double #6699FF;
}
</style>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
	/*$(document).ready(function(){
		$("#bt").click(function(){
			alert('버튼클릭됨');
		});
	});*/
	
$(document).ready(function(){
	$("button").click(function(){
		$("#displayArea").html("<img src='tablet.jpg' border='0' />");	
	});
	$("#hidden").click(function(){
		$("#displayArea").html('');
	});
});
	
</script>
</head>
<body>
<button id="bt">클릭	</button>

<div id="displayArea">이곳의 내용이 변경</div>
<button>표시</button>
<button id="hidden">감춤</button>
</body>
</html>