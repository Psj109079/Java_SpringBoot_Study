<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body * {
		font-family: 'Jua';
	}
</style>
</head>
<body>
	<h4 class = "alert alert-info">[문제]post 방식의 폼태그 전송</h4>
	<form action = "action3.jsp" method = "post">
		<table class = "table table-bordered" style = "width: 400px">
			<tr>
				<th bgcolor = "lightgray" width = "100">사원명</th>
				<td>
					<input type = "text" name = "sname" required = "required"
					class = "form-control" placeholder = "사원명입력">
				</td>
			</tr>
			<tr>
				<th bgcolor = "lightgray" width = "100">성별</th>
				<td>
					<label>
					<input type = "radio" name = "gender" value = "남자" checked = "checked">
					남자
					</label>
					&nbsp;	
					<label>
					<input type = "radio" name = "gender" value = "여자">
					여자
					</label>	
				</td>
			</tr>
			<tr>
				<th bgcolor = "lightgray" width = "100">취미들</th>
				<td>
					<div class = "input-group">
						<input type = "checkbox" class = "form-check-input" name = "hobby" value = "낚시">낚시&nbsp;
						<input type = "checkbox" class = "form-check-input" name = "hobby" value = "게임">게임&nbsp;
						<input type = "checkbox" class = "form-check-input" name = "hobby" value = "채팅">채팅&nbsp;
						<input type = "checkbox" class = "form-check-input" name = "hobby" value = "여행">여행
					</div>
				</td>
			</tr>
			<tr>
				<th bgcolor = "lightgray" width = "100">이메일</th>
				<td>
					<div class = "input-group">
					<input type = "text" name = "email" style = "width: 120px" class = "form-control">
					<b>@</b>
					<select class = "form-select" name = "email2">
						<option value = "naver.com">네이버</option>
						<option value = "gmail.com">구글</option>
						<option value = "nate.com">네이트</option>
						<option value = "daum.com">다음</option>
					</select>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<button type = "submit" class = "btn btn-success">서버에 전송</button>
				</td>
			</tr>
		</table>
	</form> 
</body>
</html>