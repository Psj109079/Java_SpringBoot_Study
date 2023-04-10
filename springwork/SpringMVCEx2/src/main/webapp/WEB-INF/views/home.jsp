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
	<h3 class="alert alert-success">213</h3>
	<h4>${requestScope.message}</h4>
	<img src="./res/image/mycar1.png" width="130">
	
	<img src="./image/mycar2.png" width="130">
	
	<h4>세션 아이디: ${sessionScope.myid}</h4>
	<h5>${today}</h5>
	<h5>
		<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm"/>
	</h5>
	<button type="button" class="btn btn-outline-danger" onclick="location.href='myshop'">
		myshop 으로 이동
	</button>
	
	<button type="button" class="btn btn-outline-danger" onclick="location.href='yourshop'">
		yourshop 으로 이동
	</button>
	
</body>
</html>
