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
</style>
</head>
<body>
  <%
  	//세션에 저장되어있는 아이디를 얻는다
  	String loginid=(String)session.getAttribute("loginid");  
  %>
  <h3 class="input-group  alert alert-danger">
  	<b><%=loginid %> 님이 로그인중입니다</b>
  	
  	<button type="button" class="btn btn-danger"
  	onclick="location.href='logoutaction.jsp'"
  	style="margin-left: 100px">세션로그아웃</button>
  </h3>
</body>
</html>
























