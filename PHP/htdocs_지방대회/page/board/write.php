<div id="write_in">
<form action="/page/board/write_ok.php" method="post" >
	<ul class="nain">
		<li class="na_wh na_p">작성자</li>
		<li class="na_put">&nbsp;&nbsp;<input type="text" title="name" id="name" name="name" /></li>
	</ul>
	<ul id="titin">
		<li class="na_wh na_p">제목</li>
		<li class="na_put">&nbsp;&nbsp;<input type="text" title="title" id="title" name="title" /></li>
	</ul>
	<ul>
		<li class="na_wh na_p">비밀번호</li>
		<li class="na_put">&nbsp;&nbsp;<input type="password" title="pw" id="pw" name="pw" /></li>
	</ul>--->
	<ul id="conin">
		<li class="na_wh na_p">내용</li>
		<li class="text_ar">&nbsp;&nbsp;<textarea cols="50" rows="5" name="content" id="content"></textarea></li>
	</ul>
	<ul id="submi">
		<li class="tr">
			<input type="submit" value="등록하기"  />
			<input type="reset" value="다시쓰기">
			<input type="button" value="뒤로가기" onclick="history.back(-1)" />
		</li>
	</ul>

</form>
</div>