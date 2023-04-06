<%@page import="study.dao.MyCarDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	MyCarDao dao = new MyCarDao();
	
	// »èÁ¦
	dao.deleteCar(num);
%>