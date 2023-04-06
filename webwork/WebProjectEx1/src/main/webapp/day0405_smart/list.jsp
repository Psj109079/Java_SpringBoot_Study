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
	
	a:link, a:hover, a:visited {
		color: black;
		text-decoration: none;
	}
</style>
</head>
<body>
<div style="margin: 30px 50px; width:700px" >
	<button type="button" class="btn btn-info" onclick="location.href='writeform'">글쓰기</button>
	<h4 class="alert alert-success">총 ${totalCount}의 게시글이 있습니다</h4>
	
	<table class = "table table-bordered">
		<tr style="background-color: #ccc">
			<th width=40>번호</th>
			<th width=300>제목</th>
			<th width=70>작성자</th>
			<th width=100>작성일</th>
			<th width=50>조회</th>
			<th width=50>추천</th>
		</tr>
		
		<c:forEach var="dto" items="${list}" varStatus="i">
			<tr>
				<td align="center">${totalCount-i.index}</td>
				<td>
					<a href="detail?num=${dto.num}">${dto.subject}</a>
				</td>
				<td align="center">${dto.writer}</td>
				<td align="center">
					<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
				</td>
				<td align="center">${dto.readcount}</td>
				<td align="center">${dto.likes}</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>
