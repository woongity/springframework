<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header"></div>
	<div class="card-body">
		<form method="POST" action="/ch02/boardwrite"> 
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> 
				<input type="text" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">내용</label>
				<testarea class="form-control" id="content">
			</div>
			<button type="submit" class="btn btn-primary btn-sm">저장</button>
		</form>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
