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
	
기사 이미지
[OSEN=하수정 기자] '더 글로리' 김건우가 
송혜교와의 첫 촬영 에피소드와 배운 점 등을 공개했다.

23일 오전 서울 종로구 소격동에 있는 한 카페에서는 
넷플릭스 '더 글로리'의 배우 김건우의 인터뷰가 진행됐다.

넷플릭스 오리지널 시리즈 '더 글로리'(극본 김은숙, 연출 안길호)는 
유년 시절 폭력으로 영혼까지 부서진 한 여자 문동은(송혜교 분)이 
온 생을 걸어 치밀하게 준비한 처절한 복수와 그 소용돌이에 빠져드는 
이들의 이야기를 그린다. 지난해 12월 파트1에 이어 3개월 만인 
지난 10일 파트2가 오픈돼 전 세계적으로 큰 인기를 끌고 있다.
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



























