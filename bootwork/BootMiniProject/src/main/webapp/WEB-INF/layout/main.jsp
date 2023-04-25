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
	
	.mainphoto {
		width: 200px;
		height: 200px;
		border: 10px solid pink;
		border-radius: 30px;
		margin-right: 20px;
		box-shadow: 3px 3px 3px gray;
	}
	
	.mainboard {
		font-size: 20px;
		width: 300px;
		height: 200px;
		border: 2px solid gray;
		border-radius: 20px;
		text-align: center;
		padding-top: 10px;
		flex-shrink: 0;
	}
	
	.mainshop {
		font-size: 20px;
		width: 300px;
		height: 200px;
		border: 2px solid gray;
		border-radius: 20px;
		text-align: center;
		padding-top: 10px;
		margin: 0 auto;
		flex-shrink: 0;
	}
	
	.mainboard .goboard {
		cursor: pointer;
	}
</style>
</head>
<body>
		<img class="mainphoto" src="photo/images.jpg">
		<img class="mainphoto" src="photo/portrait-2268402_960_720.jpg">
		<img class="mainphoto" src="photo/woman-5718114__340.jpg">
		<br><br>
		<div style="width:800px; display: flex;">
			<div class="mainboard" >
				<b>게시판 목록</b>
				<i class="bi bi-plus-circle-fill goboard"></i>
			</div>
			
			<div class="mainshop" >
				<b>상품 목록</b>
				<i class="bi bi-plus-circle-fill goshop"></i>
			</div>
		</div>
</body>
</html>
