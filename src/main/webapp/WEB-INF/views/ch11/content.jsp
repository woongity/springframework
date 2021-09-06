<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">Spring Tag library</div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">
				DTO 객체와 폼 연결
			</div>
			<div class="card-body">
				<a href="form1" class="btn btn-info btn-sm">form1</a>
			</div>
		</div>
		<div class="card">
			<div class="card-header">
				DTO 객체의 필드값을 양식의 드롭다운리스트(select 태그)로 셋팅
			</div>
			<div class="card-body">
				<a href="form2" class="btn btn-info btn-sm">form2</a>
			</div>
		</div>
		<div class="card">
			<div class="card-header">
				DTO 객체의 필드값을 양식의 checkbox리스트(select 태그)로 셋팅
			</div>
			<div class="card-body">
				<a href="form3" class="btn btn-info btn-sm">form3</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>