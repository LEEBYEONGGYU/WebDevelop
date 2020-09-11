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
					<div class="form-group">
							<label>Bno</label>
							<input class="form-control" value="<c:out value='${board.bno}'" readonly />
						</div>
						<div class="form-group">
							<label>Title</label>
							<input class="form-control" value="<c:out value='${board.title}'" name="title" readonly>
						</div>
						<div class="form-group">
							<label>Text area</label>
							<input class="form-control" value="<c:out value='${board.content}'" readonly name="content">
						</div>
						<div class="form-group">
							<label>Writer</label>
							<input class="form-control" value="<c:out value='${board.writer}'" name="writer">
						</div>
						<button data-oper="modify" class="btn btn-default" >Modify</button>
						<button data-oper="list" class="btn btn-info">List</button>
					
					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno" value="<c:out value='${board.bno}>'">
						<input type="hidden" name="pageNum" value="${crt.pageNum }">
						<input type="hidden" name="amount" value="${crt.amount} }">
						<input type="hidden" name="type" value="${crt.type} }">
						<input type="hidden" name="keyword" value="${crt.keyword} }">
					</form>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel"
				</div>
			</div>
		</div>
		
		
		
		
	</div>
</main>
<script>
$(document).ready(function(){
	var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e){
			operForm.submit();
			});
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list");
			operForm.submit();
			});
});
</script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			var bno = ${board.bno};

			replyService.getList({bno:bno, page:1}, function(data){
					for(var i=0; len=list.length|| 0; i<len; i++){
						console.log(list[i]);
						}
				});
			console.log(replyService);
			replyService.add({reply:"AJAX TEST", replyer:"ㅊㅊㅊㅊ", bno:}, function(result){alert("RESULT"+result)
				});

			replyService.remove(10, function(result){
					console.log(result);
					if(result == "success"){
						alert("removed")
					}, function(err){
						alert("error"+err)
						});
				});

	replyService.update({rno:9, reply:'Modified Reply'}, function(result){
			if(result ==="success"){
					alert("수정완료"+result);
				}
		});

	
	replyService.get(11, function(result){
			console.log(data);
		});
		});
</script>
<%@include file="./includes/footer.jsp"%>