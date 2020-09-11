<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewpart" content="width=device-width,inital-scale=1.0"/>
<title>Insert title here</title>
</head>
<body>
<h2>request 예제 - 요청 메소드</h2>
<form method="get" action="requestTest1.jsp">
	<dl>
		<dd>
			<label for="name">이름</label>
			<input id="name" name="name" type="text" placeholder="김개동" autofocus requried />
		</dd>
		<dd>
			<label for="age">나이</label>
			<input id="age" name="age" type="number" min="20" max="99" value="20" required />
		</dd>
		<dd>
			<filedset>
				<legend>성별</legend>
				<input id="gender" name="gender" type="radio" value="m" checked />
				<label for="gender">남</label>
				<label for="gender">여</label>
			</filedset>
		</dd>
		<dd>
		<label for="hobby">취미</label>
			<select id="hobbby" name="hobby" required>
				<option value="잠자기" selected>잠자기
				<option value="무협지보기">무협지보기
				<option value="애니메이션시청">애니메이션 시청
				<option value="건프라">건프라
			</select>
		</dd>
		<dd>
			<input type="submit" value="속성" />
		</dd>
	</dl>
</form>
</body>
</html>