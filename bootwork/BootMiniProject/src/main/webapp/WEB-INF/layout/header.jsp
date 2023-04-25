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
	}
	
	.mainshop {
		font-size: 20px;
		width: 300px;
		height: 200px;
		border: 2px solid gray;
		border-radius: 20px;
		text-align: center;
		padding-top: 10px;
	}
	
	.mainboard .goboard {
		cursor: pointer;
	}
</style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<body>
	<a href="${root}/" style="font-size: 30px;">
		<i class="bi bi-house-heart"></i>&nbsp; SpringBoot+Tiles3+Mybatis3 Project	
	</a>
</body>
</html>
