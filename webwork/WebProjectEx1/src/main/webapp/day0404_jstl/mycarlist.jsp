<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h3>mycarlist</h3>
<br>
<h3>총 ${size} 대 차량</h3>
<table class="table table-bordered">
		<tr>
			<c:forEach var="dto" items="${data}" varStatus="i">
				<td>
					<img src="../image/mycarimage/${dto.carphoto}" style="width:150px;">
					<br>
					${dto.carname}
					<br>
					${dto.carprice}
					<br>
					${dto.guipday}월 구입
				</td>
				<c:if test="${i.count % 3 == 0}">
					</tr>
					<tr>
				</c:if>
			</c:forEach>	
		</tr>
</table>
</body>
</html>