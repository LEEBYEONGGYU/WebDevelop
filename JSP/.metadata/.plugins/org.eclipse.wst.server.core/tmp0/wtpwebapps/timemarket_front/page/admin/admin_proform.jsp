<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
		<div id="sub_con_t">관리자페이지 - 상품등록</div>
		<div id="sub_con_t2">상품을 등록합니다.</div>
			<jsp:include page="admin_menu.jsp"></jsp:include>
		</div>
	</div>
	<div id="my_content">
		<h1>상품 등록</h1>
			<div id="write_area">
				<form action="admin_proupok.do" id="pro_form" method="post" enctype="multipart/form-data">
					<div class="in_text">
						<input type="text" size="55" name="p_manuf" id="p_manuf" placeholder="제조사명" required />
					</div>
					<div class="wi_line"></div>
					<div class="in_text">
						<input type="text" size="55" name="p_name" id="p_name" placeholder="상품명" required />
					</div>
					<div class="wi_line"></div>
					<div class="in_text">
						<input type="text" size="55" name="p_wname" id="p_wname" placeholder="입고명" required />
					</div>
					<div class="wi_line"></div>
					<div class="in_text">
						<input type="text" size="55" name="p_cot" id="p_cot" placeholder="재고수량" required />
					</div>
					<div class="wi_line"></div>
					<div class="in_text">
						<input type="text" size="55" name="p_price" id="p_price" placeholder="가격" required />
					</div>
					<div class="wi_line"></div>
					<div class="in_date">
						<input type="text" id="p_enddate" class="datepicker" name="p_enddate" placeholder="마감날짜" style="width: 200px; position: relative; top: 10px;">
					</div>
					<div class="wi_line"></div>
					<div class="in_text">
						<textarea name="pcontent" id="pcontent" rows="3" cols="55" placeholder="내용" required></textarea>
					</div>
					<div class="wi_line"></div>
					<div class="in_text">
						상품 이미지 : <input type="file" id="pfile" name="pfile" />
					</div>
					<div class="in_text">
						상품상세 이미지 : <input type="file" id="pfile2" name="pfile2" />
					</div>
					<div class="bt_se">
						<button type="submit">글 작성</button>
					</div>
				</form>
			</div>
		</div>
	<jsp:include page="/include/footer.jsp"></jsp:include>