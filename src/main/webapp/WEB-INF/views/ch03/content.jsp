<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>
<div class="card m-2">
	<div class="card-header">Controller/Request Parameter</div>
	<div class="card-body">
		<div class="card m2">
			<div class="card -header">Get 방식으로 요청</div>

			<div class="card-body">
				<a class="btn btn-info btn-sm"
					href="method1?param1=문자열&param2=5&param3=3.14&param4=true&param5=2021-08-27">요청</a>
				<form method="post" action="method1">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param1</span>
						</div>
						<input type="text" name="param1" class="form-control" value="문자열"
							readonly>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param2</span>
						</div>
						<input type="text" name="param2" class="form-control" value="5"
							readonly>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param3</span>
						</div>
						<input type="text" name="param3" class="form-control" value="3.14"
							readonly>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param4</span>
						</div>
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-secondary active"> <input
								type="radio" name="param4" checked value="true"> true
							</label> <label class="btn btn-secondary"> <input type="radio"
								name="param4" value="false"> false
								
							</label>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">param5</span>
						</div>
						<input type="date" name="param5" class="form-control"
							value="2030-12-05">
					</div>
					<input class="btn btn-info" type="submit" value="요청 파라미터 전송" />
				</form>
			</div>
		</div>
	</div>
</div>
<button class="btn btn-info btn-sm" onclick ="requestGet()"></button>
<button class="btn btn-info btn-sm" onclick = "requestPost()"></button>
<script>
	function requestGet(){
		const param1 = document.form1.param1.value;
		const param2 = document.querySelector("#param2").value;
		const param3 = $("#param3").val();
		const param4 = $("form1 input[name=param4]:clicked").val();
		const param5 = $("#param5").val();
		$.ajax({
			url:"method3",
			method : "get",
			data : 
				{
				param1 :param1, 
				param2 :param2,
				param3 :param3,
				param4 : param4,
				param5 : param5
				}
		})
		.done(()=>{}); 
		console.log("param1" , param1);
		console.log("param2" , param2);
		console.log("param3" , param3);
		console.log("param4" , param4);
		console.log("param5" , param5);
		
		
	}
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
