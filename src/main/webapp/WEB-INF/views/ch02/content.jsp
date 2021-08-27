<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">요청 방식별 메소드 매핑</div>
	<div class="card-body">
		<button class="btn btn-info btn-sm" onclick="requestGet()">GET</button>
		<button class="btn btn-info btn-sm" onclick="requestPost()">POST</button>
		<button class="btn btn-info btn-sm" onclick="requestPut()">PUT</button>
		<button class="btn btn-info btn-sm" onclick="requestDelete()">DELETE</button>
	</div>
	<script>
		function requestGet(){
			$.ajax({
				url : "/ch02/method1",
				method : "GET"
			})
			.done(data=>{})
		}
		function requestPost(){
			$.ajax({
				url : "/ch02/method2",
				method : "POST"
			})
			.done(data=>{})
		}
		function requestPut(){
			$.ajax({
				url : "/ch02/method3",
				method : "PUT"
			})
			.done(data=>{})
		}
		function requestDelete(){
			$.ajax({
				url : "/ch02/method4",
				method : "DELETE"
			})
			.done(data=>{})
		}
	</script>
</div>
<div class="card m-2">
	<div class="card-header">model and view 리턴</div>
	<div class="card-body">
		<a class="btn btn-info btn-sm" href="/ch02/modelandview">요</a>
	</div>
</div>
<div class="card m-2">
	<div class="card-header">login</div>
	<div class="card-body">
	<!-- <form method="POST" action="/ch02/login2"> -->
		<form method="POST" action="/ch02/login2">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		</hr>
		<a class="btn btn-info btn-sm" href="boardlist">게시물 목록</a>
		<a class="btn btn-info btn-sm" href="boardwriteform">게시물 작성</a>
	</div>
</div>
<div class="card m-2">
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
