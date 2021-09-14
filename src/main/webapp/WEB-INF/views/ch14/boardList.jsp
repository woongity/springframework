<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header"></div>
	<div class="card-body">
		<table class="table table-sm table-bordered">
			<tr>
				<th style="width: 30px">번호</th>
				<th>제목</th>
				<th style="width: 100px">글쓴이</th>
				<th style="width: 100px">날짜</th>
			</tr>

			<c:forEach var="board" items="${boards}">
				<tr>
					<td>${board.bno}</td>
					<td><a href="boardDetail?bno=${board.bno}">${board.btitle}</a></td>
					<td>${board.mid}</td>
					<td><fmt:formatDate value="${board.bdate}"
							pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</table>
		<tr>
			<td colspan="4" class="text-center">
				<div>
					<a class="btn btn-outline-primary btn-sm" href="boardList?pageNo=1">[처음]</a>
					<c:if test="${pager.groupNo>1}">
						<a class="btn btn-outline-info btn-sm" href="boardList?pageNo=${pager.startPageNo-1}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}">
						<c:if test="${pager.pageNo !=i}">
							<a class="btn btn-outline-success btn-sm" href="boardList?pageNo=${i}">${i}</a>
						</c:if>
						<c:if test="${pager.pageNo ==i}">
							<a class="btn btn-outline-danger btn-sm" href="boardList?pageNo=${i}">${i}</a>
						</c:if>
						
					</c:forEach>
					<c:if test="${pager.groupNo<pager.totalGroupNo}">
						<a class="btn btn-outline-info btn-sm" href="boardList?pageNo=${pager.endPageNo+1}">[다음]</a> 
					</c:if>
					<a class="btn btn-outline-primary btn-sm"
						href="boardList?pageNo=${pager.totalPageNo}">[맨끝]</a>

				</div>
			</td>
		</tr>
		<div class="mt-2">
			<a href="boardWriteForm" class="btn btn-sm btn-info">새글쓰기</a>
		</div>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
