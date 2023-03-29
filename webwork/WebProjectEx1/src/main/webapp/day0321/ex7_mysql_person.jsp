<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="study.dto.PersonDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.PersonDao"%>
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
	body, body * {
		font-family: 'Jua';
	}
</style>
</head>
<body>
	<%
	PersonDao dao = new PersonDao();
	List<PersonDto> list = dao.getAllPerson();
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<table class = "table table-bordered" style= "width: 400px">
		<caption align = "top">
			<h4 class = "alert alert-danger">Mysql Person 직원들</h4>
		</caption>
		<%for(PersonDto dto : list){
			// 나이
			int now = Integer.parseInt(sdf.format(date).substring(0,4));
			// 띠
			int mod = dto.getBirthyear() % 12;
			String ddi = mod == 0 ? "닭" : mod == 1 ? "원숭이" : mod == 2 ? "개" : mod == 3 ? "돼지" : mod == 4 ? "쥐" : mod == 5 ? "소" : mod == 6 ? "호랑이" : mod == 7 ? "토끼" : mod == 8 ? "용" : mod == 9 ? "뱀" : mod == 10 ? "말" : "양";
		%>
			<tr>
				<td align = "center">
					<img src = "../image/moviestar/<%=dto.getPhoto()%>" style="width:150px; hight:200px">
				</td>
				<td valign = "middle">
					<h3>이름: <%=dto.getName()%></h3>
					<h3>
					<%=dto.getBirthyear()%>년생(<%=now - dto.getBirthyear() + "세 "%><%=ddi%>띠)
					</h3>
					<h3>주소: <%=dto.getAdress() %></h3>
					<h3>직업: <%=dto.getJob() %></h3>
				</td>
			</tr>
		<% } %>
	</table>
	<button type="button" id = "join"><a href = "ex7_join.jsp">회원가입</a></button>
	<button type="button" id = "secession"><a href = "ex7_secession.jsp">탈퇴</a></button>
</body>
</html>