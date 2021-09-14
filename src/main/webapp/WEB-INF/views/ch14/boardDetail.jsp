<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">게시물 내용</div>
	<div class="card-body">
		<div>
			<div>
				<div>
					<span>번호:</span> <span>${board.bno}</span> <br /> <span>제목:</span>
					<span>${board.btitle}</span> <br /> <span>글쓴이:</span> <span>${board.mid}</span>
					<br/> <span class="title">날짜:</span> <span><fmt:formatDate
							value="${board.bdate}" pattern="yyyy-MM-dd HH.mm.ss" /></span> <br />
				</div>
				<div>
					<span class="title">내용:</span> <br />
					<textarea style="width: 100%" readonly>${board.bcontent}</textarea>
				</div>
				<a class="btn btn-info btn-sm" href="boardDelete?bno=${board.bno}">삭제</a>
				<a class="btn btn-info btn-sm" href="boardUpdateForm?bno=${board.bno}">수정</a>
				<a class="btn btn-info btn-sm" href="boardList">목록</a>
			</div>
		</div>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
