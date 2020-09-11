<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/include/header.jsp" %>
    <div id="sub_content_my">
	<div id="sub_content_in">
	<div id="sub_con_t">관리자페이지 - 상품등록</div>
	<div id="sub_con_t2">상품을 등록합니다.</div>
	<div id="mymenu">
		<ul>
			<a href="admin.do"><li id="ad_proout" class="fl"></li></a>
			<a href="upproduct.do"><li id="ad_proup" class="fl"></li></a>
			<a href="mem_admin.do"><li id="ad_mem" class="fl"></li></a>
			<a href="qa_admin.do"><li id="qa_admin" class="fl"></li></a>
		</ul>
	</div>
	</div>
	</div>
	<div id="my_content" >
 <h1>상품 등록</h1>
            <div id="write_area">
                <form action="upproduct_ok.do" id="pro_form"method="post" enctype="multipart/form-data">
                    <div class="in_text">
                        <textarea name="p_manuf" id="p_manuf" rows="1" cols="55" placeholder="제조사명" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="p_name" id="p_name" rows="1" cols="55" placeholder="상품명" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="p_wname" id="p_wname" rows="1" cols="55" placeholder="입고명" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="p_cot" id=p_cot rows="1" cols="55" placeholder="재고수량" maxlength="100" required></textarea>
                    </div>
                    <div class="in_text">
                        <textarea name="p_price" id="p_price" rows="1" cols="55" placeholder="가격" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_date">
                       	 <span>날짜 : </span><input type="text" id="p_enddate" class="datepicker" name="p_enddate" placeholder="" style="width:200px; position:relative; top:10px;">
           
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="pcontent" id="pcontent" placeholder="내용" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                       	<span style="font-size:26px;">상품 이미지 : </span><input type="file" id="pfile" name="pfile" />
                    </div>
                    <div class="in_text">
                       	<span style="font-size:26px;">상품상세 이미지 : </span><input type="file"  id="pfile2" name="pfile2" />
                    </div>
                    <div class="bt_se">
                        <button type="submit">글 작성</button>
                    </div>
                </form>
            </div>
        </div>
        
        <script>
   
</script>
	<%@ include file="/include/footer.jsp" %>