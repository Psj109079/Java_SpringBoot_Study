<%@page import="java.util.List"%>
<%@page import="study.dao.MyCarDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	int n = Integer.parseInt(request.getParameter("n"));

	MyCarDao dao = new MyCarDao();
	
	dao.deleteCar(n);
	
	response.sendRedirect("mycarlist.jsp");
	
%>