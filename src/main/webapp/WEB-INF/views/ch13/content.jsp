<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">DI(의존성 주입)</div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">XML 방식과 annotation 방식으로 주입</div>
			<div class="card-body">
				<a href="request1" class="btn btn-info btn-sm">request1</a> <a
					href="request2" class="btn btn-info btn-sm">request2</a> <a
					href="request3" class="btn btn-info btn-sm">request3</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
