$(document).ready(function(){
	//Ajax방식으로 요청페이지를 호출해 파일을 업로드한다. 
	$("#upForm1").ajaxForm({
		success: function(data, status){//업로드에 성공하면 수행
   			$("#upResult").html(data);//응답받은 결과를 표시
   		}
    });
});