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
	중국발 황사가 23일 오후부터 
	우리나라로 유입되면서 
	서울 등 수도권 일부에 올봄 첫 황사가 나타날 것으로 보인다. 
	미세먼지는 24일까지 한반도에 ‘나쁨’ 수준으로 잔류할 예정이다.


	23일 기상청과 국립환경과학원은 
	이날 오후부터 영동과 영남, 제주도를 제외한 
	전국 미세먼지 농도가 ‘나쁨~매우 나쁨’ 수준까지 치솟을 것으로 내다봤다. 
	경기, 인천 지역에는 황사 위기 경보 ‘관심’ 단계가 발령되기도 했다.
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



























