<%@page import="java.text.DecimalFormat"%>
<%@page import="shop.dto.WareDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.WareDao"%>
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
	
	#ware {
	  display: flex;
	  flex-wrap: wrap;
	  text-align: center;
	}
	
	#ware > div {
	  width: 20%;
	  padding: 10px;
	  box-sizing: border-box;
	}
	
	#my-buttons {
	  display: flex;
	  justify-content: space-between;
	  align-items: center;
	  gap: 10px;"
	}
</style>
</head>
<%	
	Cookie[] cookies = request.getCookies();
	Cookie cookie = new Cookie("guest", "guest");
	boolean flag = false;
	String name = "";
	String val = "";
	for(Cookie c : cookies) {
		if(c.getName().equals("user") || c.getName().equals("admin")){
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
			
			name = c.getName();
			val = c.getValue();
			flag = true;
		}
	}
	
	if(flag == false){
		cookie.setPath("/");//쿠키저장위치를 루트(/) 로 설정
		cookie.setMaxAge(60*60);//1시간 설정
		response.addCookie(cookie);//브라우저에 쿠키 추가
		name = cookie.getName();
		val = cookie.getValue();
	} 
	
	WareDao wDao = new WareDao();
	List<WareDto> list = wDao.allSearchWare();
	DecimalFormat df = new DecimalFormat("###,###");
%>
<body>
	<h2>SHOP</h2>
	<div id="my-buttons">
		<% if(name.equals("guest") && val.equals("guest")){%>
			<form action="login&logout/loginform.jsp" method="post">
				<button type="submit">로그인</button>
			</form>
			<form action="login&logout/loginform.jsp" method="post">
				<button type="submit">마이페이지</button>
			</form>
		<%
		} else { %>
			<form action="login&logout/logoutaction.jsp" method="post">
				<span><%= val + "님" %></span>
				<button type="submit">로그아웃</button>
			</form>
			<form action="mypage/mypage.jsp" method="post">
				<button type="submit">마이페이지</button>
			</form>
		<%
		 }%>
		
		<form action="newlyview/newlyview.jsp" method="post">
			<button type="submit">최근 본 상품</button>
		</form>
		<form action="basket/basketlistform.jsp" method="post">
			<button type="submit">장바구니</button>
		</form>
		<%if(name.equals("admin") && val.equals("admin")){ %>
			<form action="add/addwareform.jsp">
				<button type="submit">상품 추가</button>
			</form>
		<%}%>
	</div>
		<hr>

		<div id="ware">
			<%for(int i = 0; i < list.size(); i++) { %>
				<div style="border: 1px solid gray; margin: 10px;">
					 <a href="detail/detailware.jsp?num=<%=list.get(i).getNum()%>" style="text-decoration: none;">
						<img src="../save/<%=list.get(i).getImage()%>" style="width:130px; height:150px">
						<br>
						<span  style="color: black;"><%=list.get(i).getName()%></span>
						<br>
						<span  style="color: black;"><%=df.format(list.get(i).getPrice())%></span>
					</a>
				</div>
				<%if(i % 5 == 4) {%>
					<br>
				<%}	
			}%>
		</div>	
	
</body>
</html>