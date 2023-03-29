<%@page import="study.dto.MyCarDto"%>
<%@page import="study.dao.MyCarDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body, body * {
		font-family: 'Jua';
	}
</style>
</head>
	<%
	MyCarDao dao = new MyCarDao();
	List<MyCarDto> list = dao.getAllCars();
	%>
<body>
	<a href="mycarform.jsp">추가</a>
	<hr>
	<table class="table table-bordered" style="width:800px">
	<tr colspan = "5"><h2>총 <%=list.size()%>대의 차량이 있습니다</h2></tr>
	<tr>
		<td width="50">번 호</td>
		<td width="200">모델명</td>
		<td width="200">가격</td>
		<td width="250">구입 년,월</td>
		<td width="100">삭제</td>
	</tr>
	<%	
	for(int i = 0; i < list.size(); i++){%>
		<tr>	
			<td>
				<%=(i + 1)%>
			</td>
			<td>
				<img src = "../image/mycarimage/<%=list.get(i).getCarphoto()%>" width = "60" border = "1" hspace = "10" id="photo" data-bs-toggle="modal" data-bs-target="#myCarModal">
				<b><%=list.get(i).getCarname()%></b>
			</td>
			<td>
				<h4><%=list.get(i).getCarprice() + "원"%></h4>
			</td>
			<td>
				<h4><%=list.get(i).getGuipday() + " 구매"%></h4>
			</td>
			<td>
				<button type="button"
				onclick = "del(<%=list.get(i).getNum()%>)">삭제</button>
			</td>
		</tr>		
	<%}%>
	</table>
	
		    <!-- The Modal -->
	<div class="modal" id="myCarModal">
	    <div class="modal-dialog">
	      <div class="modal-content">
	  
	        <!-- Modal Header -->
	        <div class="modal-header">
	          <h4 class="modal-title">제품 상세</h4>
	          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	        </div>
	  
	        <!-- Modal body -->
	        <div class="modal-body">
	          <img src="" id ="view" class="modal_photo" style="width: 90%;" alt="사진나오는곳">
	          <br>
	          <h3 class="modal_title" id="title"><b>제품제목...</b></h3>
	        </div>
	  
	        <!-- Modal footer -->
	        <div class="modal-footer">
	          <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	        </div>
	  
	      </div>
	    </div>
	  </div>
</body>
	<script>
		document.getElementById("photo").onclick=function(){
			document.querySelectorAll(".modal_photo").setAttribute("src", this.getAttribute("src"));
			document.getElementById("title").innerText=this.nextElementSibling.innerText;
		}
		

     
		function del(n){
			let con = confirm("데이터를 삭제합니다");
			if(con){
				location.href = "deletecar.jsp?n=" + n;
			}
		}
	</script>
</html>