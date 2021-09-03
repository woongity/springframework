<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>


<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="card m-2">
	<div class="card-header">
		forward & redirect
	</div>
	<div class="card-body">
		<a href="forward" class="btn btn-info btn-sm">jsp 포워드</a>
		<a href="forward" class="btn btn-info btn-sm">홈으로 redirect</a>
	</div>
	<hr>
	<p> [ajax 요청은 redirect를 하면 안]</p>
	<a href="javascript:ajax1()" class="btn btn-info btn-sm">ajax요청1</a>
	<a href="javascript:ajax2()" class="btn btn-info btn-sm">ajax요청2</a>
	<a href="javascript:ajax3()" class="btn btn-info btn-sm">ajax요청3</a>
	<a href="javascript:ajax4()" class="btn btn-info btn-sm">ajax요청4</a>

	<div id="content" class="mt-2">
	</div>
	<script>
		function ajax1(){
			console.log("ajax 1이 실행됨");
			$.ajax({
				url:"getFragmentHtml"
			})
			.done((data)=>{
				$('#content').html(data);
			});
		}
	
		function ajax2(){
			console.log("ajax 2가 실행됨");
			$.ajax({
				url:"getJson1"
			})
			.done((data)=>{
				$("#content").html("<img src='${pageContext.request.contextPath}/resources/images/"+data.fileName+"'width = '200px'/>");
			})
		}
		
		function ajax3(){
			console.log("ajax 3이 실행됨");
			$.ajax({
				url:"getJson2"
			})
			.done((data)=>{
				$("#content").html("<img src='${pageContext.request.contextPath}/resources/images/"+data.fileName+"'width = '200px'/>");
			})
		}
	</script>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
