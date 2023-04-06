<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	<h4 class = "alert alert-info">MyCar 데이터 추가</h4>
	<form action= "mycaraction.jsp" method = "post">
		<table class = "table table-bordered" style = "width: 400px">
			<tr>
				<th>차 이름</th>
				<td>
					<input type = "text" name = "carname" required="required" class = "form-control">
				</td>
			</tr>
			<tr>
				<th>가 격</th>
				<td>
					<input type = "text" name = "carprice" class = "from-control"> 
				</td>
			</tr>
			<tr>
				<th>사 진</th>
				<td>
					<select name = "photo" id = "photo">
						<%
						for(int i = 1; i <= 15; i++) { %>
							<option value = "<%="mycar" + i + ".png"%>"><%="mycar" + i + ".png"%></option>
						<%}%>
					</select>
				</td>
			</tr>
			<tr>
				<th>구입 년,월</th>
				<td>
					<select name = "year">
						<%
						Date date = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						int year = Integer.parseInt(sdf.format(date).substring(0, 4));
						
						for(int i = year; i >= 1900; i--){ %>
							<option value = "<%=i%>"><%=i + "년"%></option>
						<%}%>
					</select>
					&nbsp;&nbsp;
					<select name = "month">
						<%
						for(int i = 1; i <= 12; i++){ %>
							<option value = "<%=i%>"><%=i + "월"%></option>
						<%}%>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<button type = "submit" class = "btn btn-success">서버에 전송</button>
				</td>
			</tr>
		</table>
	</form>
	
	<img src="../image/mycarimage/mycar1.png" width= "200" id = "view"
	style = "position: absolute; left: 410px; top: 100px">
	<script>
		document.getElementById("photo").onchange=function() {
			document.getElementById("view").setAttribute("src", "../image/mycarimage/" + this.value);
		}
	
	</script>
	
</body>
</html>