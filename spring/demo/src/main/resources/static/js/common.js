$(document).ready(function(){
	
	$(document).on("click", "#add_bt", function(){
		window.open("/page/note/adress_import","주소록 가져오기",width="500", height="300");
});
		
	$("#wri_m_bt").click(function(){
		$.ajax({
			type:'get',
			url:'/page/note/write',
			dataType:'html',
			success:function(result){
				$("#main_in").html(result);
			},
			error:function(error){
				alert(error);
			},
		});
	});
	
//	$("#rec").click(function(){
//		$.ajax({
//			type:'get',
//			url:'/page/note/rec_note',
//			dataType:'html',
//			success:function(result){
//				$("#list_wrap").html(result);
//			},
//			error:function(error){
//				alert(error);
//			}
//		});
//	});
//		
//		$("#send").click(function(){
//		$.ajax({
//			type:'get',
//			url:'/page/note/send_note',
//			dataType:'html',
//			success:function(result){
//				$("#list_wrap").html(result);
//			},
//			error:function(error){
//				alert(error);
//			}
//		});
//		
//	});
});

