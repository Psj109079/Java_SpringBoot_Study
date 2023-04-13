<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body *{
		font-family: 'Jua'
	}
	
	.box {
	width: 250px;
	height: 350px;
	}
	
	.row {
		display: flex;
		flex-wrap: wrap;
		margin: -15px; /* Negative margin to counteract padding from Bootstrap */
		width: 1000px;
		margin-top: 50px;
	}
	
	.box {
		flex: 0 0 calc(33.33333% - 30px); /* Adjust width to 33.33333% minus margin */
		padding: 15px; /* Add padding to each box */
		box-sizing: border-box; /* Include padding in box dimensions */
	}
	
</style>
<script type="text/javascript">

	window.onload=function(){
		viewlist(1);
		let list = document.getElementsByClassName("list");
		
		for(let i = 0; i < list.length; i++) {
			list[i].addEventListener("click", function() {
				
				let idx = this.getAttribute("idx");
				console.log(idx);
				viewlist(idx);
			});
		}
	}
		
	function viewlist(idx) {
		console.log(idx);
		$.ajax({
			type: "get",
			url:"list",
			data: {"idx": idx},
			dataType: "json",
			success: function(res) {
				
				let s = "";
				$.each(res, function(i, e) {
					
					s += `
						<div class="box" style="width:250px; height:350px;">
							<img src="save/\${e.carphoto}" style="width:200px"><br>
							<h4>\${e.carname}</h4>
							<h4>\${e.carprice}</h4>
						</div>
					`;
				});
				$("#carlist").html(s);
			}
		});	
	}
	
	
	
	
</script>
</head>
<body>
	<div class="menu">
		<b class="list" idx="1">가격 내림차순</b>
		&nbsp;&nbsp;
		<b class="list" idx="2">가격 오름차순</b>
		&nbsp;&nbsp;
		<b class="list" idx="3">등록순</b>
	</div>
	<div id="carlist" class="row"></div>
</body>
</html>
