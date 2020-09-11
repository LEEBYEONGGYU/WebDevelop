<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="./includes/header.jsp"%>
<main>
	<div class="container-fluid">
		<h1 class="mt-4">BBS</h1>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table mr-1"></i>BBS Register Page
			</div>
			<div class="card-body">
				<div class="table-responsive">
				<form action="/board/modify" method="post" role="form">
				
				
					<div class="form-group">
							<label>Bno</label>
							<input class="form-control" value="<c:out value='${board.bno}'" readonly />
						</div>
						<div class="form-group">
							<label>Title</label>
							<input class="form-control" value="<c:out value='${board.title}'" name="title" >
						</div>
						<div class="form-group">
							<label>Text area</label>
							<input class="form-control" value="<c:out value='${board.content}'" name="content">
						</div>
						<div class="form-group">
							<label>Writer</label>
							<input class="form-control" value="<c:out value='${board.writer}'" name="writer">
						</div>
						<div class="form-group">
							<label>Regiested date</label>
							<input class="form-control" value="<fmt:formatDate pattern="yyyy/MM/dd" value='${board.regdate}'" readonly/>
						</div>
						<div class="form-group">
							<label>Regiested date</label>
							<input class="form-control" value="<fmt:formatDate pattern="yyyy/MM/dd" value='${board.updatedate}'" readonly/>
						</div>
						
						<input type="hidden" name="pageNum" value="${crt.pageNum }">
						<input type="hidden" name="amount" value="${crt.amount}">
						<input type="hidden" name="type" value="${crt.type}">
						<input type="hidden" name="keyword" value="${crt.keyword}">
						<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
						<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
						<button type="submit" data-oper="list" class="btn btn-info">List</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>
<script>
$(document).ready(function(){
	var forObj = $("form");
	$("button").on("click", function(e){
		e.preventDefault();

		var operation = $(this).data("oper");
		console.log(operation);
		if(operation == 'remove'){
			formObj.attr("action", "/bbs/remove");
			}else if (operation=="list"){
				//self.location = "/board/list" return;
				formObj.attr("action", "/board/list").attr("method", "get");
				var pageNumTag = $("[input[name='pageNum']").clone();
				var amountTag = $("[input[name='amount']").clone();
				var typeTag = $("[input[name='type']").clone();
				var keywordTag = $("[input[name='keyword']").clone();
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
				}
		forObj.submit();
		});
});
</script>

<%@include file="./includes/footer.jsp"%>