<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ include file="../commonvar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body, body *{
		font-family: 'Jua'
	}
</style>
<script>
	$(function() {
		$("#btndel").click(function() {
			// 비번
			let pass = $("#pass").val();
			let num = ${dto.num};
			console.log(pass);
			console.log(num);
			$.ajax({
				type: "get",
				url: "./delete",
				data: {"num":num,"pass":pass},
				dataType: "json",
				success:function(res) {
					if(res.result == "success") {
						alert("삭제되었습니다");
						location.href="./list?currentPage=" + ${currentPage}; // 보던 페이지로 이동
					} else {
						alert("비밀번호가 맞지 않습니다");
					}
				}
			});
		});
		
		$("#btnupdate").click(function() {
			// 비번
			let pass = $("#updatepass").val();
			let num = ${dto.num};
			let cp = ${currentPage};
			console.log(pass);
			console.log(num);
			$.ajax({
				type: "get",
				url: "./chkpass",
				data: {"num":num,"pass":pass},
				dataType: "json",
				success:function(res) {
					if(res.result == "success") {
						location.href=`./updateform?num=\${num}&currentPage=\${cp}`;
					} else {
						alert("비밀번호가 맞지 않습니다");
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- The Modal(수정) -->
	<div class="modal" id="myUpdateModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
			
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글 수정</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				
				<!-- Modal body -->
				<div class="modal-body">
					<b>수정하려면 비밀번호를 입력해주세요</b>
					<br>
					<div class="input-group" style="width: 160px; margin-left: 50px;">
						<input type="password" id="updatepass" class="form-control">
						
						<button type="button" class="btn btn-danger btn-sm" id="btnupdate" data-bs-dismiss="modal">수정</button>
					</div>
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
				</div>
				
			</div>
		</div>
	</div>



	<!-- The Modal(삭제) -->
	<div class="modal" id="myDeleteModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
			
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글 삭제</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				
				<!-- Modal body -->
				<div class="modal-body">
					<b>삭제하려면 비밀번호를 입력해주세요</b>
					<br>
					<div class="input-group" style="width: 160px; margin-left: 50px;">
						<input type="password" id="pass" class="form-control">
						
						<button type="button" class="btn btn-danger btn-sm" id="btndel" data-bs-dismiss="modal">삭제</button>
					</div>
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
				</div>
				
			</div>
		</div>
	</div>
	

	<div style="width: 600px;">
		<h2><b>${dto.subject}</b></h2>
		<h5><b>${dto.writer }</b>
			<b>pass = ${dto.pass }</b>
			<span style="float: right; color:#dddddd; font-size: 13px;">
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
			</span>
		</h5>
		<b style="color: #cccccc">조회 ${dto.readcount}</b>
		<br><br>
		<pre>${dto.content}</pre>
		<br><br>
		<c:if test="${dto.filename != '' }">
			<img src="https://${imageUrl}/board/${dto.filename}" style="max-width: 500px;">
		</c:if>
		
	</div>
	
	<div style="margin-top: 20px; margin-left: 20px;">
		<button type="button" class="btn btn-outline-danger btn-sm" style="width: 70px;" onclick="location.href='./writeform?num=${dto.num}&ref=${dto.ref}&step=${dto.step}&depth=${depth}&currentPage=${currentPage}'">답글</button>
		<button type="button" class="btn btn-outline-danger btn-sm" style="width: 70px;" onclick="location.href='./writeform'">글쓰기</button>
		<button type="button" class="btn btn-outline-danger btn-sm" style="width: 70px;" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
		<button type="button" class="btn btn-outline-danger btn-sm" style="width: 70px;"
		data-bs-toggle="modal" data-bs-target="#myUpdateModal">수정</button>
		<button type="button" class="btn btn-outline-danger btn-sm" style="width: 70px;"
		data-bs-toggle="modal" data-bs-target="#myDeleteModal">삭제</button>
	</div>
</body>
</html>
