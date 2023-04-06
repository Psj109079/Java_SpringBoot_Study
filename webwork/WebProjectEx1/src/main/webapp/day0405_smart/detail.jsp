<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	
	.day {
		float: right;
		margin-right: 10px;
		color: #888888;
		font-size: 0.8em;
	}
</style>
</head>
<body>
<div style="margin: 30px 50px; width: 600px;">
	<h2><b>${detail.subject}</b></h2>
	<div>
		<b>${detail.writer}</b>
		<span class="day">
			<fmt:formatDate value="${detail.writeday}" pattern="yyyy-MM-dd HH:mm"/>
		</span>
	</div>
	<div style="color: #888888; margin-top: 10px">
		조회 ${detail.readcount}
		&nbsp;&nbsp;
		<span class="likes" style="cursor: pointer;">추천 ${detail.likes}</span>
	</div>
	<pre>${detail.content}</pre>
	<div>
		<button type="buttton" class="btn btn-secondary" onclick="location.href='writeform'">글쓰기</button>
		
		<button type="buttton" class="btn btn-secondary" onclick="location.href='updateform?num=${detail.num}'">수정</button>
		
		<button type="buttton" class="btn btn-secondary" onclick="del(${detail.num})">삭제</button>
		
		<button type="buttton" class="btn btn-secondary" onclick="location.href='list'">글목록</button>
	</div>
</div>

<script type="text/javascript">
	$(".likes").click(function(){
		let num = ${detail.num};
		console.log(num);
		$.ajax({
			type: "get",
			url: "../day0405_smart/likes.jsp",
			data: {"num" : num},
			dataType: "json",
			success: function(res){
				$(".likes").text("추천 " + res.like);
			}, statusCode: {
				404: function() {
					alert("파일이 없어요");
				}, 500: function() {
					alert("서버 오류... 코드를 다시한번 확인하세요");						
				}
			}
		});
	});
	
	function del(num) {
		//alert(num);
		let b = confirm("삭제하려면 [확인]을 눌러주세요");
		if(b) {
			location.href="delete?num=" + num;
		}
	}
	
	
</script>
</body>
</html>