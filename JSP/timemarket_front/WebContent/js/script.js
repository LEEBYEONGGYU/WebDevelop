

/* 비주얼 이미지 슬라이드 관련 */
var chk2=false;
$(function(e){
	//최초 한번 실행
	if(chk2){
		return false;																																			
	}else{
		chk2=true;
		prog();
	}
	// 자동재생
	slider.on();
	//STYLE
	$("#slider").css({
		width : max_num * 100 + "%"
	});
	$("#slider li").css({
		width : 100 / max_num + "%"
	});
});
// ON / OFF
var slider = {
	on : function(){
		slider.off();
		this.timer=setTimeout(function(){
			animation('right');
		},5000);
	},
	off : function(){
		clearTimeout(this.timer);
	}
}
// FUNCTION
var pos = 1;
var max_num = 3;
function animation(type){
	switch(type){
		case "right" :
			pos = pos == max_num ? 1 : pos + 1;
		break;
		case "left" :
			pos = pos == 1 ? max_num : pos - 1;
		break;
		default :
			pos = parseInt(type);
		break;
	}
	
	prog();
	
	$("#trash1").css({
		display:"block",
		marginLeft:"-100%"
	});
	$("#trash2").css({
		display:"block",
		marginLeft:"100%"
	});
	$("#trash3").css({
		display:"block",
		marginLeft:"-100%"
	});
	$("#trash4").css({
		display:"block",
		marginLeft:"100%"
	});
	$("#trash5").css({
		display:"block",
		marginLeft:"-100%"
	});
	
	$("#slide_index li a").removeClass('now');
	$("#slide_index li:nth-of-type("+pos+") a").addClass('now');
	
	$("#trash1").animate({
		marginLeft:"100%",
		display:"none"
	},1000);
	$("#trash2").animate({
		marginLeft:"-100%",
		display:"none"
	},1000);
	$("#trash3").animate({
		marginLeft:"100%",
		display:"none"
	},1000);
	$("#trash4").animate({
		marginLeft:"-100%",
		display:"none"
	},1000);
	$("#trash5").animate({
		marginLeft:"100%",
		display:"none"
	},1000);
	
	$("#slider").animate({
		marginLeft : "-" + (pos-1) * 100 + "%"
	},1000, function(){
		slider.on();
	});
}
function prog(mode){
	$("#trash6").stop(Queue=0);
	$("#trash7").stop(Queue=0);
	$("#trash6").css({
		height:"0px"
	});
	$("#trash7").css({
		width:"0px"
	});
	$("#trash6").animate({
		height:"100%"
	},5000);
	$("#trash7").animate({
		width:"100%"
	},5000);
}

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
	var uid = $("#uid").val(); //사용자 아이디
	var pcode = $("#pcode").val(); //상품코드
	var pilval = $("#pil").val(); //1. 필수상품
	var lensval = $("#lens").val(); //2. 렌즈선택
	var sdcardval = $("#sdcard").val(); //3. 메모리 카드 선택
	var trival = $("#tridae").val(); //4. 삼각대 선택
	
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
	$.post("product_gume.do",{
		userid:uid,
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
	var uid = $("#uid").val(); //사용자 아이디
	var pcode = $("#pcode").val(); //상품코드
	var pilval = $("#pil").val(); //1. 필수상품
	var lensval = $("#lens").val(); //2. 렌즈선택
	var sdcardval = $("#sdcard").val(); //3. 메모리 카드 선택
	var trival = $("#tridae").val(); //4. 삼각대 선택
	//String값을 비교하여 같은 항목이 있 경우 false값으로 반환한다
	
	switch(pilval){
	case "1. 필수선택": pilval = "";
	default: pilval;
	}
	switch(lensval){
	case "2. 렌즈선택": lensval = "";
	default: lensval;
	}
	switch(sdcardval){
	case "3. 메모리카드 선택": sdcardval = "";
	default: pilval;
	}
	switch(trival){
	case "4. 삼각대 선택": trival = "";
	default: trival;
	}
	
	//만약 true이면
	
	//post형식으로 basket_ok_jsp에 json형식으로 데이터를 전송
	$.post("product_basket.do",{
		userid:uid,
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


