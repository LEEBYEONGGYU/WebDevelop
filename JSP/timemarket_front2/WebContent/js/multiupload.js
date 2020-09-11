$(document).ready(function(){
	
	$("#upForm1").ajaxForm({
		success: function(data, status){
			$("#upResult").html("파일 업로드 완료.<br>");
			var appChild = "<p class='cau'><button id='refreshForm' onclick='refresh()'>";
			appChild += "업로드 폼 초기화</button>※폼을 초기화할 경우, 클릭하십시오.</p>";
			$("#upResult").append(appChild);
   		}
    });
	
});

//업로드폼 초기화
function refresh(){
	//페이지 리로드를 사용한 폼 초기화
	location.reload(true);
}
