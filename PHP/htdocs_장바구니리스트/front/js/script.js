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
		},500000);
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


$(function(){
	$(".login_bottom2").click(function(){
		$("#login_2").dialog({
			title:"로그인",
			width:480,
			modal:true,
		});
	});

$(".sear_bt").click(function(){
	$(".sear_bt").removeClass("se_bt");
});

});


