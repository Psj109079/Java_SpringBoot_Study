<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../commonvar.jsp" %>

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
	<button type="button" class="btn btn-sm btn-outline-danger" onclick="location.href='shopform'" style="margin-bottom: 10px">
	상품등록
	</button>
	<h5 class="alert alert-success">
		총 ${totalCount}개의 상품이 등록되어있습니다
		<span style="float:right;">
			<button type="button" class="btn btn-sm btn-outline-danger" onclick="location.href='list'"
			style="margin-bottom: 10px;">자세히 확인</button>
		</span>
	</h5>
	
	<div style="width: 900px">
	<c:forEach var="dto" items="${list}">
			<div style="width:160px; display: inline-block; margin-right: 15px; margin-bottom: 15px;" onclick="location.href='detail?num=${dto.num}'">
				<img src="http://${imageUrl_small}/shop/${dto.photo}?type=f&w=160&h=160&faceopt=true&ttype=jpg">
				<b>${dto.sangpum}</b>
			</div>
	</c:forEach>		
	</div>
	
</body>
</html>
