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
<%
	PersonDao dao = new PersonDao();
	List<PersonDto> list = dao.getAllPerson();
%>

<body>
	<a href = "personform.jsp">멤버 추가</a>
	<hr>
	<h3 class = "alert alert-danger">
		<b>총 <%=list.size()%>명의 멤버가 있습니다</b>
	</h3>
	<table class = "table table-bordered" style = "width: 800px">
		<tr bgcolor = "lightgray">
			<th width = "50">번호</th>
			<th width = "100">이름</th>
			<th width = "80">나이</th>
			<th width = "100">주소</th>
			<th width = "70">직업</th>
			<th width = "80">수정 / 삭제</th>
		</tr>
		<%
		int n = 1;
		Date date = new Date();
		int currYear = date.getYear() + 1900;
		for(PersonDto dto : list) {
			int age = currYear - dto.getBirthyear(); %>
			<tr>
				<td align = "center"><%=n++%></td>
				<td>
					<img src = "../image/moviestar/<%=dto.getPhoto()%>" width = "30" border = "1" hspace = "10" class = photo>
					<b><%=dto.getName()%></b>
				</td>
				<td>
					<%=age + "세 (" + dto.getBirthyear() + "년생)"%>				
				</td>
				<td><%=dto.getAdress()%></td>
				<td><%=dto.getJob()%></td>
				<td>
					<button type = "button" class = "btn btn-success btn-sm"
					onclick = "">수정</button>
					
					<button type = "button" class = "btn btn-danger btn-sm"
					onclick = "del(<%=dto.getNum()%>)">삭제</button>
				</td>
			</tr>
		<%}
		%>
		
		<script type="text/javascript">
			function del(num) {
				//alert(num);
				let b = confirm("삭제하려면 [확인]을 눌러주세요");
				if(b) {
					location.href = "deleteperson.jsp?num=" + num;
				}
			}
		</script>
</body>
</html>