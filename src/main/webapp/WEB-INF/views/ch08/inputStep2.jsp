<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">2단계 입력</div>
	<div class="card-body">
		<form method= "post" action="inputDone">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">data3</span>
				</div>
				<input type="text" id="data3" name="data3" class="form-control"
					value="${inputForm.data3}">
			</div>

			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">data4</span>
				</div>
				<input type="text" id="data4" name="data4" class="form-control"
					value="${inputForm.data4}">
			</div>
			<a class="btn btn-info" href="inputStep1" >이전 단계</a> 
			<input class="btn btn-info" type="submit" value="최종처리" />
		</form>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>