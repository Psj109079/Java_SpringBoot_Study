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
	div.box {
		width: 600px;
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body>
	<div class="box">
		<form action="join" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id">
						<button type="button" id="duplicate">중복확인</button>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="pass" id="pass">
					</td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td>
						<input type="password" id="passchk"><br>
						<span style="color:red" id="alert"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit" disabled id="jbutton">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script>
	
		var jbutton = document.getElementById("jbutton");
		var passchk = document.getElementById("passchk");
		var alert = document.getElementById("alert");
		
		passchk.addEventListener("input", function() {
			let pass = document.getElementById("pass");
			
			if(passchk.value != pass.value) {
				jbutton.disabled = true;
				alert.innerText = "비밀번호를 확인해주세요";
			} else {
				jbutton.disabled = false;
				alert.innerText = "";
			}
			
		});
	</script>
</body>
</html>