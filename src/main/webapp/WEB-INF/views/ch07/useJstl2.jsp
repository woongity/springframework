<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="card m-2">
	<div class="card-header">
		JSTL을 이용해서 LIST 처리
	</div>
	<div class="card-body">
		<h6>[게시물 목록]</h6>
		<table class="table table-striped">
			<thead>
			<tr>
				<th scope="col">no</th>
				<th scope="col">title</th>
				<th scope="col">content</th>
				<th scope="col">writer</th>
				<th scope="col">date</th>
				
			</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td scope="row">${board.no}</td>
						<td scope="row">${board.title}</td>
						<td scope="row">${board.content}</td>
						<td scope="row">${board.writer}</td>
						<td scope="row">${board.date}</td>
						<td><fmt:formatDate value="${board.date}" pattern="yyyy-mm-dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
