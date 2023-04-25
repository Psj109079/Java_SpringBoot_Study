<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
	
	a:link, a:visited, a:hover {
		color: black;
		text-decoration: none;
	}
	
	div.sublayout header, div.sublayout section {
		border: 0px solid gray;
		position: absolute;
	}
	
	div.sublayout .header {
		width: 100%;
		top: 10px;
		left: 0px;
		text-align: center;
		height: 100px;
		line-height: 100px;
		background-color: #f0ffff;
	}
	
	div.sublayout .menu {
		width: 100%;
		top: 110px;
		left: 0px;
		text-align: center;
		height: 90px;
		line-height: 80px;
		font-size: 20px;
	}
	
	div.sublayout {
		display: flex; /* use flexbox */
  		justify-content: center; /* center items horizontally */
  		align-items: center;
	    height: 100vh; /* body의 높이를 100vh로 설정하여 화면 중앙에 정렬 */
	    text-align: center; /* main 섹션의 내용을 가운데로 정렬 */
	}
	
	div.sublayout .main {
	    width: 800px;
	    height: 500px;
	    margin-top: 60px;
	    font-size: 16px;
	   
	}
</style>
</head>
<body>
	<div class="sublayout">
		<header class="header">
			<tiles:insertAttribute name="header"/>			
		</header>
		<section class="menu">
			<tiles:insertAttribute name="menu2"/>
		</section>
		<section class="main">
			<tiles:insertAttribute name="main2"/>
		</section>
	</div>
</body>
</html>
