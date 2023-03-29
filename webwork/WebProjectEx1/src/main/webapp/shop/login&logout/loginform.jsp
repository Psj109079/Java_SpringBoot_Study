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
	<form action="loginaction.jsp" method="post">
		<table>
			<tr>
				<td>
					<input type="text" name="id" placeholder="아이디">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="pw" placeholder="비밀번호">
				</td>
			</tr>
			<tr>
				<td>
					<button type="submit">로그인</button> 
				</td>
			</tr>
		</table>	
	</form>
	<form action="../add/addmemberform.jsp" method>
		<button type="submit">회원가입</button>
	</form>
</body>
</html>