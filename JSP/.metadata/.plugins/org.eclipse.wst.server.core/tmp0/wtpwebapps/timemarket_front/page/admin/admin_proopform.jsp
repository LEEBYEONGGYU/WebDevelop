<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<jsp:include page="/include/header.jsp"></jsp:include>
<div id="sub_content_my">
	<div id="sub_content_in">
		<div id="sub_con_t">관리자페이지 - 상품등록</div>
		<div id="sub_con_t2">상품을 등록합니다.</div>
			<jsp:include page="admin_menu.jsp"></jsp:include>
		</div>
	</div>
	<div id="my_content">
		<h1>일반상품 목록</h1>
			<table class="list-table">
				<thead>
					<tr>
						<th width="100">상품코드</th>
						<th width="150">제조사명</th>
						<th width="250">상품명</th>
						<th width="180">품목명</th>
						<th width="180">재고수량</th>
						<th width="200">상품가격</th>
						<th width="200">입고날짜</th>
						<th width="200">마감날짜</th>
					</tr>
				</thead>
				<tbody>
					<sql:query var="rs" dataSource="jdbc/jsptest">
						select * from product order by p_code desc
					</sql:query>
					<c:forEach var="row" items="${rs.rows}">
						<tr>
							<td><c:out value='${row["p_code"]}' /></td>
							<td><c:out value='${row["p_manuf"]}' /></td>
							<td><c:out value='${row["p_name"]}' /></td>
							<td><c:out value='${row["p_wname"]}' /></td>
							<td><c:out value='${row["p_cot"]}' /></td>
							<td><c:out value='${row["p_price"]}' /></td>
							<td><c:out value='${row["p_indate"]}' /></td>
							<td><c:out value='${row["p_enddate"]}' /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h1 style="margin-top: 30px;">옵션상품 등록</h1>
				<p>상품에 대한 옵션을 등록할 경우 상단의 목록의 상품코드를 참조하세요.(생략가능)</p>
					<div id="write_area">
						<form action="admin_proopok.do" id="pro_form" method="post"
							enctype="multipart/form-data">
							<div class="in_text">
								<textarea name="po_code" id="po_code" rows="1" cols="55" placeholder="옵션상품코드" maxlength="100"></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<textarea name="po_manuf" id="po_manuf" rows="1" cols="55" placeholder="제조사명" maxlength="100" required></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<textarea name="po_name" id="po_name" rows="1" cols="55" placeholder="옵션상품명" maxlength="100" required></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<textarea name="po_wname" id="po_wname" rows="1" cols="55" placeholder="품목명" maxlength="100" required></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<textarea name="po_cot" id=po_cot rows="1" cols="55" placeholder="재고수량" maxlength="100" required></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<textarea name="po_price" id="po_price" rows="1" cols="55" placeholder="가격" maxlength="100" required></textarea>
							</div>
							<div class="wi_line"></div>
							<div class="in_text">
								<span style="font-size: 26px;">상품 이미지 : </span><input type="file" id="pofile" name="pofile" />
							</div>
							<div class="in_text">
								<span style="font-size: 26px;">상품상세 이미지 : </span><input type="file" id="pofile2" name="pofile2" />
							</div>
							<div class="bt_se">
								<button type="submit">글 작성</button>
							</div>
						</form>
					</div>
				</div>
				<jsp:include page="/include/footer.jsp"></jsp:include>