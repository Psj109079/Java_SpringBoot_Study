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
	body, body *{
		font-family: 'Jua'
	}
	
	div.a{
		position: absolute;
		width: 200px;
		height: 400px;
		left:30px;
		top:50px;
	}
	
	div.b{
		position: absolute;
		width: 200px;
		height: 400px;
		left:400px;
		top:50px;
	}
</style>
</head>
<body>
<h4>include 예제</h4>

<div class="a">
	<jsp:include page="../day0321/ex7_mysql_person.jsp"/>
</div>

<div class="b">
	<jsp:include page="../day0321/ex3.jsp"/>
</div>
</body>
</html>

















