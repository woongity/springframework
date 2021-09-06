<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>


<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="card m-2">
	<div class="card-header">
		서버 실행 오류
	</div>
	<div class="card-body">
		<p>타입 일치에 실패했습니다</p>
		<div>
			<a href="${pageContext.request.contextPath}/" class="btn btn-danger btn-sm">홈으로 가기</a>
		</div>
	</div>
	
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
