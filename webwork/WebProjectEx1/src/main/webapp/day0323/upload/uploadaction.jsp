<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%
	ServletContext context=getServletContext();
	//프로젝트 webapp/save 의 실제 경로를 구한다(톰켓서버에 업로드된 프로젝트)
	String realPath=context.getRealPath("/save");
	//out.print(realPath);
	
	MultipartRequest multiRequest=null;
	//업로드할 사진의 사이즈
	int uploadSize=1024*1024*3;//3mb
	
	try{
		multiRequest=new MultipartRequest(request,realPath,uploadSize,"utf-8",
				new DefaultFileRenamePolicy());
		
		//사진의 원래이름 가져오기
		String originalName=multiRequest.getOriginalFileName("photo");
		//실제 업로드된 파일명(같은이름이 있을경우에마 변경됨)
		String uploadName=multiRequest.getFilesystemName("photo");
		//제목읽기
		String title=multiRequest.getParameter("title");
		
		//브라우저에 출력
	%>
		<h1>제 목 : <%=title %></h1>
		<h3>원래 파일명 : <%=originalName %></h3>
		<h3>업로드된 파일명 : <%=uploadName %></h3>
		<br>
		<img src="../../save/<%=uploadName%>" style="max-width: 400px" border="1">	
	<%}catch(Exception e){
		out.print("업로드하다가 오류났어요:"+e.getMessage());
	}

%>
</body>
</html>



















