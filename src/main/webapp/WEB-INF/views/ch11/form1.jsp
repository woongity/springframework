<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>


<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="card m-2">
	<div class="card-header">
		DTO 객체(Command Object)와 폼 연결
	</div>
	<div class="card-body">
		<form:form method="post" modelAttribute="member">
			<div class="form-group">
				<label for="mid">member id</label>
				<form:input type="text" class="form-control" id="mid" name="mid" path="mid"/>
			</div>
			<div class="form-group">
				<label for="mname">name</label>
				<form:input type="text" class="form-control" id="mname" name="mname" path="mname"/>
			</div>
			<div class="form-group">
				<label for="mpasswords">pw</label>
				<form:input class="form-control" id="mpassword" name="mpassword" path="mpassword"/>
			</div>
			<div class="form-group">
				<label for="mnation">member id</label>
				<form:input type="text" class="form-control" id="mnation" name="mnation" value="mnation" path="mnation"/>
			</div>
			<button type="submit" class="btn btn-primary">submit</button>
		</form:form>
	</div>
	
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
