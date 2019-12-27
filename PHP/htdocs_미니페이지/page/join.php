<script>
// HTML, CSS이 출력된 후 실행
$(document).ready(function(e) {
	$(".check").on("keyup", function(){
		var self = $(this); // keyup한 this
		var userid, pw; // 변수 생성
		
		// 현재 
		if(self.attr("id") === "userid"){
			pw = null; // 변수 초기화
			userid = self.val(); // 변수 초기화
		} else if(self.attr("id") === "pw"){
			userid = null; // 변수 초기화
			pw = self.val(); // 변수 초기화
		}
		
		// AjAx POST값으로 넘기기
		$.post(
			"/include/check.php", // href
			{ userid : userid, pw : pw }, // 포스트이름 : 변수 값
			function(data){ // html문서에 출력된 값
				if(data){
					self.parent().parent().find("li:last-child").html(data); // 현재 할머니에 마지막 자식의 text값을 초기화하고 data값을 넣는다.
					self.parent().parent().find("li:last-child").css("color", "#F00"); // 현재 엄마의 엄마의 자식중 마지막 자식의 style에 color을 red로 바꿈.
				}
			}
		);
	});
});
</script>
<div class="join">
	<form action="/join" method="post">
        <div class="join_area">
            <ul>
                <li><label for="userid">아이디</label></li>
                <li><input type="text" id="userid" name="userid" title="아이디" value="" class="check"></li>
                <li id="id_check"> + 아이디를 체크합니다.</li>
            </ul>
            <ul>
                <li><label for="pw">비밀번호</label></li>
                <li><input type="password" id="pw" name="pw" title="비밀번호" value="" class="check"></li>
                <li id="pw_check"> + 비밀번호도 체크합니다.</li>
            </ul>
        </div>
    </form>
</div>