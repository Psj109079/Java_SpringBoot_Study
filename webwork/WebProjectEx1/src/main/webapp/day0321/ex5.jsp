<%@page import="java.util.List"%>
<%@page import="study.day0321.ShopList"%>
<%@page import="study.day0321.ShopDto"%>
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
	<% ShopList dto = new ShopList();
	
	// 데이터 가져오기
	List<ShopDto> list = dto.getSangpumList();
	%>
	
	<h2 class= "alert alert-success">상품 목록들</h2>
	<table class = "table table-bordered" style = "width: 400px">
		<tr bgcolor = "lightgray">
			<th width="250">상품</th>
			<th width="150">가격</th>
			<th width="150">색상</th>
		</tr>
		<% for(ShopDto shop : list){ %>
			<tr>
				<td>
				<img src="../image/shop/<%= shop.getSangpumPhoto()%>" style="width: 60px; height:60px">
				<%= shop.getSangpumName()%>
				</td>
				<td align = "right"><%= shop.getSangpumPrice()%>원</td>
				<td>
					<div style = "width: 40px; height: 40px;
					background-color: <%= shop.getSangpumColor()%>;
					border: 1px solid black;"></div>
					<%= shop.getSangpumColor()%>
				</td>
			</tr>
		<% }%>
	</table>
	<br>
	<table class = "table table-bordered" style = "width: 400px">
		<tr bgcolor = "lightgray">
			<th width="50">번호</th>
			<th width="250">상품</th>
			<th width="150">가격</th>
			<th width="100">색상</th>
		</tr>
		<% for(int i = 0; i < list.size(); i++){ %>
			<tr style = "color: <%= list.get(i).getSangpumColor()%>">
				<td><%= i + 1%></td>
				<td>
				<img src="../image/shop/<%= list.get(i).getSangpumPhoto()%>" style="width: 60px; height:60px">
				<%= list.get(i).getSangpumName()%>
				</td>
				<td align = "right"><%= list.get(i).getSangpumPrice()%>원</td>
				<td><%= list.get(i).getSangpumColor()%></td>
			</tr>
		<% }%>
	</table>
	
</body>
</html>