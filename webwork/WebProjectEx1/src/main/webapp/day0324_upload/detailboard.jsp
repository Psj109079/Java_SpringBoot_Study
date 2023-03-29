<%@page import="java.text.SimpleDateFormat"%>
<%@page import="study.dto.SimpleBoardDto"%>
<%@page import="study.dao.SimpleBoardDao"%>
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
	.day{
		color: gray;
		font-size: 12px;
		float: right;
		
	}
</style>
</head>
 <%
 	// num 읽기
 	int num = Integer.parseInt(request.getParameter("num"));
 	
 	// dao 선언
 	SimpleBoardDao dao = new SimpleBoardDao();
 	
 	// 조회수 증가
 	dao.updateReadCount(num);
 	
 	// dto 얻기
 	SimpleBoardDto dto = dao.getData(num);
 	
 	// 날짜 출력형식
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
 	
 %>
<body>
	<div style="matgin: 30px 50px">
		<table class="table" style="width: 800px;">
			<tr>
				<td>
					<h3><b><%=dto.getSubject()%></b></h3>
				</td>
			</tr>
			<tr>
				<td>
					<h3><b><%=dto.getWriter()%></b></h3>
					<span class="day"><%= sdf.format(dto.getWriteday()) %></span>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<span style="color: gray; font-size: 13px">조회<b><%=dto.getReadcount()%></b></span>
					<br><br>
					<!--  저장시 br 이 \n 으로 db에 저장됨
					그래서 출력시 다시 br로 바꿔야한다
					
					두번째 방법은 pre 태그안에 출력하면 자동으로 줄이 넘어감 -->
					<%=dto.getContent().replace("\n", "<br>")%>
					<br><br>
					<%if(dto.getPhoto() != null) { %>					
						<h5><b>업로드한 사진</b></h5>
						
						<!-- 사진을 가져오다가 오류 발생시 사진을 안보이게 해준다 -->
						<%-- <img src="../save/<%=dto.getPhoto()%>" style="max-width: 300px"
						onerror = "this.style.display = 'none'"> --%>
						
						<!-- 사진을 가져오다가 오류 발생시 대체 이미지 보여주기 -->
						<img src="../save/<%=dto.getPhoto()%>" style="max-width: 300px"
						onerror = "this.src='../../image/No_image.png'">
					<%}%>
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;" onclick= "location.href='boardform.jsp'"><i class="bi bi-pen"></i>&nbsp;글쓰기</button>
					
					<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;" onclick= "location.href='updateboardform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-eraser"></i>&nbsp;수정</button>
					
					<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;" onclick="del(<%=dto.getNum()%>)"><i class="bi bi-trash3"></i>&nbsp;삭제</button>
					
					<button type="button" class="btn btn-outline-secondary btn-sm"
					style="width: 80px;" onclick= "location.href=location.href='boardlist.jsp'"><i class="bi bi-list"></i>&nbsp;목록</button>
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		function del(num){
			// console.log(num);
			let con = confirm("삭제를 하려면 [확인]을 눌러주세요");
			if(con){
				location.href="deleteboard.jsp?num=" + num;
			}
		}
	</script>
</body>
</html>