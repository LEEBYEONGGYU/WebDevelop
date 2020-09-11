<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("p").mouseenter(function(){
			$(this).text("마우스포인트 안녕!");
		});
		
		$("p").mouseleave(function(){
				$(this).text("돌아와 마우스 포인터!");
		});
		
		$("button").dblclick(function(){
			$(this).css("background-color","#cccccc");
		});
		
	});

</script>
</head>
<body>
	<p>마우스 포인터를 여기에</p>
	<button>더블클릭하렴</button>
</body>
</html>