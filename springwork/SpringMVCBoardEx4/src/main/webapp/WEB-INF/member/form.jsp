<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body *{

		font-family: 'Jua'

	}
</style>
</head>
<body>
<div style="margin: 30px; width: 600px;">
	<h4 class="alert alert-danger">
		총 ${totalCount}명의 회원님이 있습니다
		<i class="bi bi-house" style="float: right; font-size: 30px; cursor: pointrer; color: red;"
		onclick="location.href='/bit701'"></i>
	</h4>
	<br>
	<form action="addmember" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<caption align="top"><b>회원가입</b></caption>
			<tr>
				<th style="width: 100px; background-color: orange;">회원명</th>
				<td>
					<input type="text" name="name" required="required" autofocus="autofocus" class="form-control" style="width:120px;">
				</td>
				
				<td rowspan="4">
					<input type="file" name="upload" class="form-control" onchange="readUrl(this)" style="width: 170px;">
					<br>
					<img src=""  id="showimg" style="width:120px; height: 150px; margin-left:30px" onerror="this.src='../photo/noimage.png'" >
					
					<script type="text/javascript">
						function readUrl(input) {
							if(input.files[0]) {
								let reader = new FileReader();
								reader.onload = function(e) {
									$("#showimg").attr("src", e.target.result);
								} 
								reader.readAsDataURL(input.files[0]);
							}
						}
					</script>			
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: orange;">바밀번호</th>
				<td>
					<input type="password" name="pass" required="required" class="form-control" style="width:120px;">
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: orange;">이메일</th>
				<td>
					<div class="input-group">
						<input type="email" name="email" id="email" required="required" class="form-control">
						
						<button type="button" class="btn btn-danger btn-sm" id="btnjungbok">중복체크</button>
						
						<script>
							$("#btnjungbok").click(function() {
								$.ajax({
									type: "get",
									url: "isemail",
									dataType: "json",
									data: {"email": $("#email").val()},
									success:function(res) {
										if(res.result == "success") {
											alert("사용가능한 아이디입니다");
										} else {
											alert("이미 가입된 이메일입니다\n 다른 이메일로 가입해주세요");
											$("#email").val("");
										}
									}
								});
							});
						</script>					
					</div>
				</td>
			</tr>
			<tr>
				<th style="width: 100px; background-color: orange;">핸드폰</th>
				<td>
					<input type="text" name="hp" required="required" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<button type="submit" class="btn btn-outline-secondary" style="width: 100px;">
						정보저장
					</button>
					<button type="button" class="btn btn-outline-secondary" style="width: 100px;" onclick="location.href='list'">
						회원목록
					</button>
 				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
