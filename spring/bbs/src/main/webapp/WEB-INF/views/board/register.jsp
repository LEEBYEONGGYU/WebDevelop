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
					<form action="/board/register" method="post">
						<div class="form-group">
							<label>Title</label>
							<input class="form-control" name="title">
						</div>
						<div class="form-group">
							<label>Text area</label>
							<input class="form-control" name="content">
						</div>
						<div class="form-group">
							<label>Writer</label>
							<input class="form-control" name="writer">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
						<button type="reset" class="btn btn-default">Reset</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</main>

<%@include file="./includes/footer.jsp"%>