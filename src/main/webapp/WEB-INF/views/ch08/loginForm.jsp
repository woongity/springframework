<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">login Form</div>
	<div class="card-body">
		<form method="post" action="login">
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">mid</span>
				</div>
				<input type="text" name="mid" class="form-control">
			</div>
			<div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">mpassword</span>
				</div>
				<input type="password" name="mpassword" class="form-control">
			</div>
			<div class="mt-2">
				<input class="btn btn-info btn-sm" type="submit" value="로그인" /> 
				<input class="btn btn-info btn-sm" type="reset" value="다시 작성" /> 
				<a class="btn btn-info btn-sm" href= "content" type="reset" value="다시작성">취소</a>
			</div>
		</form>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
