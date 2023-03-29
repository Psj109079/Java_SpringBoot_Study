<%@page import="java.text.DecimalFormat"%>
<%@page import="shop.dto.BuyListDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.BuyListDao"%>
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
	
	String id = "";
	for(Cookie c : cookies) {
		if(c.getName().equals("user") || c.getName().equals("admin")) {
			id = c.getValue();	
			break;
		}
	}
	
	BuyListDao dao = new BuyListDao();
	
	List<BuyListDto> list = dao.allBuyData(id);
	DecimalFormat df = new DecimalFormat("###,###");
%>
<body>
	<a href="../main.jsp" style="text-decoration:none; color:black;"><h3>메인으로</h3></a>
	<table class="table tableborderd">
		<tr>
			<caption style="caption-side:top; text-align:center;">구매목록</caption>
			
			<caption style="caption-side:top; text-align:center;">총 <%=list.size()%>개 구매</caption>
		
		</tr>
		<tr>
			<td>상품명</td>
			<td>사이즈</td>
			<td>가격</td>
			<td>구매일</td>
		</tr>
		<%for(int i = 0; i < list.size(); i++){%>
			<tr>
				<td>
					<a href="../detail/detailware.jsp?num=<%=list.get(i).getNum()%>"  style="text-decoration:none; color:black;">
						<img src = "../../save/<%=list.get(i).getImage()%>" width = "30" border = "1" hspace = "10" class = photo>
					</a>
					<%=list.get(i).getName()%>
				</td>
				<td>
					<%=list.get(i).getSize()%>
				</td>
				<td>
					<%=df.format(list.get(i).getPrice())%>
				</td>
				<td>
					<%=list.get(i).getBuyTime()%>
				</td>
			</tr>
			
		<%}
		%>
		<tr>
			<td colspan = 4>
				<button type="button" id="update">내정보 수정</button>
				<button type="button" id="secession">회원탈퇴</button>
			</td>
		</tr>
	</table>
	<script>
		const secession = document.getElementById("secession");
		const update = document.getElementById("update");
		
		secession.addEventListener("click", function(){
			let b=confirm("탈퇴 하시겠습니까?");
			if(b) {
				location.href="../delete/secessionaction.jsp";
			}
		});
		
		update.addEventListener("click", function(){
			location.href="../update/memberupdate.jsp";
		});
	</script>
</body>
</html>