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
	<div style="background-color: #dddddd; width:100%; height:100%">
		<form action="loginaction" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="id" placeholder="아이디" required="required">
						<label>
							<input type="checkbox" name="saveid" ${(saveid == null or saveid == 'no') ? "" : "checked"}>아이디 저장
						</label>
					</td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input type="password" name="pass"  placeholder="비밀번호">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" >로그인</button>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<a href="joinform">회원가입</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>