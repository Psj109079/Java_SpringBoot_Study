<%@page import="shop.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.dao.MemberDao"%>
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	body, body * {
		font-family: 'Jua';
	}
</style>
</head>
<%
	MemberDao dao = new MemberDao();
	
	List<MemberDto> list = dao.getAllData();	
%>
<body>
	<form action="addmemberaction.jsp" method="post">
		<table>
			<tr>
				<td>
					<b>아이디</b>
					<br>
					<input type="text" name="id" id="id" placeholder="아이디" required="required">
				</td>
			</tr>
				<td>
					<b>비밀번호</b>
					<br>
					<input type="password" name="pw" id="pw" placeholder="비밀번호" required="required">					
				</td>
			<tr>
			</tr>
				<td>
					<input type="password" id="repw" placeholder="비밀번호 재입력" required="required">
					<br>
					<span id="alertpw"></span>
				</td>
			<tr>
			</tr>
				<td>
					<b>이름</b>
					<br>
					<input type="text" name="name" placeholder="이름입력" required="required">
				</td>
			<tr>
				<td>
					<b>주소</b>
					<br>
					<input type="text" name="address" id="address" placeholder="주소" readonly>
				</td>
			</tr>
			<tr>
				<td>
					<b>상세 주소</b>
					<br>
					<input type="text" name="detailaddress" placeholder="상세주소">
				</td>
			</tr>
				<td>
					<button type="submit" disabled=true id="submit">회원가입</button>
				</td>
			<tr>
			</tr>
		</table>
	</form>
	<script>
		document.getElementById("address").addEventListener("click", function(){ 
			//주소입력칸을 클릭하면
	        //카카오 지도 발생
			new daum.Postcode({
	            oncomplete: function(data) { //선택시 입력값 세팅
	                document.getElementById("address").value = data.address; // 주소 넣기
	                document.querySelector("input[name=detailaddress]").focus(); //상세입력 포커싱
	            }
	        }).open();
	    });
		
		const checkpw = document.getElementById("repw");
		const pw = document.getElementById("pw");
		const button = document.getElementById("submit");
		checkpw.addEventListener("input", function(){
			if(checkpw.value != pw.value) {
				document.getElementById("alertpw").innerText = "비밀번호가 일치하지 않습니다";
				button.disabled = true;
			} else {
				document.getElementById("alertpw").innerText = "";				
				button.disabled = false;
			}
		});  
	</script>
	
</body>
</html>