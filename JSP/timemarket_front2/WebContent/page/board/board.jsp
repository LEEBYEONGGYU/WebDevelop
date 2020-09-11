<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!-- CONTENT -->
<div id="sub_content">
	<div id="sub_content_in">
	<div id="sub_con_t" class="tc">고객센터에서 궁금하신 점을 찾아보세요</div>
	<div id="sub_con_t2" class="tc">궁금하신 점 또는 상품에 대한 질문내용을 입력해주시면 상세히 안내해드립니다.</div>
	<div id="consume_in">
		<img src="../../imgs/shop_info.png" alt="" title="" id="shop_info_bt">
		<img src="../../imgs/jaju_icon.png" alt="" title="" id="jaju_icon_bt">
		<img src="../../imgs/qa_icon.png" alt="" title="" id="qa_icon_bt">
	</div>
	
	<div id="board_write">
        <h1>문의글 작성</h1>
            <div id="write_area">
                <form action="write_ok.do" name="bo_form" method="post" enctype="multipart/form-data">
                <input type="hidden" name="userid" value="<%=session.getAttribute("userid") %>" />
                    <div class="in_text">
                        <textarea name="qa_title" rows="1" cols="55" placeholder="제목" maxlength="100" required></textarea>
                    </div>
                    <div class="wi_line"></div>
                    <div class="in_text">
                        <textarea name="qa_text" placeholder="내용" required></textarea>
                    </div>
                    <div class="in_text in_date">
                    	<input type="file" name="qa_file" />
                    </div>
                    <div class="bt_se">
                        <button type="submit">글 작성</button>
                    </div>
                </form>
            </div>
        </div>
	</div>
	</div>
		
<%@ include file="/include/footer.jsp" %>