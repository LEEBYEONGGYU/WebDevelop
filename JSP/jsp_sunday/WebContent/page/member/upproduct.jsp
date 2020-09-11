<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>

<div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">관리자페이지 - 상품등록</div>
	<div id="sub_con_t2">홈페이지를 관리합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="admin.jsp"><li id="ad_proout" class="fl"></li></a>
			<a href="upproduct.jsp"><li id="ad_proup" class="fl"></li></a>
			<a href="mem_admin.jsp"><li id="ad_mem" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	
	<div id="my_content" >
        <h1>상품 등록</h1>
            <div id="write_area">
                <form action="write_ok.php" method="post" enctype="multipart/form-data">
                    <div class="in_text">
                        <textarea name="title" id="utitle" rows="1" cols="55" placeholder="상품코드" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="name" id="uname" rows="1" cols="55" placeholder="제조사명" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="name" id="uname" rows="1" cols="55" placeholder="입고명" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="name" id="uname" rows="1" cols="55" placeholder="재고수량" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_date">
                       	 <span>날짜 : </span><textarea id="datepicker" rows="1" cols="55" placeholder="마감날짜" style="width:200px; position:relative; top:10px;"></textarea>
                       	 	<textarea name="name" id="platanusTime" style=" width:200px; position:relative; top:10px;" onclick="javascript:fn_timePicker(this);" rows="1" cols="55" placeholder="시간선택" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="content" id="ucontent" placeholder="내용" required></textarea>
                    </div>
                    <div class="in_text">
                        <span>상품 이미지 : </span><input type="file" value="1" name="b_file" />
                    </div>
                    <div class="bt_se">
                        <button type="submit">글 작성</button>
                    </div>
                </form>
            </div>
        </div>
	<script>
	$( function() {
	    $( "#datepicker" ).datepicker();
	  } );
	function fn_timePicker(obj) {
		var id = $(obj).attr("id");
		$("#" + id).timepicker({
			timeFormat : "HH:mm",
			interval : 10,
			dynamic : false,
			dropdown : true,
			scrollbar : true
		});
		$("#" + id).timepicker("open");
	}
	</script>
	<%@ include file="/include/footer.jsp" %>