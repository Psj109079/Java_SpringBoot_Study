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
<%
	//form태그의 입력값을 읽어온다
	//get방식으로 읽을시 한글 안깨짐(톰켓8부터)
	String irum=request.getParameter("irum");
	String nai=request.getParameter("nai");
%>
<body>
	<h3>
		이 름 : <%=irum%><br>
		나 이 : <%=nai%>
	</h3>
	<!-- <a href="form1.jsp">다시 입력</a> --> <!-- form1.jsp로 이동 -->
	<!-- <a href="javascript:history.back()">다시 입력</a> --><!-- 이전페이지로 이동 -->
	<a href="javascript:history.go(-1)">다시 입력</a> <!--  -1:이전페이지로 이동, -2:전전페이지 -->
</body>
</html>


















