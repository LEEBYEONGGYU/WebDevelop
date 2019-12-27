$(function(){
	//날짜 선택
	$("#sdate, #sdate2").datepicker({
		minDate : 0,
		dateFormat : 'yy-mm-dd',
		onClose : function(selectedDate){
			if(this.id == "sdate"){
				$("#sdate2").datepicker("option","minDate",selectedDate);
			} else {
				$("#sdate").datepicker("option","maxDate",selectedDate);
			}
		}
	});
	
	$(".login_bottom").click(function(){
		$("#join_frm").dialog({
			title:"회원가입",
			width:800,
			modal:true,
		});

	});


});

/* 비주얼 슬라이드 */
