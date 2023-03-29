<%@page import="java.text.SimpleDateFormat"%>
<%@page import="study.day0321.OracleShopDto"%>
<%@page import="java.util.List"%>
<%@page import="study.day0321.OracleShopDao"%>
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
	
	div.box {
		width: 40px;
		height: 40px;
		border-radius: 100px;
		border: 1px solid black;
	}
	
	table thead tr {
		background-color: #ffffcc;
	}
</style>
</head>
<body>
	<%
	
		 
			OracleShopDao dao = new OracleShopDao();
			List<OracleShopDto> list = dao.getAllSangpums();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH시");
	%>
	<table class = "table table-bordered">
		<caption align = "top">
			<h3 class = "alert alert-info">오라클 Shop 데이터 출력</h3>
		</caption>
		<thead>
			<tr>
				<th width = "50">번호</th>				
				<th width = "200">상품명</th>				
				<th width = "70">색상</th>				
				<th width = "70">수량</th>				
				<th width = "100">단가</th>				
				<th width = "200">입고일</th>				
			</tr>
		</thead>
		<tbody>
			<% int n = 1;
			for(OracleShopDto dto : list){ %>
				<tr>
					<td><%= n++%></td>
					<td><%= dto.getSangpum()%></td>
					<td>
						<div style = "background-color: <%= dto.getColor()%>" class = "box"></div>
						<b style = "font-size: 10px"><%=dto.getColor()%></b>
					</td>
					<td><%= dto.getSu()%>개</td>
					<td><%= dto.getDan()%>원</td>
					<td>
						<%= sdf.format(dto.getToday())%>
					</td>
				</tr>	
			<%}%>
		</tbody>
	</table>
</body>
</html>