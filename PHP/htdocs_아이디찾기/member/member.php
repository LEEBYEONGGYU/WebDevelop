<?php  
	include "/db.php";
?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>회원가입 폼</title>
<style>
* {margin: 0 auto;}
a {color:#333; text-decoration: none;}
.find {text-align:center; width:500px; margin-top:30px; }
</style>
</head>
<body>
	<div class="find">
		<form method="post" action="member_ok.php">
			<h1>회원가입 폼</h1>
			<p><a href="/">홈으로</a></p>
				<fieldset>
					<legend>입력사항</legend>
						<table>
							<tr>
								<td>아이디</td>
								<td><input type="text" size="35" name="userid" placeholder="아이디"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" size="35" name="userpw" placeholder="비밀번호"></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" size="35" name="name" placeholder="이름"></td>
							</tr>
							<tr>
								<td>주소</td>
								<td><input type="text" size="35" name="adress" placeholder="주소"></td>
							</tr>
							<tr>
								<td>성별</td>
								<td>남<input type="radio" name="sex" value="남"> 여<input type="radio" name="sex" value="여"></td>
							</tr>
							<tr>
								<td>이메일</td>
								<td><input type="text" name="email">@<select name="emadress"><option value="naver.com">naver.com</option><option value="nate.com">nate.com</option>
								<option value="hanmail.com">hanmail.com</option></select></td>
							</tr>
						</table>
					<input type="submit" value="가입하기" /><input type="reset" value="다시쓰기" />
			</fieldset>
		</form>
	</div>
</body>
</html>