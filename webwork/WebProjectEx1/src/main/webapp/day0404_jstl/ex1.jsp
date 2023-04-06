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
</style>
</head>
<body>
<%
	String name = "홍길동";
	String loginid = "angel";
	
	// name은 request에 저장
	request.setAttribute("name", name);
	// loginid 는 세션에 저장
	session.setAttribute("loginid", loginid);
%>

<!-- 숫자 2개 변수 선언 -->
<c:set var="su1"  value="7"/>
<c:set var="su2"  value="4"/>
<h2>su1=${su1}, su2=${su2}</h2>

	<table class="table table-bordered" style="width:300px">
		<caption align="top"><b>JSTL 연산자</b></caption>
		<tr style="background-color: #cccccc">
			<th>EL태그</th>
			<th>결과</th>
		</tr>
		<tr>
			<%-- $ 앞에 \를 붙히면 ${} 안의 내용이 그대로 나옴--%>
			<td>\${su1 + su2}</td>
			<td>${su1 + su2}</td>
		</tr>
		<tr>
			<td>\${su1 - su2}</td>
			<td>${su1 - su2}</td>
		</tr>
		<tr>
			<td>\${su1 * su2}</td>
			<td>${su1 * su2}</td>
		</tr>
		<tr>
			<td>\${su1 / su2}, \${su1 div su2}</td>
			<td>${su1 / su2}, ${su1 div su2}</td>
		</tr>
		<tr>
			<td>\${su1 % su2}, \${su1 mod su2}</td>
			<td>${su1 % su2}, ${su1 mod su2}</td>
		</tr>
		<tr>
			<td>조건연산자</td>
			<td>${su1 > su2 ? "su1이 크다" : "su2가 크다"}</td>
		</tr>
		<tr>
			<td>논리연산자</td>
			<td>${su1 > su2 && su1 > 5}, ${su1 > su2 && su1 > 5}</td>
		</tr>
		<tr>
			<td>request 영역의 변수 출력</td>
			<td>${requestScope.name}, ${name}</td> <%--requestScope = 생략가능 --%>
		</tr>
		<tr>
			<td>session 영역의 변수 출력</td>
			<td>${sessionScope.loginid}, ${loginid}</td>
		</tr>
		<tr>
			<td>session 을 이용한 조건연산자</td>
			<td>${sessionScope.loginid2==null ? "로그인 안함" : sessionScope.loginid2}</td>
		</tr>
		<tr>
			<td>session 을 이용한 조건연산자</td>
			<td>${sessionScope.loginid==null ? "로그인 안함" : sessionScope.loginid}</td>
		</tr>
	</table>
</body>
</html>