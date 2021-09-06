<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">예외처리</div>
	<div class="card-body">
		<div class="card-header">try-catch 예외처리</div>
		<div class="card-body">
			<a href="handlingException1" class="btn btn-danger btn-sm">예외처리1</a>
		</div>
	</div>

	<div class="card m-2">
		<div class="card-header">예외처리</div>
		<div class="card-body">
			<div class="card-header">try-catch 예외처리</div>
			<div class="card-body">
				<a href="handlingException2" class="btn btn-danger btn-sm">예외처리2</a>
				<a href="handlingException3" class="btn btn-danger btn-sm">예외처리3</a>
				<a href="handlingException4" class="btn btn-danger btn-sm">예외처리4</a>
				<a href="handlingException5" class="btn btn-danger btn-sm">예외처리5</a>
			
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>