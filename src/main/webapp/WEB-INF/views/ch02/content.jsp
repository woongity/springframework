<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="card m-2">
	<div class="card-header">
		요청 방식별 메소드 매핑
	</div>
	<div class="card-body">
		<button class="btn btn-info btn-sm" onclick="requestGet()">GET</button>
		<button class="btn btn-info btn-sm" onclick="requestPost()">POST</button>
		<button class="btn btn-info btn-sm" onclick="">PUT</button>
		<button class="btn btn-info btn-sm">DELETE</button>
	</div>
	<script>
		function requestGet(){
			$.ajax({
				url : "/ch02/method1",
				method : "GET"
			})
			.done(data=>{})
		}
		function requestGet(){
			$.ajax({
				url : "/ch02/method2",
				method : "POST"
			})
			.done(data=>{})
		}
		function requestGet(){
			$.ajax({
				url : "/ch02/method3",
				method : "PUT"
			})
			.done(data=>{})
		}
		function requestGet(){
			$.ajax({
				url : "/ch02/method4",
				method : "DELETE"
			})
			.done(data=>{})
		}
	</script>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
