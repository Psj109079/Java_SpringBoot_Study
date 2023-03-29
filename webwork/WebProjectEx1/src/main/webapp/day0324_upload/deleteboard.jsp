<%@page import="java.io.File"%>
<%@page import="study.dao.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%

	// num 읽기
	int num =Integer.parseInt(request.getParameter("num"));
	
	// dao
	SimpleBoardDao dao = new SimpleBoardDao();
	
	// 만약 글 삭제시 업로드했던 사진도 save 폴더에서 지우고자 할 경우
	// 업로드했던 파일명 얻기
	String photo = dao.getData(num).getPhoto();
	// 업로드된 경로 구하기
	String realPath = getServletContext().getRealPath("/save");
	// 파일 객체 생성
	File file = new File(realPath + "/" + photo);
	file.delete();
	
	// delete
	dao.deleteBoard(num);
	
	// 목록으로
	response.sendRedirect("boardlist.jsp");
%>	