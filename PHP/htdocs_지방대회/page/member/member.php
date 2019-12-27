<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="stylesheet" type="text/css" href="/css/sub.css" />
<link rel="stylesheet" type="text/css" href="/css/board.css" />
<link rel="stylesheet" type="text/css" href="/css/member.css" />
<div id="m_content">
	<div id="m_inner">
		<form action="/page/member/member_ok" method="post" id="form1" onsubmit="return check()" >
			<ul class="it">
				<li>*은 필수사항입니다.</li>
			</ul>
			<ul class="iline">
			<!--- ID =-->
				<li class="fl  idtop afont"><label for="id">*아이디</li>
				<li class="fl idtop idleft"><input type="text" maxlength="10" id="id" title="ID를 입력해주세요." name="id" /></li>
				
			</ul>
			<ul class=" pasw">
			<!--- pw =-->
				<li class="fl afont"><label for="pw">*비밀번호</label></li>
				<li class="fl pwleft"><input type="password" id="pw" name="pw" title="비밀번호"  maxlength="16"/></li>
			</ul>
			<ul class="pasw2">
				<li class="fl afont"><label for="pw_check">*비밀번호 확인</label></li>
				<li class="fl pwleft2"><input type="password" id="pw_check" name="pw_check" title="비밀번호 확인"/></li>
			</ul>
			<ul class="na">
				<li class="fl afont"><label for="name">*이름</label></li>
				<li class="fl naleft"><input type="text" ID="name" title="이름을 입력해주세요" name="name" /></li>
			</ul>
			<ul class="pn">
				<li class="fl afont"><label for="p_num2">*휴대폰 번호</label></li>
				<li class="fl pin"><select id="p_num" name="p_num" title="휴대폰 번호를 입력해주세요."><option value="010">010</option><option value="011">011</option><option value="016">016</option></select></li>
				<li class="fl">-<input type="text" id="p_num2" name="p_num2"  size="5" maxlength="5"/></li>
				<li class="fl">-<input type="text" id="p_num3" name="p_num3"  size="5" maxlength="5"/></li>
			</ul>
			<ul class="ma">
				<li class="fl afont"><label for="email">*이메일</label></li>
				<li class="fl maleft"><input type="text" id="email" title="이메일을 입력해주세요" name="email" size="7"/>@</li>
				<li class="fl"><input type="text" id="email2"  name="email2" size="7"/></li>
			</ul>
			
			<ul class="cap">
				<li class="fl afont"><label for="capt">*자동가입등록방지</label></li>
				<li class="fl capleft"><img src="/page/captcha.php" alt="capt" id="capt" name="capt" /></li>
				<li class="cain"><input type="text" id="capt" title="자동가입방지문자를 입력해주세요." name="capt" size="5"/></li>
			</ul>
			<ul class="mit" id="bnt_show">
				<li><input type="button" value="등록하기" onclick="check('id,pw,pw_check,name');" /></li>
				<li><input type="reset" value="다시하기" /></li>
			</ul>
			<ul class="mit dn" id="bnt_hidden">
				<li>잠시만 기다려주세요...</li>
			</ul>
		</form>
	</div>

</div>