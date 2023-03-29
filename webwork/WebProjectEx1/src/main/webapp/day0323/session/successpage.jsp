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
	//로그인 상태인지 확인
	String loginstate=(String)session.getAttribute("loginstate");
	
	if(loginstate==null){%>
		<h3>이 페이지를 보려면 먼저 로그인을 해주세요</h3>
		<a href="sessionmain.jsp">메인페이지</a>
	<%}else{%>
		
		<jsp:include page="sessionlogout.jsp"/>
		<hr>
		<%for(int i=1;i<=15;i++){
			String path="../../image/mycar/mycar"+i+".png";
		 %>
		 	<img src="<%=path%>" width="100" height="100" border="1"
		 	style="margin:5px 5px;">
		<%}
	}
%>
</body>
</html>



















