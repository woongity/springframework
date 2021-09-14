<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header"></div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">
				연결 테스트 
			</div>
			<div class="card-body">
				<a href="testConnectToDB" class="btn btn-info btn-sm">테스트</a>
			</div>
		</div>
		<div class="card">
			<div class="card-header">
				JDBC 연습 
			</div>
			<div class="card-body">
				<a href="testInsert" class="btn btn-info btn-sm">testInsert</a>
				<a href="testSelect" class="btn btn-info btn-sm">testSelect</a>
				<a href="testUpdate" class="btn btn-info btn-sm">testUpdate</a>	
				<a href="testDelete" class="btn btn-info btn-sm">testDelete</a>
			</div>
		</div>
		<div class="card">
			<div class="card-header">
				MyBatis를 이용하는 DAO 
			</div>
			<div class="card-body">
				<a href="join" class="btn btn-info btn-sm">회원가입</a>
				<a href="login" class="btn btn-info btn-sm">로그인</a>
				<a href="boardList" class="btn btn-info btn-sm">게시판</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
