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
	
	.memberphoto{
		width:50px;
		height: 50px;
		margin-right: 10px;
		border: 1px solid black;
		border-radius: 100px;
	}
</style>
</head>
<body>
	<i class="bi bi-house" style="margin: 30px 50px; font-size: 30px; cursor: pointrer; color: red;"
	onclick="location.href='/bit701'"></i>
	<hr>
	<%-- <c:if test="${sessionScope.loginok==null}">
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			location.href="../login/form";
		</script>
	</c:if>--%>
	<c:if test="${sessionScope.loginok!=null}">
		<h2>${sessionScope.loginemail}(
		<img src="../photo/${dto.photo}" class="memberphoto">
		) 님이 로그인중입니다</h2>
	</c:if>
	<hr>
	<h5 class="alert alert-danger" style="width: 700px;">총 ${totalCount} 개의 글이 있습니다</h5>
	<table class="table table-bordered" style="width: 700px;">
		<caption align="top"><h4><b>회원 게시판 목록</b></h4>
			<span style="float: right; font-size: 20px cursonr:pointer" onclick="location.href='form'">
				<i class="bi bi-pencil"></i>글쓰기
			</span>
		</caption>
		<tr style="background-color: #ddddddd">
			<th style="width: 40px">번호</th>
			<th style="width: 250px">제목</th>
			<th style="width: 70px">작성자</th>
			<th style="width: 120px">작성일</th>
			<th style="width: 70px">조회</th>
		</tr>
		<c:if test="${totalCount == 0}">
			<tr height="50">
				<td colspan="5" align="center" valign="middle">
					<b style="font-size: 1.3em">등록된 게시글이 없습니다</b>
				</td>
			</tr>
		</c:if>
		<c:if test="${totalCount > 0}">
			<c:forEach var="dto" items="${list}">
				<tr>
					<td align="center">${no}</td>
					<c:set var="no" value="${no-1}"/>
					
					<!-- 제목 -->
					<td>
						<a href="content?idx=${dto.idx}&currentPage=${currentPage}" style="color: black; text-decoration: none; cursor: pointer">
							${dto.subject}
							<!-- 사진이 있을경우 아이콘 출력 -->
							<c:if test="${dto.images != 'no'}">
								<i class="bi bi-image-fill"></i>
							</c:if>
							<c:if test="${dto.acount > 0}">
								<span style="color:red; font-size: 0.8em;">(${dto.acount})</span>
							</c:if>
						</a>
					</td>
					<td>${dto.name}</td>
					<td>
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
					</td>
					<td>${dto.readcount}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<!-- 페이징 처리 -->
	<div style="width: 700px; text-align: center; font-size: 20px">
		<!-- 이전 -->
		<c:if test="${startPage > 1}">
			<a  style="color: black; text-decoration: none; cursor: pointer" href="list?currentPage=${startPage - 1}">이전</a>		
		</c:if>
		&nbsp;
		<!-- 페이지 번호 출력 -->
		<c:forEach var="pp" begin="${startPage}"  end="${endPage}">
			<c:if test="${currentPage == pp}">
				<a  style="color: green; text-decoration: none; cursor: pointer" href="list?currentPage=${pp}">${pp}</a>
			</c:if>
			<c:if test="${currentPage != pp}">
				<a  style="color: black; text-decoration: none; cursor: pointer" href="list?currentPage=${pp}">${pp}</a>
			</c:if>
			&nbsp;
		</c:forEach>
		<!-- 다음 -->
		<c:if test="${endPage < totalPage}">
			<a  style="color: black; text-decoration: none; cursor: pointer" href="list?currentPage=${endPage + 1}">다음</a>		
		</c:if>
	</div>
</body>
</html>
