<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header"></div>
	<div class="card-body">
		<h6>[지정한 횟수만큼 반복]</h6>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">No</th>
					<th scope="col">Language</th>
				</tr>
			</thead>
			<tr>
				<c:forEach var="lang" items="${langs}" varStatus="status">
					<c:if test="${status.first}">
						<tbody>
					</c:if>
					<tr>
						<th scope="row">${status.index}</th>
						<th>${lang}</th>
					</tr>
					<c:if test="${status.last}">
						</tbody>
					</c:if>
				</c:forEach>
			</tr>
		</table>

		<h6 class="mt-3">[배열의 항목 수 만큼 반복]</h6>
		<%-- 
		${status.index}<br/>        <!– 0부터의 순서 –>
		${status.count}<br/>        <!– 1부터의 순서 –>
		${status.first}<br/>          <!– 현재 루프가 처음인지 반환 –>
		${status.last}<br/>           <!– 현재 루프가 마지막인지 반환 –> 
		--%>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>