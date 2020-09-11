<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
   $('#check').click(function(){
      if($('#userid').val()==0){
         $('#result').text('아이디를 입력하세요');
         return;
      }
      query = {userid:$('#userid').val()}
      $.ajax({
         url:'ajax_test.jsp',
         type:'post',
         data: query
      }).done(function(data){
         obj = JSON.parse(data);
         
         if(obj.result == 'ok'){
            $('#result').text(obj.username + "," + obj.email);
         }else {
            $('#result').text("존재하지 않는 사용자입니다.");
         }
         
      });
   });
});
</script>
</head>
<body>
	<label for="userid">USER ID</label>
<input type="text" id="userid">
<button id="check">Check</button>
<p id="result"></p>
</body>
</html>