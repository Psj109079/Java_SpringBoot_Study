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
<div style="margin: 30px; width: 500px">
	<h3 class="alert alert-danger">
		총 회원수: ${totalCount}명
		<i class="bi bi-house" style="float: right; font-size: 30px; cursor: pointrer; color: red;"
		onclick="location.href='/bit701'"></i>
	</h3>
	<br><br>
	<table class="table table-bordered">
		<c:forEach var="dto" items="${list}" >
			<tr>
				<td style="width: 220px" align="center" valign="middle">
					<img src="../photo/${dto.photo}" width="200" border="1">
				</td>
				<td style="width: 220px" valign="middle">
					회원명: ${dto.name}<br>
					핸드폰: ${dto.hp}<br>
					이메일: ${dto.email}<br>
					가입일: <fmt:formatDate value="${dto.gaipday}" pattern="yyyy-MM-dd HH:mm"/>
				</td>
			</tr>
				<c:if test="${loginEmail == dto.email}">
					<tr>
						<td colspan="2">
							<button type="button" class=" btn btn-outline-info btn-sm" onclick="location.href='updateform?num=${dto.num}'" style="margin-left: 50px;">
							수정
							</button>
							<button type="button" class=" btn btn-outline-danger btn-sm" onclick="delmember(${dto.num})">
							삭제
							</button>
						</td>
					</tr>
				</c:if>			
		</c:forEach>
	</table>
</div>
	<script>
		function delmember(num) {
			let del = confirm("삭제하려면 [확인]을 눌러주세요");
			
			if(del) {
				location.href="delete?num=" + num;
			}
		}
	</script>
</body>
</html>
