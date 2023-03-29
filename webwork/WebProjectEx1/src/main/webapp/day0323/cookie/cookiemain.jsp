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
	body, body *{
		font-family: 'Jua'
	}
</style>
</head>
<body>
<h3>Cookie 로 기사보기 예제</h3>
<hr>
<%
	boolean b=false;//amho 쿠키가 존재하면 true 변경
	//브라우저에 저장된 모든 쿠키값들을 얻는다
	Cookie []cookies=request.getCookies();
	if(cookies!=null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			String cname=cookies[i].getName();
			String cvalue=cookies[i].getValue();
			if(cname.equals("amho") && cvalue.equals("1234")){
				//amho 쿠키가 존재하므로 b를 true로 변경한다
				b=true;
			}
		}
	}
	
	if(b){%>
		<!-- amho 쿠키가 있는경우-로그인을 이미 한경우 -->
		<jsp:include page="logout.jsp"/>
	<%}else{%>
		<jsp:include page="login.jsp"/>
	<%}
%>
<h3 style="margin-left: 100px;width:300px;margin-top: 30px">오늘의 주요 기사</h3>
<jsp:include page="paper.jsp"/>
</body>
</html>










































