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
%>
<body>
<%
if(b){
%>
<pre>
	미스터트롯 출신 가수 정동원(16)이 동부간선도로에서 오토바이를 몰다 경찰에 적발됐다.


서울 동대문경찰서는 23일 고속도로에서 오토바이를 운전한 
가수 정동원을 도로교통법 위반 혐의(통행 등의 금지)로 불구속 입건했다.


정동원은 이날 오전 0시16분께 서울 동부간선도로에서 
오토바이를 불법 주행한 혐의를 받는다. 
2007년 3월19일 생인 정동원은 
지난 21일 원동기 운전면허를 취득한 것으로 알려졌다.
</pre>
<%}else{%>
	<script type="text/javascript">
		alert("먼저 로그인후 기사를 확인하세요");
		history.back();
	</script>
<%}
%>
</body>
</html>



























