/* jqueryui modal 관련*/
$(function(){
	$(".login_bottom2").click(function(){
		$("#login_2").dialog({
			title:"로그인",
			width:480,
			modal:true,
		});
	});
	
	$("#join_mem").click(function(){
		$("#join_frm").dialog({
			title:"회원가입",
			width:700,
			modal:true,
		});
	});

/* ajax 구매하기*/
$("#pro_infogubt").click(function(){
	$("#gume_frm").dialog({
		title:"구매하기",
		width:700,
		modal:true,
	});
	
	
});

/* ajax 장바구니 담기  */
$("#pro_infogubt").click(function(){
	//a,b,c,d,각 변수에 필수선택과 선택옵션 값들을 받아와서
	var pcode = $("#pcode").val();
	var pilval = $("#pil").val();
	var lensval = $("#lens").val();
	var sdcardval = $("#sdcard").val();
	var trival = $("#tridae").val();
	
	//String값을 비교하여 같은 항목이 있을 경우 false값으로 반환한다
	if(pilval == "1. 필수선택"){
		pilval = "";
		
	}else{
		
	}
	if(lensval == "2. 렌즈선택"){
		lensval = "";
	
	}else{
		
	}
	
	if(sdcardval == "3. 메모리카드 선택"){
		sdcardval = "";
		
	}else{
		
	}
	
	if(trival == "4. 삼각대 선택"){
		trival = "";
		
	}else{
		
	}
	//만약 true이면
	
		//post형식으로 basket_ok_jsp에 json형식으로 데이터를 전송
	$.post("gume_ok.jsp",{
		pcode:pcode,
		pil:pilval,
		opt1:lensval,
		opt2:sdcardval,
		opt3:trival,
	},
	
	
	function(data,success){
		if(success=="success"){
			alert("ajax전송완료");
			$("#gume_succ").dialog({
				title:"구매완료",
				width:400,
				modal:true,
			});
		}else{
			alert("전송실패");
		}
	});//데이터 전송 끝
});
$("#pro_jangbt").click(function(){ //pro_jangbt를 클릭하면

	//a,b,c,d,각 변수에 필수선택과 선택옵션 값들을 받아와서
	var pcode = $("#pcode").val();
	var pilval = $("#pil").val();
	var lensval = $("#lens").val();
	var sdcardval = $("#sdcard").val();
	var trival = $("#tridae").val();
	
	//String값을 비교하여 같은 항목이 있을 경우 false값으로 반환한다
	if(pilval == "1. 필수선택"){
		pilval = "";
		
	}else{
		
	}
	if(lensval == "2. 렌즈선택"){
		lensval = "";
		
	}else{
		
	}
	
	if(sdcardval == "3. 메모리카드 선택"){
		sdcardval = "";
		
	}else{
		
	}
	
	if(trival == "4. 삼각대 선택"){
		trival = "";
		
	}else{
		
	}
	//만약 true이면
	
		//post형식으로 basket_ok_jsp에 json형식으로 데이터를 전송
	$.post("basket_ok.do",{
		pcode:pcode,
		pil:pilval,
		opt1:lensval,
		opt2:sdcardval,
		opt3:trival,
	},
	
	
	function(data,success){
		if(success=="success"){
			alert("ajax전송완료");
			$("#basket_succ").dialog({
				title:"장바구니 담기",
				width:400,
				modal:true,
			});
		}else{
			alert("전송실패");
		}
	});//데이터 전송 끝
	
}); //장바구니 버튼 클릭 이벤트 끝


//ajax 아이디체크
$("#juck").click(function(){
	$.ajax({
		type: 'post',
		data:{
			idck:$("#userid").val()
		},
		url:'/timemarket_front/page/member/id_check.jsp',
		dataType : 'json',
		success: whenSuccess,
		error:whenError
		
	});
	var html='';
	function whenSuccess(edata){
			$("#ick").html(edata["proid"]);
			console.log(edata["proid"]);
			console.log(edata);
//		console.log(edata);
//		var jstring = JSON.parse(edata);
//		console.log(jstring.get("userid"));
//		html +=edata;
//		$("#id_check").html(html);
	}
	
	function whenError(){
		alert("실패");
	}
});

//ajax QA답글
$("#bw_bt").click(function(){
	$.ajax({
		type: 'post',
		data:{
			qidx:$("#qidx").val(),
			qtitle:$("#qtitle").val(),
			qtext:$("#qtext").val()
		},
		url:'/timemarket_front/page/admin/qa_ad_ok.jsp',
		dataType : 'json',
		success: whenSuccess,
		error:whenError
		
	});
	function whenSuccess(qdata){
			alert(qdata["qa"]);
			console.log(qdata["qa"]);
			console.log(qdata);
	}
	
	function whenError(err){
		console.log(err);
		alert("실패");
	}
});

//ajax 로그인
$("#lo_bt").click(function(){
	$.ajax({
		type: 'post',
		data:{
			uid:$("#userid").val(),
			upw:$("#userpw").val(),
		},
		url:'/timemarket_front/page/member/login_ok.jsp',
		dataType : 'json',
		success: whenSuccess,
		error:whenError
		
	});
	function whenSuccess(qdata){
		if(qdata["lo_ok"]=="1"){
			alert("로그인되었습니다");
			console.log(qdata["lo_ok"]);
			console.log(qdata);
		}else{
			alert("아이디 혹은 비밀번호를 확인해주세요");
			console.log(qdata["lo_ok"]);
			console.log(qdata);
		}
	}
	
	function whenError(err){
		console.log(err);
		alert("실패");
	}
});

$("#qa_icon_bt").click(function(){
	$("#board_write").css('display','block');
});
$("#shop_info_bt").click(function(){
	alert("준비중입니다.");
});
$("#jaju_icon_bt").click(function(){
	alert("준비중입니다.");
});

$("#p_enddate").datetimepicker({
    dateFormat:'yy-mm-dd',
    monthNamesShort:[ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
    dayNamesMin:[ '일', '월', '화', '수', '목', '금', '토' ],
    changeMonth:true,
    changeYear:true,
    showMonthAfterYear:true,

    // timepicker 설정
    timeFormat:'HH:mm:ss',
    controlType:'select',
    oneLine:true,
});
$("#p_enddate2").datetimepicker({
    dateFormat:'yy-mm-dd',
    monthNamesShort:[ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
    dayNamesMin:[ '일', '월', '화', '수', '목', '금', '토' ],
    changeMonth:true,
    changeYear:true,
    showMonthAfterYear:true,

    // timepicker 설정
    timeFormat:'HH:mm:ss',
    controlType:'select',
    oneLine:true,
});
});


