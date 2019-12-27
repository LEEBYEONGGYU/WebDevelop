<!--- 쇼핑 폼 --->
<meta charset='utf-8' />
<form action ="/shop/write_ok" method="post" enctype="multipart/form-data">
<ul>
	<li>이름 : <input type="text" id="name" name="name" title="name" /></li>
	<li>사진 : <input type="file" id="photo" title="photo" name="photo" /></li>
	<li>가격 : <input type="text" id="amount" title="amount" name="amount" /></li>
	<li>원산지 : <input type="text" id="intro" title="intro" name="intro" /></li>
</ul>
<input type="submit" value="등록" />
</form>