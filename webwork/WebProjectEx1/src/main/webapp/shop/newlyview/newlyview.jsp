<%@page import="shop.dto.WareDto"%>
<%@page import="shop.dao.WareDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	Cookie[] cookies = request.getCookies();
	List<String> list = new ArrayList<>();
	
	for(Cookie c : cookies) {
		if(c.getName().equals("view")) {
			String[] arr = c.getValue().split("/");
			for(int i = 0; i < arr.length; i++) {
				list.add(arr[i]);				
			}
			break;
		}
	}
%>
<body>
	<a href="../main.jsp"><h3>메인으로</h3></a>
	<table>
		<caption>최근 본 상품</caption>
			<tr>
				<td>체크</td>
				<td>상품명</td>
				<td>가격</td>
			</tr>
			<%for(int i = 0; i < list.size(); i++){
				WareDao dao = new WareDao();
				WareDto dto = dao.wareDetail(Integer.parseInt(list.get(i))); 
			%>
				<tr>
					<td>
						<a href="../detail/detailware.jsp?num=<%=dto.getNum()%>">
							<img src = "../../save/<%=dto.getImage()%>" width = "30" border = "1" hspace = "10" class = photo>
						</a>
							<span><%=dto.getName()%></span>
						</td>
					<td>
						<span><%=dto.getPrice()%></span>
					</td>
				
				</tr>
			<%}
			%>
	</table>
</body>
</html>