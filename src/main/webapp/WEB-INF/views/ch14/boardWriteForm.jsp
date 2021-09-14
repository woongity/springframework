<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">새글쓰기</div>
	<div class="card-body">
		<form id="boardWriteForm" method="post" action="boardWrite">
			<!-- <table style="width:auto" class="table table-sm table-bordered"> -->
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">btitle</span>
				</div>
				<input id="btitle" type="text" name="btitle" class="form-control">
				<span id="btitleError" class="error"></span>
			</div>

			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">bcontent</span>
				</div>
				<textarea id="bcontent" name="bcontent" class="form-control"></textarea>
				<span id="bcontentError" class="error"></span>
			</div>

			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">btitle</span>
				</div>
				<input id="writer" type="text" name="mid" class="form-control" value="user" readOnly>
				<span id="btitleError" class="error"></span>
			</div>

			<div class="mt-3">
				<button class="btn btn-info btn-sm mr-2">글쓰기</button> 
				<a class="btn btn-info btn-sm" href="boardList">취소</a>
			</div>
		</form>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
