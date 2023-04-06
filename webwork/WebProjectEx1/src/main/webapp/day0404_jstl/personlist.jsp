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
<h3 class="alert alert-success">Person List</h3>
<br>
<h3>총 ${size} 명</h3>

<table class="table table-bordered">
	<tr>
		<th width="50">번호</th>
		<th width="150">이름</th>
		<th width="60">출생 년도</th>
		<th width="70">주소</th>
		<th width="100">직업</th>
	</tr>
	<c:forEach var="dto" items="${list}" varStatus="i">
		<tr>
			<td>${dto.num}</td>
			<td>
				<img src="../image/moviestar/${dto.photo}" style="width: 60px;" hspace="10">
				${dto.name}
			</td>
			<td>${dto.birthyear}년도<br>
				<c:choose>
					<c:when test="${dto.birthyear % 12 == 0}">
						(원숭이띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 1}">
						(닭띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 2}">
						(개띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 3}">
						(돼지띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 4}">
						(쥐띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 5}">
						(소띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 6}">
						(호랑이띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 7}">
						(토끼띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 8}">
						(용띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 9}">
						(뱀띠)
					</c:when>
					<c:when test="${dto.birthyear % 12 == 10}">
						(말띠)
					</c:when>
					<c:otherwise>
						(양띠)
					</c:otherwise>
					
				</c:choose>
			</td>
			<td>${dto.address}</td>
			<td>${dto.job}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>