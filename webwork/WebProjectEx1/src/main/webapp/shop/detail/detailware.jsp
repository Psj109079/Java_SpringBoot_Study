
<%@page import="java.text.DecimalFormat"%>
<%@page import="shop.dao.WareDao"%>
<%@page import="shop.dto.WareDto"%>
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
	 .product-table {
        display: flex;
        align-items: center;
    }
    .product-table td:first-child {
        text-align: center;
    }
    .product-table img {
        height: 300px;
    }
    .product-table td:last-child {
        padding-left: 20px;
    }
</style>
</head>
<%

	int num = Integer.parseInt(request.getParameter("num"));
	WareDao dao = new WareDao();
	WareDto dto = dao.wareDetail(num);
	DecimalFormat df = new DecimalFormat("###,###");
	
	Cookie[] cookies = request.getCookies();
	String val = "";
	boolean flag = false;
	for(Cookie c : cookies) {
		if(c.getName().equals("view")) {
			if(!c.getValue().contains(String.valueOf(num))) {
				c.setValue(c.getValue() + "/" + String.valueOf(num));				
			}
			c.setPath("/");
			c.setMaxAge(60*60);
			response.addCookie(c);
			flag = true;
			break;
		}
	}
	
	if(flag == false) {
		Cookie cookie = new Cookie("view", String.valueOf(num));
		cookie.setPath("/");
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
	}
%>
<body>
	<a href="../main.jsp" style="text-decoration:none; color:black;"><h3>메인으로</h3></a>
	<form method="post" name="form" >
		<input type="hidden" name="num" value="<%=num%>">
		<table class="product-table">
		    <tr>
		        <td>
		            <img src="../../save/<%=dto.getImage()%>" name="image">
		        </td>
		        <td>
		            <h3><%=dto.getName()%></h3>
		            <select class="form-select" name="size" id="size">
		                <option value="" selected disabled hidden>사이즈</option>
		                <% String[] arr = dto.getSize().split(" ");
		                   for(int i = 0; i < arr.length; i++) { %>
		                    <option value="<%=arr[i]%>"><%=arr[i]%></option>
		                <% } %>
		            </select>
		            <h3><%=df.format(dto.getPrice())%>원</h3>
		            <%
		            for(Cookie c : cookies) {
		                if(c.getName().equals("user") || c.getName().equals("admin")) { %>
		                    <button type="submit" onclick="javascript: form.action='../add/addbasket.jsp'">장바구니</button>
		                    <button type="submit" onclick="javascript: form.action='../add/addbuy.jsp'">구매</button>
		                <% }
		                if(c.getName().equals("guest")) { %>
		                    <button type="submit" onclick="javascript: form.action='../login&logout/loginform.jsp'">장바구니</button>
		                    <button type="submit" onclick="javascript: form.action='../login&logout/loginform.jsp'">구매</button>
		                <% }
		                if(c.getName().equals("admin")) { %>
		                    <button type="submit" onclick="javascript: form.action='../update/wareupdateform.jsp'">수정</button>
		                    <button type="button" id="delete" onclick="deleteWare(<%=dto.getNum()%>)">삭제</button>
		                <% }
		            } %>
		        </td>
		    </tr>
		</table>
	</form>
	<script>
		function check() {
			if(document.getElementById("size") == ""){
				alert("사이즈를 선택해주세요");
				size.focus(); 
			return false;
			}
		}	
		
		function deleteWare(num) {
			var form = document.getElementById("delete");
			let b=confirm("상품을 삭제 하시겠습니까?");
			console.log(1);
			if(b) {
				location.href = "../delete/deletewareaction.jsp?num=" + num;
			}
		}
	</script>
</body>
</html>