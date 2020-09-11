
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
$("#pro_jangbt").click(function(){ //pro_jangbt를 클릭하면

	//a,b,c,d,각 변수에 필수선택과 선택옵션 값들을 받아와서
	var a = $("#pil").val();
	var b = $("#lens").val();
	var c = $("#sdcard").val();
	var d = $("#tridae").val();
	var chk = "";
	
	//String값을 비교하여 같은 항목이 있을 경우 false값으로 반환한다
	if(a == "1. 필수선택"){
		if(b == "2. 렌즈선택"){
			if(c == "3. 메모리카드 선택"){
				if(d == "4. 삼각대 선택"){
					alert("옵션을 선택하지 않으셨습니다");
					chk=0;
					return false;
				}
			}
		}
	}
	
	//만약 true이면
	if(true){
		alert("참");
	
		//post형식으로 basket_ok_jsp에 json형식으로 데이터를 전송
	$.post("basket_ok.jsp",{
		pcode:$("#pcode").val(),
		pil:$("#pil").val(),
		opt1:$("#lens").val(),
		opt2:$("#sdcard").val(),
		opt3:$("#tridae").val(),
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
	
	}else{
		alert("거짓"); //if문 elses
	}
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

});


