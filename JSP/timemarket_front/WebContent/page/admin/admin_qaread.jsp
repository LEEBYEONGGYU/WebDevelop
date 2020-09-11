<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
		<div id="sub_con_t">관리자페이지 - QA답변</div>
		<div id="sub_con_t2">구매자님들의 물음에 답변합니다.</div>
		<jsp:include page="admin_menu.jsp"></jsp:include>
	</div>
</div>
<div id="my_content">
	<sql:query var="rs" dataSource="jdbc/jsptest">
		select * from qaboard where idx=?
	<sql:param value="${param.idx}"></sql:param>
	</sql:query>
	
	<div id="board_read">
		<!-- 글 불러오기 -->
		<c:forEach var="row" items="${rs.rows}">
			<h1>
				Q. <c:out value='${row["title"]}' />
			</h1>
			<div id="user_info">
				<c:out value='${row["idx"]}' />
				<div id="bo_line"></div>
			</div>
			<div>
				파일 : <a href="../down.jsp?filename=${row['file']}" download><c:out value='${row["file"]}' /></a>
			</div>
			<div id="bo_content">
				<c:out value='${row["idx"]}' />
			</div>

			<div id="board_write" style="width: 1200px; display: block;">
				<h1>A. 답변하기</h1>
					<div id="write_area">
						<form action="admin_qaok.do" method="post">
							<input type="hidden" name="q_idx" id="qidx" value="<c:out value='${row["idx"]}'/>" />
							<div class="in_text">
								<textarea name="a_title" id="qtitle" rows="1" cols="55" placeholder="제목" maxlength="100" required></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<textarea name="a_text" id="qtext" rows="1" cols="55" placeholder="내용" required></textarea>
							</div>
							<div class="bt_se">
								<button type="submit" id="bw_bt">글 작성</button>
							</div>
						</form>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
<jsp:include page="/include/footer.jsp"></jsp:include>