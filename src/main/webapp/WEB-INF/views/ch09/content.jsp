<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">

	<div class="card-header">FileUpload & FileDownload</div>
	<div class="card-body">
		<div class="card">
			<div class="card-header">form 태그를 사용할 fileupload</div>
			<div class="card-body">
				<form method="post" enctype="multipart/form-data"
					action="fileupload">
					<div class="form-group">
						<label for="title">제목 </label> <input type="text"
							class="form-control" name="title" id="title" placeholder="파일이름">
					</div>
					<div class="form-group">
						<label for="desc">File Description</label> <input type="text"
							class="form-control" name="desc" id="desc" placeholder="파일설명">
					</div>
					<div class="form-group">
						<label for="attach">Example file input</label> <input type="file"
							class="form-control-file" id="attach" name="attach" multiple>
					</div>
					<button class="btn btn-info btn-small" type="submit">파일
						업로드</button>
					<a href="javascript:fileupload()" class="btn btn-info btn-sm">AJAX파일
						업로드</a>
				</form>
			</div>
			<script>
				function fileupload(){
					// 입력된 정보를 얻음 
					const title = $("#title").val();
					const desc = $("#desc").val();
					const attach = document.querySelector("#attach").files[0];
					console.log(attach);
					
					// multipart/form-data
					const formData = new FormData();
					formData.append("title",title);
					formData.append("desc",desc);
					formData.append("attach",attach);
					
					$.ajax({
						url : "fileuploadAjax",
						method : "post",
						data : formData,
						cache : false,
					/* 있는 그대로 보내야함 */
						processData : false,
						contentType : false
					})
					.done((data)=>{
						console.log(data);
						if(data.result==="success"){
							window.alert("파일전송이 성공함");
						}
					});
				}
			</script>
		</div>
	</div>
	<div class="card-body">
		<div class="card">
			
		</div>
		<div class="card">
			<div class="card-header">
				file download
			</div>
			<div class="card-body">
				<a href= "filedownload?savedname=photo1.jpg" class="btn btn-info btn-sm">파일 다운로</a>
			</div>
			<hr>
			<img src="filedownload?savedname=photo1.jpg" width="200px">
		</div>
	</div>

</div>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
