<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="researchTest.jsp" method="post">
<fieldset>
<dl>
<legend><h2>설문 조사</h2></legend>
	<dd>
		<label for="name">이름 :</label>
		<input type="text" name="name" placeholder="이름" requried />
	</dd>
	<br>
	<dd>
		<label for="gender">성별 :</label>
		<input type="radio" name="gender" placehoder="성별" requried value="girl" />여자<input type="radio" name="gender" placehoder="성별" requried value="men" /> 남자
	</dd>
	<br>
	<dd>
	좋아하는 계절<br>
		<input type="checkbox" name="season" requried value="0" />봄
		<input type="checkbox" name="season" requried value="1" />여름
		<input type="checkbox" name="season" requried value="2" />가을
		<input type="checkbox" name="season" requried value="3" />겨울
	</dd>
</dl>
<input type="submit" value="전송 "/>
</form>
</fieldset>
</body>
</html>