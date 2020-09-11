$(function(){// 제이쿼리를 시작하자
	$("#click_fn").click(function(){ //click_fn id를 클릭하면
		$.ajax({
			type: 'post', //데이터전송타입은 post다
			data:{idck:$("#inhear").val()}, //data는 json형태로 {idck:value}
			url:'/json_ex/json_ck.jsp', //json_ck.jsp로 데이터를 전송!
			dataType : 'json', //데이터타입은 JSON이다
			success: Success_ok, //성공했을 때 whenSuccess함수 호출
			error:Error_fal //실패시 whenError 함수 ㅎ출
			
		});
		
		//json_ck.jsp에서 성공한 결과를 edata매개변수로 가져옴
		function Success_ok(edata){
			$.each(edata, function(index,entry){ //forEach문같은거임
				console.log("index값은"+index); //JSON의 키 값
				console.log("entry값은"+entry); //JSON의 value값
				$("#result").html(edata['proid']); //result id에 html으로 edata의 proid값 출력
				$("#result").html(entry); //result id에 html으로 entry출력
				console.log(edata); //json_ck에서 전송된 값
				
				/* 구지 for each문 안써도 됨 쓰고 싶지 않으면 $("#result").html(entry["proid"]);하면 됨*/
			});
		}
		
		function Error_fal(){
			alert("실패");
		}
	});
});